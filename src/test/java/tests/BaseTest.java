package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import models.TestBot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {

    protected static final String BROWSER = "chrome";
    protected static final String BASE_URL = "https://ok.ru";

    protected static final TestBot MAIN_BOT = new TestBot("technopol72", "technopolisPassword");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.baseUrl = BASE_URL;
        System.setProperty("chromeoptions.prefs","intl.accept_languages=ru");
        clearBrowserCache();
        Selenide.open("/");
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
