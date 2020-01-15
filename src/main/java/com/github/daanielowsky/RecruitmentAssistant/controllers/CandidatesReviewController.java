package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.dto.ResourceDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.services.CandidateService;
import com.github.daanielowsky.RecruitmentAssistant.services.UserService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CandidatesReviewController {

    private CandidateService candidateService;
    private UserService userService;

    public CandidatesReviewController(CandidateService candidateService, UserService userService) {
        this.candidateService = candidateService;
        this.userService = userService;
    }


    @GetMapping("/candidates")
    public String gettingListofCandidates(Model model) {

        List<Candidate> listOfAllCandidates = candidateService.getListOfAllCandidates();

        model.addAttribute("listOfAllCandidates", listOfAllCandidates);
        model.addAttribute("user", userService.getLoggedUser());

        return "candidates";
    }

    @GetMapping("/candidate/{id}/reject")
    public String rejectingCandidatesApplication(@PathVariable("id") Long id) {
        candidateService.rejectingCandidateApplicationForAJob(id);
        return "redirect:/candidates";
    }

    @GetMapping("/candidate/{id}/own/reject")
    public String rejectingCandidatesApplicationWithOwnMessageForm() {
        return "message";
    }

    @PostMapping("/candidate/{id}/own/reject")
    public String rejectingCandidatesApplicationWithOwnMessage(@PathVariable("id") Long id, @RequestParam("message") String message) {

        candidateService.rejectingCandidateApplicationWithOwnMessage(id, message);
        return "redirect:/candidates";
    }

    @GetMapping("/candidate/{id}/cv")
    public ResponseEntity<Resource> getOfferImage(@PathVariable Long id) {
        ResourceDTO candidatesCv = candidateService.getCvOfTheCandidate(id);
        if (candidatesCv.getResource() != null) {
            return ResponseEntity.ok().contentType(MediaType.valueOf(candidatesCv.getContentType())).body(candidatesCv.getResource());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
