package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static WebDriver driver;
    public static String testURL = "https://www.utest.com";

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(testURL);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}