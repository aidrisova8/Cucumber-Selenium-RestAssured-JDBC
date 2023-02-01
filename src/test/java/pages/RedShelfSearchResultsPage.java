package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RedShelfSearchResultsPage {

    public RedShelfSearchResultsPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[@class='mdc-typography--headline4']")
    public WebElement actualMessage;

    @FindBy(xpath = "//*[@id='ember32']/div[1]/div")
    public List<WebElement> listAuthors;
}
