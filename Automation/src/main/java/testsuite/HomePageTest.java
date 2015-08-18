package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        HomePage HomePage= new HomePage(this.driver);
        if(HomePage.checkPage()){
            HomePage.insertZipCode(zip);
            MainPage MainPage=HomePage.clickSearchButton();
            assertTrue(MainPage.checkPage());
        }else{
            assertFalse(false,"Error");
        }
    }
}
