package com.github.daanielowsky.RecruitmentAssistant.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@RequiredArgsConstructor
public class ResourceDTO {

    private Resource resource;
    private String contentType;
}
