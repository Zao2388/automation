package pageobjects;

import framework.selenium.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final String PAGE_TITTLE="OGame Homepage";

    @FindBy(linkText = "Log out")
    private WebElement logout;
    //Menu
    @FindBy(linkText = "Overview")
    private WebElement overview;

    @FindBy(linkText = "Resources")
    private WebElement resources;

    @FindBy(linkText = "Facilities")
    private WebElement facilities;

    @FindBy(linkText = "Merchant")
    private WebElement merchant;

    @FindBy(linkText = "Research")
    private WebElement research;

    @FindBy(linkText = "Shipyard")
    private WebElement shipyard;

    @FindBy(linkText = "Defense")
    private WebElement defense;

    @FindBy(linkText = "Fleet")
    private WebElement fleet;

    @FindBy(linkText = "Galaxy")
    private WebElement galaxy;

    @FindBy(linkText = "Alliance")
    private WebElement alliance;

    //Resources
     @FindBy(id = "resources_metal")
    private WebElement metal;

    @FindBy(id = "resources_crystal")
    private WebElement crystal;

    @FindBy(id = "resources_deuterium")
    private WebElement deut;

    @FindBy(id = "resources_energy")
    private  WebElement energy;

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

    public void logout(){
        this.logout.click();
    }

    public boolean getPageTitle(){
        String pageTitle =  this.driver.getTitle();
        return pageTitle.equals(PAGE_TITTLE);
    }

    public void clickMenuItem(String option){
        switch (option){
            case "Resources":{
                this.resources.click();
                break;
            }
        }
    }

    public String getMetal(){
        return this.metal.getText();
    }
    public String getCrystal(){
        return this.crystal.getText();
    }
    public String getDeut(){
        return this.deut.getText();
    }
    public String getEnergy(){
        return this.energy.getText();
    }
}
