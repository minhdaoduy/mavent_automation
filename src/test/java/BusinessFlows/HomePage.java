package BusinessFlows;

import PageObjects.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class HomePage {
    static WebDriver driver;
    public CommonFunctions commonFunctions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        commonFunctions = new CommonFunctions(driver);
    }

    public void openSignUpPage(){
        commonFunctions.clickElementByXpath("//div[contains(@class,'guest ')]//a[@href='/signup/personal']");
    }

    public void inputSignUpPage(Map map){
        GregorianCalendar birthday = (GregorianCalendar)map.get("birthday");
        commonFunctions.inputElementById("firstName",(String)map.get("firstName"));
        commonFunctions.inputElementById("lastName",(String)map.get("lastName"));

        int month = birthday.get(Calendar.MONTH);
        int date = birthday.get(Calendar.DATE);
        int year = birthday.get(Calendar.YEAR);;
        String birthMonth;
        if (month != 4)
            birthMonth = "Not defind yet";
        else
            birthMonth = "May";
//        commonFunctions.clickElementByXpath("//div[@name='birthMonth']");
        commonFunctions.clickElementByName("birthMonth");
        commonFunctions.clickElementByXpath("//span[./div[text()='" + birthMonth + "']]");

        commonFunctions.inputElementById("email",(String)map.get("email"));

        commonFunctions.clickElementByXpath("//div[@name='birthDay']");

        commonFunctions.clickElementByXpath("//span[./div[text()='" + date + "']]");

//        commonFunctions.clickElementByXpath("//div[@name='birthYear']");
        commonFunctions.clickElementByName("birthYear");
        commonFunctions.clickElementByXpath("//span[./div[text()='" + year + "']]");

//        commonFunctions.clickElementByXpath("//div[@name='genderCode']");
        commonFunctions.clickElementByName("genderCode");
        commonFunctions.clickElementByXpath("//span[./div[text()='" + (String)map.get("gender") + "']]");

        commonFunctions.clickElementByXpath("//a[@class='btn btn-blue']");
    }
}