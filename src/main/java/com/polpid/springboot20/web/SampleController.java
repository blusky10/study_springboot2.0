package com.polpid.springboot20.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        return "login";
    }

}
