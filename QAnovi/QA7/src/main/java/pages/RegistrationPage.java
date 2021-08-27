package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Page {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    By firstnameBy = By.id("AccountFrm_firstname");
    By lastnameBy = By.id("AccountFrm_lastname");
    By registrationEmailBy = By.id("AccountFrm_email");
    By addressBy = By.id("AccountFrm_address_1");
    By cityBy = By.id("AccountFrm_city");
    By countryBy = By.id("AccountFrm_country_id");
    By stateBy = By.id("AccountFrm_zone_id");
    By zipCodeBy = By.id("AccountFrm_postcode");
    By loginNameBy = By.id("AccountFrm_loginname");
    By registrationPasswordBy = By.id("AccountFrm_password");
    By passwordConfirmationBy = By.id("AccountFrm_confirm");
    By newsLetterSubscription1By = By.id("AccountFrm_newsletter1");
    By newsLetterSubscription0By = By.id("AccountFrm_newsletter0");
    By agreeToTermsBy = By.id("AccountFrm_agree");
    By continueButtonBy = By.xpath("//button[@title='Continue']");
    public RegistrationPage register(String[] data){
        writeText(firstnameBy,data[0]);
        writeText(lastnameBy,data[1]);
        writeText(registrationEmailBy,data[2]);
        writeText(addressBy,data[3]);
        writeText(cityBy,data[4]);
        selectElementByText(countryBy,data[5]);
        selectElementByText(stateBy,data[6]);
        writeText(zipCodeBy,data[7]);
        writeText(loginNameBy,data[8]);
        writeText(registrationPasswordBy,data[9]);
        writeText(passwordConfirmationBy,data[9]);
        if(Math.round(Math.random())==1)
            click(newsLetterSubscription1By);
        else
            click(newsLetterSubscription0By);
        click(agreeToTermsBy);
        click(continueButtonBy);
        return this;
    }


}
