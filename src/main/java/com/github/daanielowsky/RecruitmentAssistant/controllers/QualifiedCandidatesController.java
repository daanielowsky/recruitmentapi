package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.services.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QualifiedCandidatesController {

    private CandidateService candidateService;

    public QualifiedCandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/candidate/{id}/accept")
    public String candidateApplicationWasAccepted(@PathVariable("id") Long id){
        candidateService.acceptingCandidateApplication(id);

        return "redirect:/candidates";
    }
}
