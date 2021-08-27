package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.PropertyManager;

import java.util.List;
import java.util.Locale;

public class HomePage extends Page {
    By logOrRegisterBy = By.xpath("//ul[@id='customer_menu_top']/li/a");
    By continueToRegistrationBy = By.xpath("//button[@title='Continue']");
    By welcomeBackButtonBy = By.xpath("//ul[@class='sub_menu dropdown-menu']/li");
    By welcomeBackButtonBy1 = By.id("customer_menu_top");
    By chooseCurrencyButton1By = By.className("block_6");
    By chooseCurrencyButtonBy = By.xpath("//ul[@class='dropdown-menu currency']//li");
    By chosenCurrencyButtonBy = By.xpath("(//a[@class='dropdown-toggle']/span)[1]");
    By productsOnSaleBy = By.xpath("//span[@class='sale']/..//a[@class='productcart']"); //finding all products on sale and navigating to little Add to cart icon while avoiding out of stock products.
    By addToCartBy = By.className("productpagecart");
    By itemOptionsBy = By.xpath("//form[@id='product']//*[self::select or self::input]"); //taking all possible item options(shoe size, shirt colour...).
    By productsBy = By.className("productcart");
    By productsNameBy = By.xpath("//a[@class='productcart']/../../../div[@class='fixed_wrapper']");
    By productsOnSaleNameBy = By.xpath("//span[@class='sale']/..//a[@class='productcart']/../../../div[@class='fixed_wrapper']"); //finding names of all products on sale by navigating to little Add to cart icon while avoiding out of stock products, then navigating to their names by finding ancestors/descendants.
    By checkProductNameBy = By.xpath("//td[@class='align_left']/a");
    By productNameBy = By.xpath("//h1[@class='productname']");
    By removeItemButtonBy = By.xpath("//i[@class='fa fa-trash-o fa-fw']//..");
    By shoppingCartBy = By.className("topcart");
    By checkOutButtonBy = By.id("cart_checkout1");
    By confirmOrderButtonBy = By.id("checkout_btn");
    By continueShopBy = By.xpath("//a[@title='Continue']");
    By emptyCartMessageBy = By.xpath("//div[@class='contentpanel']/div");
    By emptyCartMessageBy1 = By.className("contentpanel");
    public By homeButtonBy = By.className("menu_home");

    public HomePage(WebDriver driver) {

        super(driver);
    }
    public HomePage shop(Boolean sale){
        List<WebElement> items;
        if(sale == true)
            items = driver.findElements(productsOnSaleBy);
        else
            items = driver.findElements(productsBy);
        int numberOfItems = items.size();
        int randomIndex = (int) Math.floor(Math.random() * numberOfItems);//Choosing random index for picking random item.
        items.get(randomIndex).click();
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals("https://automationteststore.com/")) { //checking if item has multiple options(shoe size, shirt colour...), if it has it redirects to product page.
            List<WebElement> options = driver.findElements(itemOptionsBy);
            for (WebElement option : options) {
                if (option.getAttribute("type").equals("radio")) { //checking if options type is radio box or select dropdown.
                    option.click();
                } else if (option.getTagName().equals("select")) {
                    Select select = new Select(option);
                    List<WebElement> options1 = select.getOptions();
                    select.selectByIndex((int) Math.floor(Math.random() * options1.size())); //selecting random option from option dropdown list.
                }
            }
            String productName = readText(productNameBy);
            click(addToCartBy);
            Assert.assertEquals(productName.toUpperCase(Locale.ROOT),readText(checkProductNameBy).toUpperCase(Locale.ROOT));
            System.out.println("Product name match");
        } else {
            List<WebElement> productNames;
            if(sale)
                productNames = driver.findElements(productsOnSaleNameBy);
            else
                productNames = driver.findElements(productsNameBy);
            String productName = productNames.get(randomIndex).getText();
            click(shoppingCartBy);
            Assert.assertEquals(productName.toUpperCase(Locale.ROOT), readText(checkProductNameBy).toUpperCase(Locale.ROOT));//checking if right item is in shopping cart.
            System.out.println("Product names match");
        }
        return this;
    }
    public HomePage removeItem(){
        click(removeItemButtonBy);
        String wholeMessage = readText(emptyCartMessageBy1);
        String redundantPartOfMessage = readText(emptyCartMessageBy);
        String sufficientMessage = wholeMessage.replace(redundantPartOfMessage,"").trim();
        Assert.assertEquals(sufficientMessage,"Your shopping cart is empty!");
        System.out.println("Item successfully removed");
        return this;
    }
    public HomePage shopCheckOut(){
        click(checkOutButtonBy);
        click(confirmOrderButtonBy);
        click(continueShopBy);
        return this;

    }
    public HomePage loginVerification(){
        String message = readText(logOrRegisterBy);
        if(message.equals("Login or register")){
            System.out.println("User failed to login");
            Assert.fail("\nExpected message: Welcome back " + PropertyManager.getInstance().getFirstName() + "\nActual message: " + message);}
        else if(message.equals("Welcome back " + PropertyManager.getInstance().getFirstName()))
            System.out.println("User logged in successfully");
        else
            Assert.fail("\nUnexpected situation just happened!");
        return this;
    }
    public HomePage registrationVerification(String firstName){
        String message = readText(logOrRegisterBy);
        if(message.equals("Login or register")) {
            System.out.println("User failed to register");
            Assert.fail("\nExpected message: Welcome back "+ firstName + "\nActual message: " + message);
        }

        else if(message.equals("Welcome back " + firstName)) {
            System.out.println("User registered successfully");
        }
        return this;
    }
    public HomePage logout(){
        List<WebElement> actionsList = driver.findElements(welcomeBackButtonBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(welcomeBackButtonBy1)).perform();
        for(WebElement action: actionsList){
            if(action.getText().indexOf("Logoff")!= -1){
                action.click();
                break;
            }
        }
        return this;
    }
    public HomePage failedLoginVerification() {
      String message = readText(logOrRegisterBy);
      if (message.equals("Welcome back " + PropertyManager.getInstance().getFirstName())) {
          System.out.println("User logged in.");
          Assert.fail("\nExpected message: Login or register " + "\nActual message: " + message);
      } else if (message.equals("Login or register"))
          System.out.println("User failed to login.");
      return this;
  }
    public HomePage logoutVerification() {
        String message = readText(logOrRegisterBy);
        if (message.equals("Welcome back " + PropertyManager.getInstance().getFirstName())) {
            System.out.println("User failed to logout");
            Assert.fail("\nExpected message: Login or register " + "\nActual message: " + message);
        } else if (message.equals("Login or register"))
            System.out.println("User logged out successfully");
        else
            Assert.fail("\nUnexpected situation just happened!");
        return this;
    }
    public HomePage chooseCurrency(String currency ){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PropertyManager.getInstance().getLoginName(), PropertyManager.getInstance().getLoginPassword());
        List<WebElement> currencyList = driver.findElements(chooseCurrencyButtonBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(chooseCurrencyButton1By)).perform();
        for(WebElement currencyElement: currencyList){
            if(currencyElement.getText().equals(currency)) {
                currencyElement.click();
                break; // avoiding element becoming stale.

            }
        }
        return this;
    }
    public HomePage chosenCurrencyVerification(String expectedCurrency){
        Assert.assertEquals(expectedCurrency,driver.findElement(chosenCurrencyButtonBy).getText());
        System.out.println("Chosen currency:" + expectedCurrency);
        return this;
    }
    public HomePage startRegistration(){
        click(logOrRegisterBy);
        click(continueToRegistrationBy);
        return this;
    }
    public HomePage startLogin(){
        click(logOrRegisterBy);
        return this;
    }

    }


