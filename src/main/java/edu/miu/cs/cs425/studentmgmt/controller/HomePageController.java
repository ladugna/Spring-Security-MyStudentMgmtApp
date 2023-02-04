package edu.miu.cs.cs425.studentmgmt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/eregistrar"})

public class HomePageController {
    @GetMapping(value = {"", "/", "/home"})

    public String displayHomepage() {
        return "public/home/index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutpage() {
        return "public/home/about";
    }
    
    @GetMapping(value = {"/class"})
    public String displayClasspage() {
        return "public/home/classRoom";
    }


}
