package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    private final String PAGE_TITTLE="OGame Homepage";

    @FindBy(id="serverLogin")
    private WebElement universe;

    @FindBy(id="usernameLogin")
    private WebElement username;

    @FindBy(id="passwordLogin")
    private WebElement password;

    @FindBy(id="loginSubmit")
    private WebElement submit;

    @FindBy(id="loginBtn")
    private WebElement loginBtn;

    /**
     * Constructor sets the driver
     * @param driver
     */
    public LoginPage(WebDriver driver){
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
     * Logs in a username on certain Universe
     * @param universe
     * @param username
     * @param password
     */
    public void login(String universe,String username, String password){
        this.loginBtn.click();
        this.driver.waitForElementPresent(By.id("loginSubmit"),5);
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        this.submit.click();
    }

    public boolean getPageTitle(){
        String pageTitle =  this.driver.getTitle();
        return pageTitle.equals(PAGE_TITTLE);
    }
}
