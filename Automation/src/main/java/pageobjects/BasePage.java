package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by zao on 9/1/15.
 */
public abstract class BasePage extends LoadableComponent<BasePage>  {
    protected BotStyle driver;
    public BasePage(WebDriver driver) {
        this.driver = new BotStyle(driver);
    }
    public abstract boolean getPageTitle();
    @Override
    protected void load() {
        driver.get("http://code.google.com/p/selenium/issues/entry");
    }
    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
    }
}
