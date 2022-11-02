package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        return "index";
    }
}
