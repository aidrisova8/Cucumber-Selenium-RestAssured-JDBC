package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class XYZBankHomePage {
    public XYZBankHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    public WebElement BankMngrLoginBtn;
}
