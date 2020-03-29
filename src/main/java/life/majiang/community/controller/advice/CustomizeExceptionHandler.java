package life.majiang.community.controller.advice;


import life.majiang.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author c_sir
 * @create 2020-03-25 14:56
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("message", e.getMessage());

        }else {
            model.addAttribute("message", "服务器冒烟了！要不稍后再试试？");
        }
        return new ModelAndView("error");
    }

}
