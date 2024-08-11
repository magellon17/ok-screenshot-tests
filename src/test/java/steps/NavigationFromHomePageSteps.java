package steps;

import pages.HomePage;

public class NavigationFromHomePageSteps {
    public void gotoOwnProfilePage(){
        new HomePage().goToOwnProfilePage();
    }

    public void gotoFriendsMainPage(){
        new HomePage().goToFriendsMainPage();
    }
}
