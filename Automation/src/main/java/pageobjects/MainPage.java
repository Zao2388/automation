package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zao on 8/18/15.
 */
public class MainPage {
    private final String PAGE_TITTLE="Aunt Bertha | Program Directory ";
    private WebDriver driver =null;
    @FindBy(className="search-result-postal")
    private WebElement postal;
    @FindBy(className="search-result-count")
    private WebElement count;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean checkPage(){
        return driver.getTitle().equals(this.PAGE_TITTLE);
    }
    public String getCount(){
        return this.count.getText();
    }
    public String getPostal(){
        return this.postal.getText();
    }


}