package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;


public class RemoveItemTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void removeItem() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.chooseCurrency("€ EURO");
        homePage.click(homePage.homeButtonBy);
        homePage.shop(Math.round(Math.random())==1);//random picking item on sale or not on sale.
        homePage.removeItem();
    }
}