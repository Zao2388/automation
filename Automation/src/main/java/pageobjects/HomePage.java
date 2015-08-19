package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zao on 8/5/15.
 */
public class HomePage {
    private final String PAGE_TITTLE="Aunt Bertha | Connecting People and Programs";
    private BotStyle driver =null;

    @FindBy(id="Zipcode")
    private WebElement zipField;

    @FindBy(id="search-form-button")
    private WebElement searchButton;

    /**
     *
     * @param driver
     */
    public HomePage(BotStyle driver){
        this.driver=driver;
    }

    /**
     *
     * @return
     */
    public boolean checkPage(){
        return driver.getTitle(10).equals(this.PAGE_TITTLE);
    }

    public void insertZipCode(String zip){
        this.zipField.sendKeys(zip);
    }

    /**
     *
     * @return
     */
    public MainPage clickSearchButton(){
        this.searchButton.click();
        return new MainPage(this.driver);
    }
}
