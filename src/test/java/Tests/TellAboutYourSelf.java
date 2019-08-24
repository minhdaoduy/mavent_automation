package Tests;

import BusinessFlows.*;
import org.testng.annotations.Test;

import java.util.*;

public class TellAboutYourSelf extends FunctionalTest {
//    public WebDriver driver;
    public HomePage homePage;

    //-----------------------------------Tests-----------------------------------
    @Test
    public void firstTest () {
        homePage = new HomePage(driver);
        homePage.openSignUpPage();
        HashMap map = new HashMap();

        //Create Test Data
        map.put("email","daoduyminh@gmail.com");
        map.put("firstName","Minh");
        map.put("lastName","Dao Duy");
        GregorianCalendar birthday  = new GregorianCalendar(1987, Calendar.MAY, 25);
        map.put("birthday",birthday);
        map.put("gender","Male");

        homePage.inputSignUpPage(map);
    }

}