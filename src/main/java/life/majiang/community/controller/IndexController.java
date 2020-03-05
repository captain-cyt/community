package life.majiang.community.controller;

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
    @GetMapping("/")
    public String index(){    //(@RequestParam(name = "name") String name, Model modle)
      //  modle.addAttribute("name", name);
    return "index"; //这里的hello必须是hello 其他的都不行，因为resuorces/template下面的HTML文件名是hello
    }
}
