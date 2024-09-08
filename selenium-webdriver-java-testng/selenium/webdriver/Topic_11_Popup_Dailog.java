package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_11_Popup_Dailog {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_InDom_01() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//div[@class='action']//button[text()='Đăng nhập']")).click();

        By loginPopup = By.xpath("//div[@id='custom-dialog']");

        // Kiem tra popup isDisplayed
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("nphao28129@gmail.com");
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("nphao28129");
        driver.findElement(By.xpath("//button[text()='Đăng nhập' and @type='submit']")).click();
        driver.findElement(By.xpath("//h2[@id='mui-2']//button")).click();

        Thread.sleep(100);
        // Kiem tra popup khong hien thi
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
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

