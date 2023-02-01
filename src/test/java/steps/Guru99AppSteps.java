package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Guru99HomePage;
import pages.Guru99LoginPage;
import utilities.Driver;

public class Guru99AppSteps {

    WebDriver driver= Driver.getDriver();
    Guru99LoginPage guru99LoginPage=new Guru99LoginPage();
    Guru99HomePage guru99HomePage=new Guru99HomePage();

    @When("user enters email {string} and password {string} and clicks on login button")
    public void user_enters_email_and_password_and_clicks_on_login_button(String email, String password) {
    guru99LoginPage.email.sendKeys(email);
    guru99LoginPage.password.sendKeys(password);
    guru99LoginPage.signInBtn.click();

    }



    @Then("user validates success msg {string}")
    public void user_validates_success_msg(String expectedMsg) {
    String actualMsg=guru99HomePage.successMsg.getText();
        System.out.println(expectedMsg);
        System.out.println(actualMsg);
        Assert.assertEquals(expectedMsg,actualMsg);
    }

}
