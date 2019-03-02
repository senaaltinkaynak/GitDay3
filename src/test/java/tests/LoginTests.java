package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LoginTests {
            WebDriver driver;

            @BeforeMethod
            public void setUp(){
                Locale.setDefault(new Locale("en", "US"));
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }

            @Test
            public void LoginTest1(){
                driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
                driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
                driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
                String title = driver.getTitle();
                Assert.assertTrue(title.equals("Web Orders"));
            }


    @Test
    public void LogOutTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
        driver.findElement(By.id("ctl00_logout")).click();
        String title=driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Web Orders Login Status");

    }



    @AfterMethod
    public void CleanUp(){
        driver.close();
    }

}
