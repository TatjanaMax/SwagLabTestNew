import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.checkout.LoginPageObject;

import java.time.Duration;
public class LoginValidAccount {
public WebDriver driver;
public WebDriverWait wait;
public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://www.saucedemo.com/";
    }
        @Test
        public void validLogI(){

        driver.get(baseURL);

        driver.findElement(LoginPageObject.userNameField).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).click();

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();



    }
    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
