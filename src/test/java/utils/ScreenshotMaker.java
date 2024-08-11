package utils;

import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenshotMaker {

    public static Screenshot takeScreenshot() {
         return new AShot()
                .shootingStrategy(ShootingStrategies.simple())
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(getWebDriver());
    }
}
