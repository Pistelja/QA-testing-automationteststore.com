package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;


public class LogoutTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void logout(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login(PropertyManager.getInstance().getLoginName(), PropertyManager.getInstance().getLoginPassword());
        homePage.logout();
        homePage.logoutVerification();

    }
}
