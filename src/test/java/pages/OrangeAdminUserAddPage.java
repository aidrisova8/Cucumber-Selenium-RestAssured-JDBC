package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeAdminUserAddPage {

    public OrangeAdminUserAddPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")////div[@role='option'])[2]
    public WebElement dropdown1;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    public WebElement dropdown2;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement userName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement password;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveBtn;
}
