# AEM Feign 

Looking for clean and easy integration of REST APIs in Adobe Experience Manager (AEM)? 

Luckily there is Feign HTTP client which simplifies REST API Integrations. 

For more details check [Simplify REST API Integrations in AEM with Feign HTTP client](https://devz.life/blog/simplify-rest-api-integrations-in-aem-with-feign-http-client/)

## How to use Feign client
```java
interface GitHub {

  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("POST /repos/{owner}/{repo}/issues")
  void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

}

public static class Contributor {
  String login;
  int contributions;
}

public static class Issue {
  String title;
  String body;
  List<String> assignees;
  int milestone;
  List<String> labels;
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
Faker API and Github API integrations

Take a look [integrations package](https://github.com/mkovacek/aem-feign/tree/develop/core/src/main/java/com/mkovacek/aem/core/integrations)
