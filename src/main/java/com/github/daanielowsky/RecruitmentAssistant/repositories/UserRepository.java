package com.github.daanielowsky.RecruitmentAssistant.repositories;

import com.github.daanielowsky.RecruitmentAssistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByUsername(String string);
}
