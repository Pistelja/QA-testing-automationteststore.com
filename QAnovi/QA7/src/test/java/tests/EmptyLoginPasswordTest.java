package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class EmptyLoginPasswordTest extends BaseTest{
    public HomePage homePage;
    public LoginPage loginPage;
    @Test
    public void emptyLoginPasswordTest(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login(PropertyManager.getInstance().getLoginName(), "");
        homePage.failedLoginVerification();
    }
}
