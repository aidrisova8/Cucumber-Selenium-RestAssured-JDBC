package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedShelfHomePage;
import pages.RedShelfSearchResultsPage;
import utilities.Driver;

public class RedShelfAppSteps {

    WebDriver driver = Driver.getDriver();
    RedShelfHomePage redShelfHomePage = new RedShelfHomePage();
    RedShelfSearchResultsPage redShelfSearchResultsPage = new RedShelfSearchResultsPage();


    @When("user searches {string} with space in the beginning and at the end")
    public void user_searches_with_space_in_the_beginning_and_at_the_end(String item) {
    redShelfHomePage.searchBox.sendKeys(item+ Keys.ENTER);
    }

    @Then("user validates search message {string}")
    public void user_validates_search_message(String expectedMessage) {
        String actualMsg=redShelfSearchResultsPage.actualMessage.getText();
        System.out.println(expectedMessage);
        System.out.println(actualMsg);
        Assert.assertTrue(actualMsg.contains(expectedMessage));
    }

}
