package com.github.daanielowsky.RecruitmentAssistant.repositories;

import com.github.daanielowsky.RecruitmentAssistant.entity.QualifiedCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualifiedCandidatesRepository extends JpaRepository<QualifiedCandidates, Long> {

    List<QualifiedCandidates> getAllBy();
}
