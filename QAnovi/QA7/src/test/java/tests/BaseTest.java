package tests;

import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.PropertyManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public ChromeOptions options;
    public FirefoxOptions options1;

    @Before
    public void setup() {
        String browser = "Chrome";
        if (browser.equals("Chrome")) {
            options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(PropertyManager.getInstance().getURL());
        }
        else if(browser.equals("Firefox")){
            options1 = new FirefoxOptions();
            options1.addArguments("--disable-notifications");

            System.setProperty("webdriver.gecko.driver", PropertyManager.getInstance().getDriverPath1());

            driver = new FirefoxDriver(options1);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(PropertyManager.getInstance().getURL());
        }
    }
    @After
    public void teardown(){
        driver.quit();
    }
}

