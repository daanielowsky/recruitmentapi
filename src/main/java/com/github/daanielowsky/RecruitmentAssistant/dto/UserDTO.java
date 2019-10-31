package com.github.daanielowsky.RecruitmentAssistant.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @RequiredArgsConstructor
public class UserDTO {

    @NotNull
    @Size (min = 5, max = 20)
    private String username;

    @NotNull
    @Size (min = 5, max = 20)
    private String password;

    @NotNull
    @Size (min = 5, max = 20)
    private String confirmedPassword;

    @NotNull
    private String fullname;
}
