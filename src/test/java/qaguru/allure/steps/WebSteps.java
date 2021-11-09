package qaguru.allure.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    private final SelenideElement searchInput = $(".header-search-input");
    private final SelenideElement repoLink = $(".repo-list-item");
    private final SelenideElement issueTab = $("[data-content=Issues]");
    private final ElementsCollection issueList = $$("div[aria-label=Issues]");

    @Step("Open main page")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Search repository {repository}")
    public void searchRepository(String repository) {
        searchInput.click();
        searchInput.sendKeys(repository);
        searchInput.submit();
    }

    @Step("Go to repository {repository}")
    public void goToRepository(String repository) {
        repoLink.find(linkText(repository)).click();
    }

    @Step("Open issue tab")
    public void openIssueTab() {
        issueTab.click();
    }

    @Step("Verify number in issue tab {number}")
    public void issueWithNumberShouldBeVisible(int number) {
        issueList.filter(text(String.valueOf(number))).first().shouldBe(visible);
    }
}
