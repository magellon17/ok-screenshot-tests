package tests;

import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;
import utils.ScreenshotMaker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotUtils.getScreenshotByPath;

public class CheckHomePageTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/HomePage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/HomePageDiff.PNG";

    @Test
    public void checkHomePageTest() {
        Screenshot actualScreenshot = ScreenshotMaker.takeScreenshot();
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
