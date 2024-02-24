package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NinjaRegistrationPage {

    public NinjaRegistrationPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

   @FindBy(id="input-firstname")
   public WebElement firstName;

    @FindBy(id="input-lastname")
    public WebElement lastName;

    @FindBy(id="input-email")
    public WebElement email;

    @FindBy(id="input-telephone")
    public WebElement telephone;

    @FindBy(id="input-password")
    public WebElement password;

    @FindBy(id="input-confirm")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//input[@value='0']")
    public WebElement newsletterNo;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;





}
