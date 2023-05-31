package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends BaseTest {
    By placeOrder = By.xpath("//*[@id='page-wrapper']/div/div[2]/button");
    By clickCartLink = By.xpath("//*[@id='navbarExample']/ul/li[4]/a");
    By nameInput = By.xpath("//*[@id='name']");
    By countryInput = By.xpath("//*[@id='country']");
    By cityInput = By.xpath("//*[@id='city']");
    By creditCardInput = By.xpath("//*[@id='card']");
    By monthInput = By.xpath("//*[@id='month']");
    By yearInput = By.xpath("//*[@id='year']");
    By purchaseBtn = By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]");

    By orderConfirmation = By.xpath("/html/body/div[10]/div[7]/div/button");

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public void setClickCartLink() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(clickCartLink).click();
        Thread.sleep(2000);
    }

    public void clickPlaceOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(placeOrder).click();
        Thread.sleep(2000);
    }

    public void fillOrderInformation() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(nameInput).sendKeys("Tshepho");
        driver.findElement(countryInput).sendKeys("South Africa");
        driver.findElement(cityInput).sendKeys("Johannesburg");
        driver.findElement(creditCardInput).sendKeys("123321123321");
        driver.findElement(monthInput).sendKeys("06");
        driver.findElement(yearInput).sendKeys("2023");
        driver.findElement(purchaseBtn).click();
        Thread.sleep(2000);
        driver.findElement(orderConfirmation).click();
        Thread.sleep(2000);
    }
}
