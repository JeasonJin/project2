package com.aaa.controller;

import com.aaa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName TurnPageController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/22 8:46
 **/
@Controller
public class TurnPageController {
    @PostMapping("/index")
    public String getIndex(){
        return "index";
    }
}
