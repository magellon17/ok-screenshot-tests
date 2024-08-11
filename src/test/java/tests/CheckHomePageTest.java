package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.Screenshot;
import utils.ScreenshotTaker;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotTaker.takePageScreenshotWithoutIgnoredElement;
import static utils.ScreenshotUtils.getScreenshotByPath;
import static utils.ScreenshotUtils.saveScreenshotToFile;

public class CheckHomePageTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/HomePage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/HomePageDiff.PNG";

    private static final By additionalColumnBlock = byId("hook_Block_AdditionalColumn");

    @Test
    public void checkHomePageTest() {
        Screenshot actualScreenshot = takePageScreenshotWithoutIgnoredElement(additionalColumnBlock);
        saveScreenshotToFile(actualScreenshot.getImage(), "src/test/resources/HomePage.PNG");
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
