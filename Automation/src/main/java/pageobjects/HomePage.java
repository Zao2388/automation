package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zao on 8/5/15.
 */
public class HomePage extends BasePage {
    private final String PAGE_TITTLE="Aunt Bertha | Connecting People and Programs";

    @FindBy(id="Zipcode")
    private WebElement zipField;

    @FindBy(id="search-form-button")
    private WebElement searchButton;
    /**
     * Constructor sets the driver
     * @param driver
     */
    public HomePage(WebDriver driver){
        super(driver);
    }
    /**
     * Check current page tittles to see if it matches the PAGE_TITTLE
     * @return Bool true if matches
     */
    public boolean checkPage(){
        return driver.getTitle(10).equals(this.PAGE_TITTLE);
    }
    /**
     * Inserts zip code to the search field
     * @param zip
     */
    public void insertZipCode(String zip){
        this.zipField.sendKeys(zip);
    }
    /**
     * Clicks search button
     * @return MainPage PageObject
     */
    public MainPage clickSearchButton(){
        this.searchButton.click();
        return new MainPage(this.driver);
    }
    public boolean getPageTitle(){
        String pageTitle =  this.driver.getTitle();
        return pageTitle.equals(PAGE_TITTLE);
    }
}
