package swag.lab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAnAccount {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseUrl ="https://magento.softwaretestingboard.com/";
    }
    @Test
    public void CreateAnAccount(){
        driver.get(baseUrl);
        //Click on button Create an Account
        driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
        //Check if Luma logo visible
        driver.findElement(By.xpath("//header/div[2]/a[1]/img[1]")).isDisplayed();
        //Click on FirstName field
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).sendKeys("Tatjana");
        //Click on LastName field
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).sendKeys("Nikolov");
        //Click on usernam field
        driver.findElement(By.id("email_address")).click();
        driver.findElement(By.id("email_address")).sendKeys("tanjan@yopmail.com");
        //Click on Password field
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123456789TatjanaMaksim");
        //Click on button Create Account
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]")).click();

    }
    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
