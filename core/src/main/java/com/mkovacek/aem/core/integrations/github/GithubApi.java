package com.mkovacek.aem.core.integrations.github;

import java.util.List;

import com.mkovacek.aem.core.integrations.github.dto.Contributor;
import com.mkovacek.aem.core.integrations.github.dto.Issue;

import feign.Param;
import feign.RequestLine;

public interface GithubApi {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

}
