package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.services.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CandidatesReviewController {

    private CandidateService candidateService;

    public CandidatesReviewController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping("/candidates")
    public String gettingListofCandidates(Model model){

        List<Candidate> listOfAllCandidates = candidateService.getListOfAllCandidates();

        model.addAttribute("listOfAllCandidates", listOfAllCandidates);

        return "candidates";
    }

    @GetMapping("/candidates/{id}/reject")
    public String rejectingCandidatesApplication(@PathVariable("id") String userID){

    }
}
