package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class BadLoginTest extends  BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void BadLogin(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login(PropertyManager.getInstance().getLoginName(), PropertyManager.getInstance().getBadLoginPassword());
        homePage.failedLoginVerification();
    }
}
