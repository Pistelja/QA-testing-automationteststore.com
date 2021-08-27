package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class CurrencyChooseValidationTest extends BaseTest{
    public HomePage homePage;
    public LoginPage loginPage;
    @Test
    public void currencyChooseValidation(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        String[] currencies ={"€ EURO", "£ POUND STERLING", "$ US DOLLAR"};
        String expectedCurrency = currencies[(int)Math.floor(Math.random()*3)];
        homePage.chooseCurrency(expectedCurrency);
        homePage.chosenCurrencyVerification(expectedCurrency);


}
    }
