package com.github.daanielowsky.RecruitmentAssistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitmentController {

    @GetMapping("/recruitment")
    public String recruitmentPage(){
        return "recruitment";
    }
}
