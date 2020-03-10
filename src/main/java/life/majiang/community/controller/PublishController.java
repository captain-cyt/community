package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author c_sir
 * @create 2020-03-10 14:13
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish" ;
    }
}
