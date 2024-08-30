package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_09_Button_RadioButton_CheckBox_Alert {
    WebDriver driver;
    WebElement element;

    WebDriverWait expliciWait;

    By resultText = By.cssSelector("p#result");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.xpath("//ul[@id = 'popup-login-tab_list']//li[contains(@class ,'popup-login-tab-login')]")).click();
        WebElement loginButton = driver.findElement(By.xpath("//div[@class = 'youama-login-window']//button[@title = 'Đăng nhập']"));
        // Click button
        loginButton.click();

        // enable - disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify backgroud color
        String loginButtonBackgroundColor = loginButton.getCssValue("background-color");
        System.out.println(loginButtonBackgroundColor);

        Color loginButtonColor = Color.fromString(loginButtonBackgroundColor);
        System.out.println(loginButtonColor);

        String loginButtonHexa = loginButtonColor.asHex().toUpperCase();
        System.out.println(loginButtonHexa);

        Assert.assertEquals(loginButtonHexa, "#000000");
    }

    @Test
    public void TC_02_RadioButton_CheckBox(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        WebElement checkBox = driver.findElement(By.xpath("//input[@value='Anemia']"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
        checkBox.click();
        Assert.assertFalse(checkBox.isSelected());


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        // Check
        for (WebElement checkbox1 : checkBoxes){
            if (!checkbox1.isSelected()){
                checkbox1.click();
            }
            Assert.assertTrue(checkbox1.isSelected());
        }

        //Uncheck
        for (WebElement checkbox1 : checkBoxes){
            if (checkbox1.isSelected()){
                checkbox1.click();
            }
            Assert.assertFalse(checkbox1.isSelected());
        }
    }
    // 52:
    @Test
    public void TC_03_Accept_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[@onclick = 'jsAlert()']")).click();
        // Cho alert present
        // Neu trong thoi gian cho ma xuat hien thi tu switch vao
        // Neu het thoi gian cho ma chua xuat hien thi fail

        Alert alert = expliciWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");
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
