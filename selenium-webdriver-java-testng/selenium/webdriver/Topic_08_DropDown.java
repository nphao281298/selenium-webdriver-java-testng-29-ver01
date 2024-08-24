package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_08_DropDown {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_DropDown_Default(){
        driver.get("https://egov.danang.gov.vn/reg");

        Select selectCity = new Select(driver.findElement(By.id("thuongtru_tinhthanh")));
        List<WebElement> selectListCity = selectCity.getOptions();

        selectCity.selectByVisibleText("");

        for (WebElement list: selectListCity ){
            System.out.println(list.getText());
        }
    }

    @Test
    public void TC_02_DropDown_List(){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class='header']//a[@class='ico-register']")).click();

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        selectDay.selectByVisibleText("1");
        Assert.assertEquals(32, selectDay.getOptions().size());

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        selectMonth.selectByVisibleText("May");
        Assert.assertEquals(13, selectMonth.getOptions().size());

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        selectYear.selectByVisibleText("1980");
        Assert.assertEquals(112, selectYear.getOptions().size());
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
