package life.majiang.community.controller;

import life.majiang.community.dto.PageinationDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author c_sir
 * @create 2020-03-20 12:39
 */
@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name="action") String action,
                          @RequestParam(name="page",defaultValue = "1") Integer page,
                          @RequestParam(name="size", defaultValue = "3")Integer size,
                          HttpServletRequest request,
                          Model model){

        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            return "redirect:/";
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    UserExample userExample = new UserExample();
                    userExample.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(userExample);
                    if (users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                        user = users.get(0);
                    }
                    break;
                }
            }
        }
        if(user == null){
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PageinationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pagination", paginationDTO);
        } else if ("replies".equals(action)) {
            PageinationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("section", "replies");
            model.addAttribute("pagination", paginationDTO);
            model.addAttribute("sectionName", "最新回复");
        }
        PageinationDTO pageinationDTO = questionService.list(user.getId(),page,size);
            model.addAttribute("pagination", pageinationDTO);
        return "profile";
    }
}
