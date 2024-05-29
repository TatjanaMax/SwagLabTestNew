package org.tools.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/droppable";

    }

    @Test
    public void dragAdDrop() throws InterruptedException {
        driver.get(baseURL);

        driver.findElement(By.id("draggable"));
        driver.findElement(By.id("droppable"));

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Dropped!')]")));

        //verify text changed in to "Drop here" box
//driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
