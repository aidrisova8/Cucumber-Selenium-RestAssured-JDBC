package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeCreateEmployeePage {

    public OrangeCreateEmployeePage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath ="//input[@name='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBtn;


}
