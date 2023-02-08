package edu.miu.cs.cs425.studentmgmt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/eregistrar"})

public class HomePageController {
    @GetMapping(value = {"", "/", "/public/home"})

    public String displayHomepage() {
        return "index";
    }

    @GetMapping(value = {"/public/about"})
    public String displayAboutpage() {
        return "about";
    }
    
    @GetMapping(value = {"/public/class"})
    public String displayClasspage() {
        return "classRoom";
    }
    @GetMapping(value = {"/public/login"})
    public String displayLoginPage() {
        return "login";
    }


}
