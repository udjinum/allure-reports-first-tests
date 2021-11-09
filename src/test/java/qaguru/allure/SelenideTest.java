package qaguru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qaguru.allure.steps.WebSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest extends TestBase {

    private static final String
            URL = "https://github.com",
            REPOSITORY = "TheAlgorithms/Java";

    private static final Integer ISSUE_NUMBER = 2814;

    private final WebSteps steps = new WebSteps();

    @Test
    @DisplayName("First clear selenide test")
    public void clearSelenideTest() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("TheAlgorithms/Java");
        $(".header-search-input").submit();

        $(linkText("TheAlgorithms/Java")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#2814")).should(visible);
    }

    @Test
    @DisplayName("Second lambda selenide test")
    public void selenideLambdaTest() {
        step("Open main page", () -> {
            open(URL);
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open issue tab", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Verify number in issue tab " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(visible);
        });
    }

    @Test
    @DisplayName("Third step selenide test")
    public void selenideStepTest() {
        steps.openMainPage(URL);
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.issueWithNumberShouldBeVisible(ISSUE_NUMBER);
    }

}
