package swag.lab.test.fun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.checkout.PLPageObject;

public class PLPFun {
    public static void clickOnFirst (WebDriver driver, WebDriverWait wait){
        driver.findElement(PLPageObject.productName).click();

    }
}
