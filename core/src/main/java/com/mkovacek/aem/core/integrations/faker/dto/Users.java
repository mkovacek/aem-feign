package com.mkovacek.aem.core.integrations.faker.dto;

import lombok.Data;

@Data
public class Users {

    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String ip;
    private String macAddress;
    private String website;
    private String image;

}