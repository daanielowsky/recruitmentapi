package com.github.daanielowsky.RecruitmentAssistant.repositories;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository <Candidate, Long> {

    List<Candidate> getAllBy();
    Candidate getFirstById(Long id);
}
