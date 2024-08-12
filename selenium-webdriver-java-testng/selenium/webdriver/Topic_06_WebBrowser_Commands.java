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

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;

    WebElement element;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    /*Browser*/
    @Test
    public void TC_01_Verify_URL(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String urlLogin = driver.getCurrentUrl();
        Assert.assertEquals(urlLogin,"http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String urlCreate = driver.getCurrentUrl();
        Assert.assertEquals(urlCreate, "http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_Verify_Title(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String titleMyAccount = driver.getTitle();
        Assert.assertEquals(titleMyAccount, "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String titleCreate = driver.getTitle();
        Assert.assertEquals(titleCreate,"Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_Function(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String urlCreate = driver.getCurrentUrl();
        Assert.assertEquals(urlCreate, "http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        String urlLogin = driver.getCurrentUrl();
        Assert.assertEquals(urlLogin,"http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        String titleCreate = driver.getTitle();
        Assert.assertEquals(titleCreate,"Create New Customer Account");
    }

    // Chưa làm được.
    @Test
    public void TC_04_Get_Page_Source_Code(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String pageSource = driver.getPageSource();
    }

    /*Element*/
    @Test
    public void TC_05_Check_isDisplay(){

    }
    @Test
    public void TC_06_Check_isenabled(){

    }
    @Test
    public void TC_07_Check_isSelected(){

    }
    @Test
    public void TC_08_Check_Register_function_MailChimp(){

    }
    /*Lgoin*/
    @Test
    public void TC_09_Empty_Email_Password(){

    }
    @Test
    public void TC_10_Invalid_Email(){

    }
    @Test
    public void TC_11_Invalid_Password(){

    }
    @Test
    public void TC_12_Invalid_Email_Password(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    /*Test pull code*/
}
