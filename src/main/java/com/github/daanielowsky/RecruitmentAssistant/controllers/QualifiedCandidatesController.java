package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.entity.QualifiedCandidates;
import com.github.daanielowsky.RecruitmentAssistant.services.CandidateService;
import com.github.daanielowsky.RecruitmentAssistant.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QualifiedCandidatesController {

    private CandidateService candidateService;
    private UserService userService;

    public QualifiedCandidatesController(CandidateService candidateService, UserService userService) {
        this.candidateService = candidateService;
        this.userService = userService;
    }

    @GetMapping("/candidate/{id}/accept")
    public String candidateApplicationWasAccepted(@PathVariable("id") Long id){
        candidateService.acceptingCandidateApplication(id);

        return "redirect:/candidates";
    }

    @GetMapping("/candidates/qualified")
    public String listOfTheCandidatesThatQualifiedToTheNextStage(Model model) {
        List<QualifiedCandidates> qualifiedCandidates = candidateService.gettingListOfAllQualifiedCandidates();

        model.addAttribute("list", qualifiedCandidates);
        model.addAttribute("user", userService.getLoggedUser());
        return "qualifiedCandidates";
    }
}
