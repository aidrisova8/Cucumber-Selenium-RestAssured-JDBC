package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchResultsPage {

    public EtsyAppSearchResultsPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> listOfItemsTitles;

    @FindBy(xpath = "//*[@class='wt-icon wt-icon--smaller-xs']")
    public WebElement filterButton;

    @FindBy(xpath = "//label[contains(text(),'Over $1,500')]")
    public WebElement filterRadioButtonOver1500;

    @FindBy(xpath = "//label[@for='price-input-1']")
    public WebElement filterRadioButtonUnder250;

    @FindBy(xpath = "//label[@for='price-input-2']")
    public WebElement filterRadioButtonBetween50And500;

    @FindBy(xpath = "//label[@for='price-input-3']")
    public WebElement filterRadioButtonBetween500And1000;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement applyBtn;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//p[1]//span[@class='currency-value']")
    public List<WebElement> listOfItemsPrices;


    @FindBy(xpath = "//label[contains(text(),'Under $250')]")
    public WebElement filterRadioButtonUnderr250;

    @FindBy(xpath = "//label[contains(text(),'$250 to $750')]")
    public WebElement filterRadioButton250to750;

    @FindBy(xpath = "//label[contains(text(),'$750 to $1500')]")
    public WebElement filterRadioButton750to1500;
}
