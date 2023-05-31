package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    By SamsungS6 = By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a");

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void clickSamsungS6() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(SamsungS6).click();
        Thread.sleep(2000);
    }
}
