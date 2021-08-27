package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {
    private static String firstName;
    private static String loginPassword;
    private static String driverPath;
    private static String driverPath1;
    private static String URL;
    private static String regCountry;
    private static String regState;
    private static String loginName;
    private static String badLoginPassword;
    public static PropertyManager getInstance(){
        Properties prop = new Properties();
        PropertyManager instance = new PropertyManager();

        try {
            FileInputStream fi = new FileInputStream("src/main/resources/configuration.properties");
            prop.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driverPath = prop.getProperty("driverPath");
        driverPath1 = prop.getProperty("driverPath1");
        URL = prop.getProperty("URL");
        loginPassword = prop.getProperty("loginPassword");
        firstName = prop.getProperty("firstName");;
        regCountry = prop.getProperty("regCountry");
        regState = prop.getProperty("regState");
        loginName = prop.getProperty("loginName");
        badLoginPassword = prop.getProperty("badLoginPassword");
                return instance;
    }
    public static void changeProperty(String key, String value){
        Properties editProp = new Properties();
        try{
            FileInputStream editFi = new FileInputStream("src/main/resources/configuration.properties");
            editProp.load(editFi);
            editProp.setProperty(key, value);
            editProp.store(new FileOutputStream("src/main/resources/configuration.properties"),"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getFirstName(){
        return firstName;
    }
    public String getDriverPath(){
        return driverPath;
    }
    public String getDriverPath1(){
        return driverPath1;
    }
    public String getURL(){
        return URL;
    }
    public String getLoginPassword(){
        return loginPassword;
    }
    public String getRegCountry(){ return regCountry;}
    public String getBadLoginPassword(){
        return badLoginPassword;
    }

    public String getRegState() {
        return regState;
    }

    public String getLoginName() {
        return loginName;
    }
}

