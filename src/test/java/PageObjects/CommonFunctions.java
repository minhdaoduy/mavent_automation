package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions {
    static WebDriver driver;
    WebDriverWait wait;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public String getTextByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        //Print page's title
        System.out.println("Text is: " + element);

        //Assertion
        return text;
    }

    public void verifyTextElementByXpath(String xpath, String expectedValue, Boolean isEqual){
        String value = this.getTextByXpath(xpath);

        //Assertion
        if (isEqual)
            Assert.assertEquals(value, expectedValue);
        else
            Assert.assertTrue(value.contains(expectedValue));
    }

    public void clickElementByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void clickElementByName(String name){
        WebElement element = driver.findElement(By.name(name));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void inputElementByXpath(String xpath, String key){
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(key);
    }

    public void inputElementById(String id, String key){
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(key);
    }
}
