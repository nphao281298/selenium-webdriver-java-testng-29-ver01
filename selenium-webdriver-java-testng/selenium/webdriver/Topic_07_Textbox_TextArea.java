package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_07_Textbox_TextArea {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_TextBox_TextArea(){
        String myAcoount = "//div[@class = \"footer\"]//a[@title='My Account']";
        String createAnAccount = "//div[@class='main']//a[@title='Create an Account']";
        String email = generateRandomEmail();
        String firstName = "Automation";
        String lastName = " FC";
        String fullName = firstName + lastName;

        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath(myAcoount)).click();
        driver.findElement(By.xpath(createAnAccount)).click();

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Aa@123456");
        driver.findElement(By.id("confirmation")).sendKeys("Aa@123456");

        driver.findElement(By.xpath("//button[@title='Register']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='main']//ul[@class='messages']//span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInfor = driver.findElement(By.xpath("//div[@class='main']//div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactInfor.contains(fullName));
        Assert.assertTrue(contactInfor.contains(email));

        driver.findElement(By.xpath("//div[@class='skip-content']//a[contains(text(),'Mobile')]")).click();

        driver.findElement(By.xpath("//a[@title = 'Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Your Review')]")).click();
        driver.findElement(By.id("Quality 1_5")).click();
        driver.findElement(By.id("review_field")).sendKeys("Automation FC");
        driver.findElement(By.id("summary_field")).sendKeys("Automation FC");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='main']//li[@class='success-msg']//span")).getText(),
                "Your review has been accepted for moderation.");

        driver.findElement(By.xpath("//header[@id='header']//span[contains(text(),'Account')]")).click();
        driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();
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

//    @Test
//    public void TC_02_DropDown_Win(){
//        driver.get("https://egov.danang.gov.vn/reg");
//
//        Select selectCity = new Select(driver.findElement(By.id("thuongtru_tinhthanh")));
//        selectCity.selectByVisibleText("tỉnh Đồng Tháp");
//        selectCity.selectByValue("3678");
//        selectCity.selectByIndex(2);
//        selectCity.selectByVisibleText("tỉnh Đồng Tháp");
//        Assert.assertEquals(66, selectCity.getOptions().size());
//        Assert.assertEquals("tỉnh Đồng Tháp", selectCity.getFirstSelectedOption().getText());
//
//        List<WebElement> selectListCity = selectCity.getOptions();
//        for(WebElement list: selectListCity){
//            System.out.println(list.getText());
//        }
//    }

//    @Test
//    public void TC_03_DropDown_Custom_Win(){
//        driver.get("https://egov.danang.gov.vn/reg");
//        driver.findElement(By.id("thuongtru_tinhthanh")).click();
//        sleepInSeconds(2);
//        List<WebElement> allItems = driver.findElements(By.xpath("//select[@id= 'thuongtru_tinhthanh']//option"));
//        int size = allItems.size();
//        System.out.println(
//                "Item size = " + size
//        );
//        for(WebElement item: allItems){
//            String actualItem = item.getText();
//            System.out.println(item.getText());
//            if (actualItem.equals("Cục trưởng cục cảnh sát Quản lý hành chính và trật tự xã hội")){
//                item.click();
//                break;
//            }
//        }
//    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public static String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        int length = 10;
        String domain = "gmail.com";
        for (int i = 0; i < length; i++) {
            email.append(chars.charAt(random.nextInt(chars.length())));
        }
        return email.toString() + "@" + domain;
    }
}
