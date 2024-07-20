package com.seirandzhafarov.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "viewForAllEmps";
    }

    @GetMapping("/hr_info")
    public String getInfoForHr(){
        return "viewForHr";
    }

    @GetMapping("/manager_info")
    public String getInfoForManager(){
        return "viewForManager";
    }
}
