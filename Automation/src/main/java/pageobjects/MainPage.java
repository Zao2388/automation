package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zao on 8/18/15.
 */
public class MainPage extends BasePage {
    private final String PAGE_TITTLE="Aunt Bertha | Program Directory";
    @FindBy(className="search-result-postal")
    private WebElement postal;
    @FindBy(className="search-result-count")
    private WebElement count;

    /**
     * Constructor of Page
     * @param driver WebDriver Driver
     */
    public MainPage(WebDriver driver){
        super(driver);
    }
    /**
     * Gets current page title, will try to wait 10 seconds to see if its pressent
     * @return Bool true if equals Static PAGE_TITTLE
     */
    public boolean checkPage(){
        return driver.getTitle(10).equals(this.PAGE_TITTLE);
    }
    /**
     * Gets text for Programs Count for specific zip code
     * @return String Count text
     */
    public String getCount(){
        return this.count.getText();
    }
    /**
     * Gets text for Postal
     * @return String Postal text
     */
    public String getPostal(){
        return this.postal.getText();
    }

    public boolean getPageTitle(){
        String pageTitle =  this.driver.getTitle();
        return pageTitle.equals(PAGE_TITTLE);
    }
}