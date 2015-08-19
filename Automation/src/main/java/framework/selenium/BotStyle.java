package framework.selenium;

import com.google.common.base.Function;
import framework.utils.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by zao on 8/19/15.
 */
public class BotStyle {
    private WebDriver driver=null;

    public BotStyle(WebDriver driver){
        this.driver=driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void get(String url){
        this.driver.get(url);
    }
    /**
     * This method waits up to a number of seconds for an
     * element to appear in the page.
     *
     * @param byElement     Element to wait for
     * @param noOfSecToWait Max time to wait
     * @return true = if the element was displayed in the page.
     *         false = the element was not displayed in the page.
     */
    public boolean waitForElementPresent(By byElement, int noOfSecToWait) {
        boolean isElementPresent = true;

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(noOfSecToWait, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(byElement);
                }
            });
        } catch (TimeoutException te) {
            isElementPresent = false;
        } catch (Exception e) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public WebElement findElement(By locator,int timeToWait){
        WebElement element=null;
        if(waitForElementPresent(locator,timeToWait)){
            element=this.driver.findElement(locator);
        }
        return element;
    }

    public void click(By locator,int timeToWait){
        WebElement element=findElement(locator,timeToWait);
        if(element!=null){
            element.click();
        }
    }
    public String getTitle(int timeToWait){
        int i=0;
        String pageTitle="";
        while(i++ <= timeToWait && pageTitle == null){
            pageTitle=driver.getTitle();
            Utilities.waitTime(1);
        }
        return pageTitle;
    }
}
