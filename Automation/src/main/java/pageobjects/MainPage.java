package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zao on 8/18/15.
 */
public class MainPage {
    private final String PAGE_TITTLE="Aunt Bertha | Program Directory";
    private BotStyle driver =null;
    @FindBy(className="search-result-postal")
    private WebElement postal;
    @FindBy(className="search-result-count")
    private WebElement count;

    /**
     *
     * @param driver
     */
    public MainPage(BotStyle driver){
        this.driver=driver;
    }
    public boolean checkPage(){
        return driver.getTitle(10).equals(this.PAGE_TITTLE);
    }
    public String getCount(){
        return this.count.getText();
    }
    public String getPostal(){
        return this.postal.getText();
    }


}