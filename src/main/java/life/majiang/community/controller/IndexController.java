package life.majiang.community.controller;

import life.majiang.community.dto.PageinationDTO;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author c_sir
 * @create 2020-03-05 12:48
 */

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(Model model,    //(@RequestParam(name = "name") String name, Model modle)
                        @RequestParam (name = "page", defaultValue = "1") Integer page,
                        @RequestParam (name = "size", defaultValue = "3") Integer size){
        PageinationDTO PageinationDTO = questionService.list(page, size);
        model.addAttribute("pagination", PageinationDTO);
        return "index"; //这里的hello必须是hello 其他的都不行，因为resuorces/template下面的HTML文件名是hello
    }
}
