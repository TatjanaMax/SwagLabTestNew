package swag.lab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterAccountParaBank {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL ="https://parabank.parasoft.com/parabank/register.htm";
    }

    @Test
    public void RegisterAccountParaBank() {
        driver.get(baseURL);
        driver.findElement(By.id("customer.firstName")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Tatjana");
        driver.findElement(By.id("customer.lastName")).click();
        driver.findElement(By.id("customer.lastName")).sendKeys("Nikolov");
        driver.findElement(By.id("customer.address.street")).click();
        driver.findElement(By.id("customer.address.street")).sendKeys("Druge Srpske Armije");
        driver.findElement(By.id("customer.address.city")).click();
        driver.findElement(By.id("customer.address.city")).sendKeys("Belgrade");
        driver.findElement(By.id("customer.address.state")).click();
        driver.findElement(By.id("customer.address.state")).sendKeys("Serbia");
        driver.findElement(By.id("customer.address.zipCode")).click();
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("Serbia");
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("Serbia");




        }
    @AfterTest
    public void endTest () {
        driver.quit();
    }
}
