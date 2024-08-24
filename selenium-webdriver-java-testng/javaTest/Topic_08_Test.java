import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_08_Test {
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
        driver.get("https://pherusa-redmine.sun-asterisk.vn/projects/wellnessconnectweb-all-right/");
        driver.findElement(By.id("username")).sendKeys("nguyen.phong.hao");
        driver.findElement(By.id("password")).sendKeys("PhongHao2602@!");
        driver.findElement(By.id("login-submit")).click();
        driver.findElement(By.xpath("//div[@id='main-menu']//a[contains(@class,'issues')]")).click();
        driver.findElement(By.id("add_filter_select")).click();
        driver.findElement(By.xpath("//select[@id='add_filter_select']//option[@value='fixed_version_id']")).click();
        driver.findElement(By.id("operators_status_id")).click();
        driver.findElement(By.xpath("//select[@id='operators_status_id']//option[contains(text(),'is not')]")).click();
        driver.findElement(By.id("values_status_id_1")).click();
        driver.findElement(By.xpath("//select[@id='values_status_id_1']//option[contains(text(),'Closed')]")).click();

        driver.findElement(By.id("values_status_id_1")).click();
        driver.findElement(By.xpath("//select[@id='values_fixed_version_id_1']//option[contains(text(),'[981] WellnessConnectWeb [All Right] - Sprint 86 (07/29~08/02)')]")).click();
        driver.findElement(By.xpath("//div[@id='query_form_with_buttons']//a[contains(text(),'Apply')]")).click();

    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}


/*
* Các câu lệnh để thao tác vs Browser
* driver.
*
* Các câu lệnh thao tác với Element
*
* element.
*
* */