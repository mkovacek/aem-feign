package com.mkovacek.aem.core.integrations;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "ApiClientConfig", description = "Configurations related to Api Clients")
public @interface ApiClientConfig {

    @AttributeDefinition(name = "Faker API Base Path") String fakerApiBasePath() default "https://fakerapi.it/api/v1";
    @AttributeDefinition(name = "Github API Base Path") String githubApiBasePath() default "https://api.github.com";

}