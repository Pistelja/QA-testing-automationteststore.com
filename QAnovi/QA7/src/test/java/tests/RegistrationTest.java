package tests;

import org.junit.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.PropertyManager;
import data_creation.DataCreation;

public class RegistrationTest extends BaseTest {
    public HomePage homePage;
    public RegistrationPage registrationPage;
    @Test
    public void registrationTest(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.startRegistration();
        String[] registrationData = DataCreation.createRegistrationData();
        registrationPage.register(registrationData);
        homePage.registrationVerification(registrationData[0]);
        PropertyManager.changeProperty("loginName",registrationData[8]);
        PropertyManager.changeProperty("firstName",registrationData[0]);
        PropertyManager.changeProperty("loginPassword",registrationData[9]);
    }
}
