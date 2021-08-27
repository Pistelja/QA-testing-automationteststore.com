package tests;

import org.junit.Test;
import pages.HomePage;

public class ShoppingTest extends BaseTest {
    HomePage homePage;

    @Test
    public void Shop() {
        homePage = new HomePage(driver);
        homePage.chooseCurrency("€ EURO");
        homePage.click(homePage.homeButtonBy);
        homePage.shop(false);
        homePage.shopCheckOut();

        }
    }