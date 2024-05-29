package swag.lab.test.fun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.checkout.LoginPageObject;

public class LoginPageFun {
    public static void logInValidAccount(WebDriver driver, WebDriverWait wait) {

        driver.findElement(LoginPageObject.userNameField).click();
        driver.findElement(LoginPageObject.userNameField).sendKeys("standard_user");

        driver.findElement(LoginPageObject.passwordField).click();
        driver.findElement(LoginPageObject.passwordField).sendKeys("secret_sauce");
        driver.findElement(LoginPageObject.logInButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageObject.headerProducttext));

    }

    public static void logOutFun(WebDriver driver, WebDriverWait wait) {
        driver.findElement(LoginPageObject.humburgerMenu).click();
        driver.findElement(LoginPageObject.loginButton).click();
        driver.findElement(LoginPageObject.logInButton).isDisplayed();


    }

}
