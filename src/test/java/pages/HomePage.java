package pages;

import pages.elements.SideNavigationBlock;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница пользователя
 */
public class HomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By FEED_POST = byClassName("feed-w");
    private static final By HOBBIES_CONTAINER = byXpath(".//div[@data-l='t,hobbies.content']");
    private static final By AVATAR_BLOCK = byId("hook_Block_Avatar");

    public HomePage() {
        check();
        log.info("Загрузилась главная страница пользователя");
    }

    public void check() throws Error {
        $(FEED_POST).shouldBe(
                visible.because("Не отобразился первый пост ленты"));
        $(HOBBIES_CONTAINER).shouldBe(
                visible.because("Не отобразился блок увлечений ленты"));
        $(AVATAR_BLOCK).shouldBe(
                visible.because("Не отобразился блок аватара"));
    }

    public OwnProfilePage goToOwnProfilePage() {
        log.info("Переходим на страницу профиля");
        sideNavigationBlock.clickOnMyProfile();
        return new OwnProfilePage();
    }

    public FriendsMainPage goToFriendsMainPage() {
        log.info("Переходим на страницу друзей");
        sideNavigationBlock.clickOnFriends();
        return new FriendsMainPage();
    }
}
