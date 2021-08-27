package tests;

import org.junit.Test;
import pages.HomePage;

public class ShoppingOnSaleTest extends BaseTest{
    HomePage homePage;
    @Test
    public void shopOnSale() {
        homePage = new HomePage(driver);
        homePage.chooseCurrency("€ EURO");
        homePage.click(homePage.homeButtonBy);
        homePage.shop(true);
        homePage.shopCheckOut();

    }
}
