package org.tools.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePicker {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/date-picker";
    }
    @Test
    public void datePicker() throws InterruptedException {
        driver.get(baseURL);

        driver.findElement(By.id("datePickerMonthYearInput")).click();
        driver.findElement(By.id("")).isDisplayed();




}
    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
