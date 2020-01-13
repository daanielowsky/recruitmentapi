package com.github.daanielowsky.RecruitmentAssistant.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
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
    private Long phoneNumber;

    @NotNull
    private String experience;

    @NotNull
    private String position;

    @NotNull
    private String whenIsReadyToStart;

    @NumberFormat(pattern = "###,###,###")
    private BigDecimal grossExpectation;

    @Size(min = 1, message = "Pole musi zostać zaznaczone")
    private String agreement = "Wyrażam zgodę na przetwarzanie moich danych osobowych dla potrzeb niezbędnych do realizacji procesu rekrutacji (zgodnie z ustawą z dnia 10 maja 2018 roku o ochronie danych osobowych (Dz. Ustaw z 2018, poz. 1000) oraz zgodnie z Rozporządzeniem Parlamentu Europejskiego i Rady (UE) 2016/679 z dnia 27 kwietnia 2016 r. w sprawie ochrony osób fizycznych w związku z przetwarzaniem danych osobowych i w sprawie swobodnego przepływu takich danych oraz uchylenia dyrektywy 95/46/WE (RODO)).";

    private String contentType;

    private byte[] file;

    private String fileName;
}
