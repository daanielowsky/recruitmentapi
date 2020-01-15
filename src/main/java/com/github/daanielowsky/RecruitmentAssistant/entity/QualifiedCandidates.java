package com.github.daanielowsky.RecruitmentAssistant.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Data @RequiredArgsConstructor
public class QualifiedCandidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "interview")
    private boolean passingInterview = false;

    @Column(name = "technical_test")
    private boolean technicalTest = false;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] file;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_name")
    private String fileName;
}
