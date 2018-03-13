package com.polpid.springboot20.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SampleRestController {

    @RequestMapping("/index")
    public String restIndex(){
        return "rest";
    }
}
