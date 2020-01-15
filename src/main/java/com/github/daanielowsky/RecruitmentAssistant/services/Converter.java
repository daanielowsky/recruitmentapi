package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.dto.UserDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.entity.QualifiedCandidates;
import com.github.daanielowsky.RecruitmentAssistant.entity.User;

import java.util.List;

public class Converter {

    public static User convertingFromUserDtoToRegularUserEntity(UserDTO userDTO){
        User user = new User();
        user.setFullname(userDTO.getFullname());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public static Candidate convertingFromCandidateDtoToCandidateEntity(CandidateDTO candidateDTO){
        Candidate candidate = new Candidate();
        candidate.setFirstname(candidateDTO.getFirstName());
        candidate.setLastname(candidateDTO.getLastName());
        candidate.setEmail(candidateDTO.getEmail());
        if(candidateDTO.getPhoneNumber() == null) {
            candidate.setPhoneNumber(999999999L);
        } else {
            candidate.setPhoneNumber(candidateDTO.getPhoneNumber());
        }
        candidate.setExperience(candidateDTO.getExperience());
        candidate.setPosition(candidateDTO.getPosition());
        candidate.setWhenIsReadyToStart(candidateDTO.getWhenIsReadyToStart());
        candidate.setGrossExpectation(candidateDTO.getGrossExpectation());
        candidate.setFileName(candidateDTO.getFileName());
        candidate.setFile(candidateDTO.getFile());
        candidate.setFileType(candidateDTO.getContentType());
        return candidate;
    }

    public static QualifiedCandidates convertingFromCandidateToQualifiedCandidate(Candidate candidate) {
        QualifiedCandidates qualifiedCandidates = new QualifiedCandidates();
        qualifiedCandidates.setFullname(candidate.getFirstname() + " " + candidate.getLastname());
        qualifiedCandidates.setEmail(candidate.getEmail());
        if(candidate.getPhoneNumber() == null) {
            qualifiedCandidates.setPhoneNumber(999999999L);
        } else {
            qualifiedCandidates.setPhoneNumber(candidate.getPhoneNumber());
        }
        qualifiedCandidates.setFile(candidate.getFile());
        qualifiedCandidates.setFileName(candidate.getFileName());
        qualifiedCandidates.setFileType(candidate.getFileType());
        qualifiedCandidates.setPosition(candidate.getPosition());

        return qualifiedCandidates;
    }

}
