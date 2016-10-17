package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.ResourcesPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class HomePageTest extends BaseTest{
    /**
     * Does a login test with the values in the XML
     * @param universe
     * @param username
     * @param password
     */
    @Test(groups = {"Smoke","login"})
    @Parameters(value={"uni","user","pass"})
    public void testLogin(String universe,String username,String password){
        LoginPage login = PageFactory.initElements(getWebDriver(),LoginPage.class);
        assertTrue(login.checkPage(),"HomePage was not Loaded");
        login.login(universe,username,password);

        HomePage home = PageFactory.initElements(getWebDriver(),HomePage.class);
        String metal_amount = home.getMetal();
        String crystal_amount = home.getCrystal();
        String deut_amount = home.getDeut();

        assertNotNull(metal_amount);
        assertNotNull(crystal_amount);
        assertNotNull(deut_amount);

        home.clickMenuItem("Resources");
        ResourcesPage resources = PageFactory.initElements(getWebDriver(),ResourcesPage.class);

        //Attemp to  buil up mines as res and energy are available
        resources.getSolarPlantDetails();
//        resources.buildUpBuilding("Solar");
//        resources.buildUpBuilding("Crystal");
        resources.logout();


    }
}
