package tests;

import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;
import utils.ScreenshotMaker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotUtils.getScreenshotByPath;

public class CheckLoginPageTest extends BaseTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/LoginPage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/LoginPageDiff.PNG";

    @Test
    public void checkLoginPageTest() {
        Screenshot actualScreenshot = ScreenshotMaker.takeScreenshot();
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
