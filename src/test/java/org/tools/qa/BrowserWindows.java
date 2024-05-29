package org.tools.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindows {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://demoqa.com/browser-windows";

    }
    @Test
    public void windowsTest() throws InterruptedException {
       driver.get(baseURL);
       //Tab Button
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(1000);

        //List of Tabs
        List<String> browserTabs = new ArrayList(driver.getWindowHandles());
        //Switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        // Check is it correct page
        String myURL = driver.getCurrentUrl();
        System.out.println(myURL);
        Assert.assertNotEquals(myURL,baseURL);
        driver.findElement(By.id("sampleHeading"));
        //Close tab and get back
        driver.close();
        driver.switchTo().window(browserTabs.get(0));



    }
    @AfterTest
    public void endTest(){
driver.quit();
    }
}
