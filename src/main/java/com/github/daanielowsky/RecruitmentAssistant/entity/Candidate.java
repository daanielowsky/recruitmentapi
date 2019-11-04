package com.github.daanielowsky.RecruitmentAssistant.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data @RequiredArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String whenIsReadyToStart;

    @Column(nullable = false)
    private Long grossExpectation;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] file;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_name")
    private String fileName;
}
