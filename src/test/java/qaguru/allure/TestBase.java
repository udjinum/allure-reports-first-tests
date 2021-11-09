package qaguru.allure;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.browserSize = "1920x1080";
        addListener("AllureSelenide", new AllureSelenide());
    }

}
