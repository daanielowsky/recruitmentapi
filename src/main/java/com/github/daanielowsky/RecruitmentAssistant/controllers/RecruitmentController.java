package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.services.CandidateService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class RecruitmentController {

    private CandidateService candidateService;

    public RecruitmentController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/recruitment")
    public String candidateFormForRecruitment(Model model){
        model.addAttribute("candidate", new CandidateDTO());
        return "recruitment";
    }

    @PostMapping("/recruitment")
    public String addingNewCandidateToDataBase(@RequestParam("cvFromCandidate") MultipartFile cvFromCandidate, @Valid @ModelAttribute("candidate") CandidateDTO candidateDTO, BindingResult result) throws IOException {
        if(result.hasErrors()){
            return "recruitment";
        }
        if(candidateDTO.getAgreement() == null){
            result.rejectValue("agreement", null, "Aby aplikować musisz wyrazić zgodę.");
            return "recruitment";
        }
        if(!cvFromCandidate.getOriginalFilename().endsWith("jpg")){
            result.rejectValue("file", null, "Plik musi posiadać rozszerzenie .jpg!");
            return "recruitment";
        }
        candidateDTO.setContentType(cvFromCandidate.getContentType());
        candidateDTO.setFile(cvFromCandidate.getBytes());
        candidateDTO.setFileName(cvFromCandidate.getName());
        candidateService.creatingNewCandidate(candidateDTO);
        return "redirect/recruitment?complete";
    }
}
