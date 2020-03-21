package life.majiang.community.controller;

import life.majiang.community.dto.PageinationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author c_sir
 * @create 2020-03-05 12:48
 */

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,    //(@RequestParam(name = "name") String name, Model modle)
                        @RequestParam (name = "page", defaultValue = "1") Integer page,
                        @RequestParam (name = "size", defaultValue = "3") Integer size){
      //  modle.addAttribute("name", name);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    System.out.println("我拿到token了~~~~~~~~~~~~~~~");
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        PageinationDTO PageinationDTO = questionService.list(page, size);
        model.addAttribute("pagination", PageinationDTO);
    return "index"; //这里的hello必须是hello 其他的都不行，因为resuorces/template下面的HTML文件名是hello
    }
}
