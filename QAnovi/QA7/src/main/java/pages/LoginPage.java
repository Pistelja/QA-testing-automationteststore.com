package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    HomePage homePage;
    By loginNameBy = By.id("loginFrm_loginname");
    By passwordBy = By.id("loginFrm_password");
    By loginButtonBy = By.xpath("//button[@title='Login']");



    public LoginPage login(String loginName, String password){
        homePage = new HomePage(driver);
        homePage.startLogin();
        writeText(loginNameBy, loginName);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

}
