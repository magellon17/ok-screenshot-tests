package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenshotTaker {

    public static Screenshot takeScreenshot() {
         return new AShot().takeScreenshot(getWebDriver());
    }

    public static Screenshot takeScreenshotOfElement(SelenideElement element) {
        return new AShot().takeScreenshot(getWebDriver(), element);
    }

    public static Screenshot takePageScreenshotWithoutIgnoredElement(By ignoredElement) {
        return new AShot()
                .addIgnoredElement(ignoredElement)
                .takeScreenshot(getWebDriver());
    }
}
