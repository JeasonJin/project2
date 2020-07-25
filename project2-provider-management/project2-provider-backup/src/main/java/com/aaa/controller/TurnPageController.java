package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TurnPageController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/22 8:46
 **/
@Controller
public class TurnPageController {
    @GetMapping("/")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/toIndexPage")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/admin")
    public String toAdmin(){
        return "admin";
    }

    @GetMapping("/toMainPage")
    public String toMainPage(){
        return "main";
    }
}
