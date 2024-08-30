package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_00_Template {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_(){

    }

    @Test
    public void TC_02_(){

    }

    @Test
    public void TC_03_(){

    }
    @Test
    public void TC_04_(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

