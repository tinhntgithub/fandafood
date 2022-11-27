package com.fanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    @RequestMapping("/signup")
    public String signup(){
        return "account/signup";
    }
}
