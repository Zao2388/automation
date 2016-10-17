package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResourcesPage extends HomePage {
    private final String PAGE_TITTLE="OGame Homepage";

    //Buildings
    @FindBy(css = "#button1 > div > div > a")
    private WebElement metal_mine;

    @FindBy(css = "#button2 > div > div > a")
    private WebElement crystal_mine;

    @FindBy(css = "#button3 > div > div > a")
    private WebElement deut_mine;

    @FindBy(css = "#button4 > div > div > a")
    private WebElement solar_plant;

    //Click option to get building costs

    @FindBy(css = "#button4 > div > div > a#details")
    private WebElement solar_plant_details;
    //Costs calculation
    @FindBy(css = "#buildDuration")
    private WebElement build_duration;

    @FindBy(css = "#content > ul > li:nth-child(2) > span")
    private WebElement build_energy;

    @FindBy(css = "#costs > li.metal.tooltip > div.cost")
    private WebElement build_metal;

    @FindBy(css = "#costs > li.crystal.tooltip > div.cost")
    private WebElement build_crystal;





    public ResourcesPage(WebDriver driver){
        super(driver);
    }

    public void buildUpBuilding(String type){
        switch (type){
            case "Metal":{
                this.metal_mine.click();
                break;
            }
            case "Crystal":{
                this.crystal_mine.click();
                break;
            }
            case "Deut":{
                this.deut_mine.click();
                break;
            }
            case "Solar":{
                this.solar_plant.click();
                break;
            }
        }
    }
    public void getSolarPlantDetails(){
        this.solar_plant_details.click();
        String a=this.build_energy.getText();
        String b=this.build_duration.getText();
        String c=this.build_metal.getText();
        String d=this.build_crystal.getText();
        boolean yeah=true;
    }


}
