package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class XYZBankMainPage {

    public XYZBankMainPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerBtn;

    @FindBy(xpath = "//input[@ng-model='fName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    public WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement AddCustomerSubmitBtn;
}
