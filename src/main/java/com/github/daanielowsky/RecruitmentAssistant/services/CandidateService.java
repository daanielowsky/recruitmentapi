package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.repositories.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.daanielowsky.RecruitmentAssistant.services.Converter.*;

@Service
public class CandidateService {

    private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);

    private CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public void creatingNewCandidate(CandidateDTO candidateDTO){
        logger.info(candidateDTO.toString());
        Candidate candidate = convertingFromCandidateDtoToCandidateEntity(candidateDTO);
        candidateRepository.save(candidate);
    }

    public List<Candidate> getListOfAllCandidates(){
        List<Candidate> allCandidates = candidateRepository.getAllBy();
        return allCandidates;
    }
}
