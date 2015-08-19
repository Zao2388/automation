package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest{

    @Test(groups = {"Smoke"})
    @Parameters({"zip"})
    public void testSearch(String zip){
        /*
        No estaba implementando el pageFactory
         */
//        HomePage HomePage= new HomePage(this.driver);
        HomePage homePage = PageFactory.initElements(this.driver.getDriver(),HomePage.class);
        assertTrue(homePage.checkPage(),"HomePage was not Loaded");
        homePage.insertZipCode(zip);
        MainPage MainPage=homePage.clickSearchButton();
        //Solo para probar el check title
        assertTrue(MainPage.checkPage(),"MainPage was not Loaded");

    }
}
