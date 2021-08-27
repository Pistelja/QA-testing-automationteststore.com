package data_creation;

import com.github.javafaker.Faker;
import utilities.PropertyManager;

public class DataCreation {
    public static String[] createRegistrationData(){
        Faker faker = new Faker();

        String regFirstName = faker.name().firstName();
        String regLastName = faker.name().lastName();
        String regEmail = faker.internet().emailAddress();
        String regAddress = faker.address().streetAddress();
        String regCity = faker.address().city();
        String regCountry = PropertyManager.getInstance().getRegCountry();
        String regState = PropertyManager.getInstance().getRegState();
        String regZipCode = faker.number().digits(5);
        String regLoginName = faker.name().username();
        String regPassword = faker.internet().password(4,20);

        return new String[] {regFirstName, regLastName, regEmail, regAddress, regCity, regCountry, regState, regZipCode, regLoginName, regPassword};
    }
}
