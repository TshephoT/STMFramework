package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ReadPropertyFile;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import static utils.ReadPropertyFile.browser;
import static utils.ReadPropertyFile.testurl;

public class BaseTest {
    public static WebDriver driver ;
    public static Properties properties = new Properties();
    public static Properties locatorProperties = new Properties();
    public static FileReader fileReader;
    public static FileReader fileReader2;
    public static String username;
    public static String password;
    public static String invalidUsername;
    public static String invalidPassword;


    @BeforeMethod
    public void launchBrowser() throws IOException {

        if (driver == null){
            fileReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
            fileReader2 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
            properties.load(fileReader);
            locatorProperties.load(fileReader2);

            username = properties.getProperty("username");
            password = properties.getProperty("password");
            invalidUsername = properties.getProperty("invalidUsername");
            invalidPassword = properties.getProperty("invalidPassword");
        }

        if (properties.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(properties.getProperty("testurl"));
            System.out.println("driver started successfully.");
        } else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(properties.getProperty("testurl"));
            System.out.println("driver started successfully.");
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("driver closed successfully.");
    }
}
