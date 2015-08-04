package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
/**
 * Unit test for simple App.
 */
public class AppTest{
    private WebDriver driver;

    public void setupSelenium(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    //Como hago para pasarle el URL desde XML
    //@Parameters{url=}
    public void testSearch(){
        /**
         * http://www.iluv2code.com/test-project-selenium2-testng-maven.html
         */
/*        driver.navigate().to("http://staging.businessuites.com");
        driver.findElement(By.cssSelector("#Inquire_first_name")).clear();
        driver.findElement(By.cssSelector("#Inquire_first_name")).sendKeys("Roberto Test");
        driver.findElement(By.cssSelector("#Inquire_last_name")).clear();
        driver.findElement(By.cssSelector("#Inquire_last_name")).sendKeys("Test");
        driver.findElement(By.cssSelector("#Inquire_company")).clear();
        driver.findElement(By.cssSelector("#Inquire_company")).sendKeys("GAP");
        driver.findElement(By.cssSelector("#Inquire_phone")).clear();
        driver.findElement(By.cssSelector("#Inquire_phone")).sendKeys("1234567895");
        driver.findElement(By.cssSelector("#Inquire_email")).clear();
        driver.findElement(By.cssSelector("#Inquire_email")).sendKeys("rserrano@wearegap.com");

        driver.findElement(By.cssSelector("#btn_inquire_55c0ed26df3dd")).click();
        assertEquals("this","this","this");*/
        driver.navigate().to("http://www.iluv2code.com");

        String searchTerm = "Java";

        //Clear the search box and ype searchTerm
        driver.findElement(By.cssSelector("#s")).clear();
        driver.findElement(By.cssSelector("#s")).sendKeys(searchTerm);

        //Click on the magnifying glass
        driver.findElement(By.cssSelector("#searchsubmit")).click();

        //Get search term for search results, to check if matches the given search
        String termInTitle =
                driver.findElement(By.cssSelector("#archive-title>strong")).getText();

        assertEquals(termInTitle, searchTerm,
                "Search term not found in search results");
    }
    public void closeSelenium(){
        driver.quit();
    }

}
