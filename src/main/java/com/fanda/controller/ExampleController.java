package com.fanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
    @RequestMapping("/notfound")
    public String notFound(){
        return "home/not-found";
    }
    @RequestMapping("/maintence")
    public String maintence(){
        return "home/maintence";
    }
}
