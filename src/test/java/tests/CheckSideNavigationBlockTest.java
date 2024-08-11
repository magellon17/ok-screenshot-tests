package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.Screenshot;
import utils.ScreenshotTaker;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotUtils.getScreenshotByPath;

public class CheckSideNavigationBlockTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/SideNavigationBlock.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/SideNavigationBlockDiff.PNG";

    private static final By sideNavigationBlock = byId("hook_Block_SideNavigation");

    @Test
    public void checkSideNavigationBlockTest() {
        Screenshot actualScreenshot = ScreenshotTaker.takeScreenshotOfElement($(sideNavigationBlock));
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
