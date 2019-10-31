package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "loginPage";
    }

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "registerPage";
    }

}
