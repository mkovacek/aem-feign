package com.mkovacek.aem.core.integrations.github.dto;

import lombok.Data;

@Data
public class Contributor {

    private String login;
    private int contributions;

}