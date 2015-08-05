package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by zao on 8/5/15.
 */
public class SeleniumBase {
    protected WebDriver driver =null;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
        switch (browser){
            //Cambiar la clase de constanes
            //case Browser.FIREFOX :
            case "Firefox" :
                //Create instance
                this.driver= new FirefoxDriver();
                break;
            case "Chrome" :
                this.driver= new ChromeDriver();
                break;

        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(this.driver != null) {
            this.driver.close();
        }
        // Quit() o Close()
        //Quit closes all windows
        //Close only closes the actual window for that test

    }
}
