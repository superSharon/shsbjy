package io.renren.modules.generator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping(value = "/swagger")
    public String index() {
        System.out.println("index.html");
        return "static/swagger/index.html";
    }
}
