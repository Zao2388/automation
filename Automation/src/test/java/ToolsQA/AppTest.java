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

public class AppTest{
    private WebDriver driver;

    public void setupSelenium(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    //Como hago para pasarle el URL desde XML
    //@Parameters{url=}
    //Estructura
    public void testSearch(){
        this.setupSelenium();
        driver.navigate().to("http://www.zaosoft.com/");
        String email=driver.findElement(By.cssSelector(".info > li:nth-child(2) > p:nth-child(2)")).getText();
        assertEquals(email,"betoseru23@gmail.com");
    }
    public void closeSelenium(){
        driver.quit();
    }

}
