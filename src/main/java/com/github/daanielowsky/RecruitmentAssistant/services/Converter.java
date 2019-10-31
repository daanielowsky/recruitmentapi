package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.UserDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.User;

public class Converter {

    public static User convertingFromUserDtoToRegularUserEntity(UserDTO userDTO){
        User user = new User();
        user.setFullname(userDTO.getFullname());
        user.setUsername(userDTO.getUsername());
        return user;

    }
}
