package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeAdminUserSearchPage {

    public OrangeAdminUserSearchPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement usernameBox;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    public WebElement userRoleBox;

    @FindBy(xpath = "//div[@role='listbox']//div[2]")
    public WebElement adminSelection;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameBox;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    public WebElement statusBox;

    @FindBy(xpath = "//span[normalize-space()='Enabled']")
    public WebElement enabledSelection;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchBtn;

    @FindBy(xpath = "(//div[@role='option'])[1]")
    public WebElement employeeNameChoose;

    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    public  WebElement actualMsg;
}
