package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NinjaHomePage {

 public NinjaHomePage(){
     WebDriver driver=Driver.getDriver();
     PageFactory.initElements(driver,this);
 }

 @FindBy(css=".fa.fa-user")
    public WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement register;

}

