package Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmptyLoginUsernameTest.class,
        EmptyLoginPasswordTest.class,
        BadLoginTest.class,
        RegistrationTest.class,
        LoginTest.class,
        LogoutTest.class,
        CurrencyChooseValidationTest.class,
        ShoppingTest.class,
        ShoppingOnSaleTest.class,
        RemoveItemTest.class,
        })



public class TestSuites {

}
