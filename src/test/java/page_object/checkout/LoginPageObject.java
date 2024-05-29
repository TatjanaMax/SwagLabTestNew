package page_object.checkout;

import org.openqa.selenium.By;

public class LoginPageObject {

    public static By userNameField = By.id("user-name");
    public static By passwordField = By.id("password");

    public static String validUser = "standard_user";

    public static String userPassword = "secret_sauce";

    public static By logInButton = By.id("login-button");

    public static By headerProducttext = By.xpath("//span[contains(text(),'Products')]");

    public static By humburgerMenu = By.id("react-burger-menu-btn");

    public static By loginButton = By.id("logout_sidebar_link");
}



