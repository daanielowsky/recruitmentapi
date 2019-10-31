package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.UserDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.User;
import com.github.daanielowsky.RecruitmentAssistant.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.github.daanielowsky.RecruitmentAssistant.services.Converter.*;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User getLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findFirstByUsername(username).orElse(null);
    }

    public void creatingTheUser(UserDTO userDTO){
        User user = convertingFromUserDtoToRegularUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);

    }

    @Transactional
    public boolean findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser  = userRepository.findFirstByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return true;
        }
        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        return false;
    }


}
