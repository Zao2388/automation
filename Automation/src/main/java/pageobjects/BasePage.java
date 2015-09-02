package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;

/**
 * Created by zao on 9/1/15.
 */
public abstract class BasePage {
    protected BotStyle driver;
    public BasePage(WebDriver driver) {
        this.driver = new BotStyle(driver);
    }
    public abstract boolean getPageTitle();
}
