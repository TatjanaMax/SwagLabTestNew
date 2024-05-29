package swag.lab.test.fun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartFun {
    public static void goToCart(WebDriver driver, WebDriverWait wait){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public static void checkProductNameInCart(WebDriver driver,WebDriverWait wait){
        String myProductNameInCart = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]")).getText();
        System.out.println(myProductNameInCart);
    }
}
