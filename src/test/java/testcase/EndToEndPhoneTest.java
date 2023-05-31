package testcase;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.DetailedProductPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class EndToEndPhoneTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    LoginPageTest loginPageTest = new LoginPageTest();
    HomePage homePage = new HomePage();
    DetailedProductPage detailedProductPage = new DetailedProductPage();
    CartPage cartPage = new CartPage();


    @Test(priority = 1, description = "User logs into web application and performs end to end Samsung Phone transaction")
    public void SamsungEndToEndTest() throws InterruptedException {
        loginPageTest.loginPage.clickLoginLink(username, password);
        homePage.clickSamsungS6();
        detailedProductPage.clickAddToCartBtn();
        loginPage.handleAlertWindow("Product added.");
        cartPage.setClickCartLink();
        cartPage.clickPlaceOrder();
        cartPage.fillOrderInformation();
        loginPage.clickLogOutLink();
    }

}
