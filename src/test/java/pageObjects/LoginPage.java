package pageObjects;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseTest {
    By loginLink = By.id("login2");
    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginSubmitBtn = By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]");
    By logOutLink = By.xpath("//*[@id='logout2']");

    //    LoginPage constructor initialization
    public LoginPage(){
//        PageFactory.initElements(BaseTest.driver, this);
        PageFactory.initElements(driver, this);
    }

    //    Action methods
    public void clickLoginLink(String username, String password) throws InterruptedException {
        driver.findElement(loginLink).click();
        Thread.sleep(2000);
        driver.findElement(loginUsername).sendKeys(username);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginSubmitBtn).click();
        Thread.sleep(2000);
    }

    public void clickLogOutLink() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(logOutLink).click();
    }

    public String handleAlertWindow(String expectedText){
        //  Switch to the alert
        Alert alert = driver.switchTo().alert();

        //   Get the alert text for assertions
        String alertText = alert.getText();
        Assert.assertEquals(alertText, expectedText);

        //  Accept the alert
        alert.accept();

        //  Switch back to the main window or default content
        driver.switchTo().defaultContent();

        return alertText;
    }
}
