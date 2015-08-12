package testsuite;

import framework.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by zao on 8/12/15.
 */
public class BaseTest extends SeleniumBase {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url"})
    public void openBrowser(String url){
        /**
         * GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
         */
        this.driver.get(url);
    }

}
