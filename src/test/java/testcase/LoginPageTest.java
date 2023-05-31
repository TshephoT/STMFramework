package testcase;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1, description = "User logs in with valid username and password.")
    public void LoginTest() throws InterruptedException {
        loginPage.clickLoginLink(username, password);
    }

    @Test(priority = 2, description = "User logs in with valid username and invalid password.")
    public void invalidPasswordLoginTest() throws InterruptedException {
        loginPage.clickLoginLink(username, invalidPassword);
        loginPage.handleAlertWindow("Wrong password.");
        System.out.println(invalidPassword);
    }

    @Test(priority = 3, description = "User logs in with invalid username and valid password")
    public void invalidUsernameLoginTest() throws InterruptedException {
        loginPage.clickLoginLink(invalidUsername, password);
        loginPage.handleAlertWindow("User does not exist.");
        System.out.println(invalidUsername);
    }
}
