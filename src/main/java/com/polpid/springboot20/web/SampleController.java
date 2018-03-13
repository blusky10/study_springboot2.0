package com.polpid.springboot20.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return "default";
    }
}
