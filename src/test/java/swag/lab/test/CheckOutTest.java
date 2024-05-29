package swag.lab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://www.saucedemo.com/";

    }
    @Test (priority = 1,description = "Login in on page")
    public void LoginValidAccount(){
        driver.get(baseURL);
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();
    }
    @Test(priority = 2)
    public void CheckOutTest(){
        //Click on add button
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Visible Remove button
        driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        //Check if item is add in chart
        driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        //Click on shopping bag cart
        driver.findElement(By.id("shopping_cart_container")).click();
        //Check if display text"Saure Lab Backpak"
        driver.findElement(By.id("item_4_title_link")).isDisplayed();
        //Check if chcekout button is visable (clickable)
        driver.findElement(By.id("page_object/checkout")).isDisplayed();
        //Click on checkout button
        driver.findElement(By.id("page_object/checkout")).click();
        //Check if text (Checkout:Your Information) is visable
        driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).isDisplayed();
        //Click on First Name field
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).sendKeys("Tatjana");
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).sendKeys("Nikolov");
        driver.findElement(By.id("postal-code")).click();
        driver.findElement(By.id("postal-code")).sendKeys("11000");

        //Check if text visable Checkout:Overview
        driver.findElement(By.className("title")).isDisplayed();
        driver.findElement(By.id("continue")).click();
        //Check if button Finish clickable
        driver.findElement(By.id("finish")).click();
        //Check if text visable Checkout complete
        driver.findElement(By.xpath("//span[contains(text(),'Checkout: Complete!')]")).isDisplayed();
        // Check if button Back Home is visable
        driver.findElement(By.id("back-to-products")).click();
        //Click Hamburger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.findElement(By.className("login_logo")).isDisplayed();


    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }



}
