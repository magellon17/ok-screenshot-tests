package tests;

import pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;

public abstract class RequiredLoginTest extends BaseTest {
    @BeforeAll
    public static void login() {
        new LoginPage().login(MAIN_BOT);
    }
}
