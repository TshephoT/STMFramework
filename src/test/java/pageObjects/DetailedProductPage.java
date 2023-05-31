package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DetailedProductPage extends BaseTest {
    By AddToCartBtn = By.xpath("//*[@id='tbodyid']/div[2]/div/a");

    public DetailedProductPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartBtn() throws InterruptedException {
        driver.findElement(AddToCartBtn).click();
        Thread.sleep(2000);
    }
}
