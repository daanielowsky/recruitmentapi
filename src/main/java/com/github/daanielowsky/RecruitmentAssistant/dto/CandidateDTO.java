package com.github.daanielowsky.RecruitmentAssistant.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Data @RequiredArgsConstructor
public class CandidateDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NumberFormat(pattern = "###-###-###")
    @NotNull
    private Long phoneNumber;

    @NotNull
    private String experience;

    @NotNull
    private String position;

    @NotNull
    private String whenIsReadyToStart;

    @NotNull
    @NumberFormat(pattern = "#,###,###.##")
    private BigDecimal grossExpectation;

    private String contentType;

    private byte[] file;
}
