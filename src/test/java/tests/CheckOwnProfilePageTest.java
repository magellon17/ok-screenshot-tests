package tests;

import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;
import steps.NavigationFromHomePageSteps;
import utils.ScreenshotMaker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotUtils.getScreenshotByPath;

public class CheckOwnProfilePageTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/OwnProfilePage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/OwnProfilePageDiff.PNG";

    NavigationFromHomePageSteps steps = new NavigationFromHomePageSteps();

    @Test
    public void checkOwnProfilePageTest() {
        steps.gotoOwnProfilePage();
        Screenshot actualScreenshot = ScreenshotMaker.takeScreenshot();
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
