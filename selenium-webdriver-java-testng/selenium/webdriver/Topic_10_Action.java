package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_10_Action {
    WebDriver driver;
    WebElement element;
    Actions actions;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        actions = new Actions(driver);

    }

    // 01:37:31
    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextBox = driver.findElement(By.id("age"));
        actions.moveToElement(ageTextBox).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Myntra() throws InterruptedException {
        driver.get("http://www.myntra.com/");
        actions.moveToElement(driver.findElement(By.xpath("//a[@class = 'desktop-main' and text()='Kids']"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class = 'desktop-categoryName' and text()='Home & Bath']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class = 'breadcrumbs-crumb' and text()='Kids Home Bath']")).getText(),
                "Kids Home Bath");
    }

    @Test
    public void TC_03_Hover_Fahasha() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.xpath("//span[@class = 'icon_menu']"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Hành Trang Đến Trường']"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text() = 'Luyện Thi Môn Toán']")).click();

//        actions.click(driver.findElement(By.xpath("//ul[@class='nav-links']//a[text()='Kỹ Năng Sống']"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//strong[text()='Toán']")).getText(), "TOÁN");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
