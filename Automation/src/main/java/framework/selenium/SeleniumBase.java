package framework.selenium;

import framework.constants.Browser;
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
    private WebDriver webDriver =null;
    protected BotStyle driver=null;
    /**
     * Sets the driver with the driver specified in the XML file
     * @param browser
     */
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
        switch (browser){
            case Browser.FIREFOX :
                //Create instance
                //Capabilities implementation
                this.webDriver= new FirefoxDriver();
                break;
            case Browser.CHROME :
                this.webDriver= new ChromeDriver();
                break;

        }
        this.driver=new BotStyle(this.webDriver);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected WebDriver getWebDriver(){
        return this.driver;
    }
    /**
     * Closes the driver
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(this.webDriver != null) {
            this.webDriver.close();
        }
        // Quit() o Close()
        //Quit closes all windows
        //Close only closes the actual window for that test
    }
}
