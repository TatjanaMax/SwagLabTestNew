package swag.lab.test.log_in;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import page_object.checkout.LoginPageObject;
import swag.lab.test.fun.LoginPageFun;
import swag.lab.test.utility.BeforeAll;

import java.time.Duration;

public class LoginLogoutTest extends BeforeAll {
    @Test(priority = 1,description = "TC-001 - Valid Log in Test")
    public void loginLogoutTest(){

       //Valid Log In
        LoginPageFun.logInValidAccount(driver,wait);
        LoginPageFun.logOutFun(driver,wait);
    }
    }



