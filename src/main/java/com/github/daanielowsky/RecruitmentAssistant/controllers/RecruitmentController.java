package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitmentController {

    @GetMapping("/recruitment")
    public String recruitmentPage(Model model){
        model.addAttribute("candidate", new CandidateDTO());
        return "recruitment";
    }
}
