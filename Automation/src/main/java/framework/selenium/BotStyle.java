package framework.selenium;

import com.google.common.base.Function;
import framework.utils.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by zao on 8/19/15.
 */
public class BotStyle implements WebDriver {
    private WebDriver driver=null;
    /**
     * Constructor of Bot Style Class
     * @param driver Sets the Driver
     */
    public BotStyle(WebDriver driver){
        this.driver=driver;
    }
    /**
     * Returns the driver
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
    /**
     * Gets the desired URl using the driver's get function
     * @param url
     */
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
    public boolean waitForElementPresent(final By byElement, int noOfSecToWait) {
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
    /**
     * Waits until the element is present and then returns it.
     * @param locator Element locator
     * @param timeToWait Number of seconds to wait
     * @return Found element
     */
    public WebElement findElement(By locator,int timeToWait){
        WebElement element=null;
        if(waitForElementPresent(locator,timeToWait)){
            element=this.driver.findElement(locator);
        }
        return element;
    }
    /**
     * Clicks an element in the current page using the locator
     * @param locator Element locator
     * @param timeToWait Number of seconds to wait
     */
    public void click(By locator,int timeToWait){
        WebElement element=findElement(locator,timeToWait);
        if(element!=null){
            element.click();
        }
    }
    /**
     * Retrieves the page title and returns it.
     * @param timeToWait Number of Seconds to wait
     * @return String title
     */
    public String getTitle(int timeToWait){
        int i=0;
        String pageTitle=null;
        while(i++ <= timeToWait && pageTitle == null){
            pageTitle=driver.getTitle();
            Utilities.waitTime(1);
        }
        return pageTitle;
    }
    @Override
    public void close(){
        this.driver.close();
    }
    @Override
    public String getTitle(){
        return this.driver.getTitle();
    }
    @Override
    public String  getPageSource(){
        return null;
    }
    @Override
    public String getWindowHandle(){
        return null;
    }
    @Override
    public Options manage() {
        return null;
    }
    @Override
    public String getCurrentUrl() {
        return null;
    }
    @Override
    public void quit(){
        this.driver.close();
    }
    @Override
    public TargetLocator switchTo() {
        return null;
    }
    @Override
    public Navigation navigate() {
        return null;
    }
    @Override
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }
    @Override
    public Set<String> getWindowHandles() {
        return null;
    }
    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

}
