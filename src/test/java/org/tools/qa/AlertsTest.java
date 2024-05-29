package org.tools.qa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/alerts";

    }

    @Test
    public void AlertsTest() throws InterruptedException {
        driver.get(baseURL);

        //Alert Button
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Second button alert
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.findElement(By.id("confirmResult")).isDisplayed();

        //Print massage from Alert

        String myText = driver.switchTo().alert().getText();
        System.out.println(myText);

        //Enter Text

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("text");
        alert.accept();
        Thread.sleep(100);
        driver.findElement(By.id("promptResult")).isDisplayed();


    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
