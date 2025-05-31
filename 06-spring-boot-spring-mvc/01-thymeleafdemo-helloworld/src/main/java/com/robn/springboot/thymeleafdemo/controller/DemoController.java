package com.robn.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        //Because we have thymeleaf dependency it will auto-configure to use thymeleaf (helloworld.html).
        return "helloworld";
    }
}
