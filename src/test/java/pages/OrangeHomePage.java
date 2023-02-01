package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHomePage {
    public OrangeHomePage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Admin")
    public WebElement adminBtn;

    @FindBy(linkText = "PIM")
    public WebElement PIMTab;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
    public WebElement arrowBtn;

}
