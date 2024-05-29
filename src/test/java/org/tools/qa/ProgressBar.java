package org.tools.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBar {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/progress-bar";
    }
    @Test
    public void progressBar() throws InterruptedException {
        driver.get(baseURL);

        driver.findElement(By.id("startStopButton")).click();

        if (!driver.findElements(By.xpath("//div[contains(text(),'77%')]")).isEmpty()){
            driver.findElement(By.id("startStopButton")).click();
    }else{
            System.out.println("Not Working");
        }
        Thread.sleep(3000);

        //Continue
        driver.findElement(By.id("startStopButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
        driver.findElement(By.xpath("//div[contains(text(),'100%')]")).isDisplayed();

        driver.findElement(By.id("resetButton")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'100%')]")));
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
