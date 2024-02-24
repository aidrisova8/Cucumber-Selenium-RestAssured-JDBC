package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.XYZBankHomePage;
import pages.XYZBankMainPage;
import utilities.Driver;

public class XYZBankSteps {


        WebDriver driver = Driver.getDriver();
        XYZBankHomePage xyzBankHomePage=new XYZBankHomePage();
        XYZBankMainPage xyzBankMainPage=new XYZBankMainPage();

        @When("user clicks Bank Manager Login  and Add Customer on the top buttons")
        public void user_clicks_bank_manager_login_and_add_customer_on_the_top_buttons() throws InterruptedException {
        xyzBankHomePage.BankMngrLoginBtn.click();
        xyzBankMainPage.addCustomerBtn.click();

        }

        @When("user enters First Name {string}, Last Name {string} , and Post Code  {string} and clicks on Add customer button on the bottom")
        public void user_enters_first_name_last_name_and_post_code_and_clicks_on_add_customer_button_on_the_bottom(String firstname, String lastname, String postcode) {
        xyzBankMainPage.firstName.sendKeys(firstname);
        xyzBankMainPage.lastName.sendKeys(lastname);
        xyzBankMainPage.postCode.sendKeys(postcode);
        xyzBankMainPage.AddCustomerSubmitBtn.click();
        }

        @Then("user should see message {string}")
        public void user_should_see_message(String expectedMsg) {
                Alert alert=driver.switchTo().alert();
                String message=alert.getText();
                alert.accept();
                String actualmessage=message.substring(0,message.lastIndexOf(" "));
                System.out.println(actualmessage);
                System.out.println(expectedMsg);
             Assert.assertEquals(actualmessage,expectedMsg);
    }
}
