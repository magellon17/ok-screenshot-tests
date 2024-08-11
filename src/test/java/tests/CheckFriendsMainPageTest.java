package tests;

import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;
import steps.NavigationFromHomePageSteps;
import utils.ScreenshotMaker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotUtils.getScreenshotByPath;

public class CheckFriendsMainPageTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/FriendsMainPage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/FriendsMainPageDiff.PNG";

    NavigationFromHomePageSteps steps = new NavigationFromHomePageSteps();

    @Test
    public void checkFriendsMainPageTest() {
        steps.gotoFriendsMainPage();
        Screenshot actualScreenshot = ScreenshotMaker.takeScreenshot();
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
