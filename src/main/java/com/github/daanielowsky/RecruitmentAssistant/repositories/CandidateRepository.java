package com.github.daanielowsky.RecruitmentAssistant.repositories;

import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository <Candidate, Long> {
}
