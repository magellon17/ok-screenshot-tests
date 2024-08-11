package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.Screenshot;
import steps.NavigationFromHomePageSteps;

import static com.codeborne.selenide.Selectors.byXpath;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static utils.ScreenshotComparer.compareScreenshotsAndSaveDiffToFile;
import static utils.ScreenshotTaker.takePageScreenshotWithoutIgnoredElement;
import static utils.ScreenshotUtils.getScreenshotByPath;
import static utils.ScreenshotUtils.saveScreenshotToFile;

public class CheckFriendsMainPageTest extends RequiredLoginTest {

    private static final Screenshot REFERENCE_SCREENSHOT = getScreenshotByPath("src/test/resources/FriendsMainPage.PNG");
    private static final String DIFF_SCREENSHOT_PATH = "src/test/resources/diffs/FriendsMainPageDiff.PNG";

    private static final By possibleFriendsBlock = byXpath(".//div[@class='h-mod friendship-portlet']");

    NavigationFromHomePageSteps steps = new NavigationFromHomePageSteps();

    @BeforeEach
    public void openOwnProfilePage() {
        steps.gotoFriendsMainPage();
    }

    @Test
    public void checkFriendsMainPageTest() {
        Screenshot actualScreenshot = takePageScreenshotWithoutIgnoredElement(possibleFriendsBlock);
        saveScreenshotToFile(actualScreenshot.getImage(), "src/test/resources/FriendsMainPage.PNG");
        assertFalse(compareScreenshotsAndSaveDiffToFile(REFERENCE_SCREENSHOT, actualScreenshot, DIFF_SCREENSHOT_PATH),
                "Скриншоты различны");
    }
}
