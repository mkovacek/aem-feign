# AEM Feign 

Looking for clean and easy integration of REST APIs in Adobe Experience Manager (AEM)? 

Luckily there is Feign HTTP client which simplifies REST API Integrations. 

For more details check [Simplify REST API Integrations in AEM with Feign HTTP client](https://devz.life/blog/rest-api-integrations-with-feign-http-client/)

## How to use Feign client
```java
interface GitHub {

  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("POST /repos/{owner}/{repo}/issues")
  void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

}

public class Contributor {

  private String login;
  private int contributions;
  
}

public class Issue {

  private String title;
  private String body;
  private List<String> assignees;
  private int milestone;
  private List<String> labels;
  
}

public class MyApp {

  public static void main(String... args) {
    GitHub github = Feign.builder()
                         .decoder(new GsonDecoder())
                         .target(GitHub.class, "https://api.github.com");

    // Fetch and print a list of the contributors to this library.
    List<Contributor> contributors = github.contributors("OpenFeign", "feign");
    for (Contributor contributor : contributors) {
      System.out.println(contributor.login + " (" + contributor.contributions + ")");
    }
  }
  
}
```

## Project examples
Faker API and Github API integrations in AEM project

Take a look [integrations package](https://github.com/mkovacek/aem-feign/tree/develop/core/src/main/java/com/mkovacek/aem/core/integrations)
