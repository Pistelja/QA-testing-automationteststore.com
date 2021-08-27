package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest{
public HomePage homePage;
public LoginPage loginPage;

@Test
    public void login(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    loginPage.login(PropertyManager.getInstance().getLoginName(), PropertyManager.getInstance().getLoginPassword());
    homePage.loginVerification();
    }
}
