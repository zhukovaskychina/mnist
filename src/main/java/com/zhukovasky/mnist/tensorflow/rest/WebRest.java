package com.zhukovasky.mnist.tensorflow.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/")
public class WebRest {
    @RequestMapping("/") 
    public String  index() {
        return "/index";
    }
    
}
