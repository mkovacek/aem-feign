package com.mkovacek.aem.core.integrations.github.dto;

import java.util.List;

import lombok.Data;

@Data
public class Issue {

    private String title;
    private String body;
    private List<String> assignees;
    private int milestone;
    private List<String> labels;

}