package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.NinjaDashboardPage;
import pages.NinjaHomePage;
import pages.NinjaRegistrationPage;
import utilities.Driver;

import java.util.Map;

public class NinjaRegisterAccountSteps {
WebDriver driver= Driver.getDriver();
NinjaHomePage ninjaHomePage=new NinjaHomePage();
NinjaRegistrationPage ninjaRegistrationPage=new NinjaRegistrationPage();
NinjaDashboardPage ninjaDashboardPage=new NinjaDashboardPage();

    @When("I click on My Account Drop menu")
    public void i_click_on_drop_menu( ) {
    ninjaHomePage.myAccount.click();
    }




    @When("I click on Register option")
    public void i_click_on_option( ) {
    ninjaHomePage.register.click();

    }
    @When("I enter new Account Details into the Mandatory Fields")
    public void i_enter_new_account_details_into_the_mandatory_fields(DataTable dataTable) {
    Map<String,String> data=dataTable.asMap(String.class,String.class);
    ninjaRegistrationPage.firstName.sendKeys(data.get("First_Name"));
    ninjaRegistrationPage.lastName.sendKeys(data.get("Last_Name"));
    ninjaRegistrationPage.email.sendKeys(data.get("EMail"));
    ninjaRegistrationPage.telephone.sendKeys(data.get("Telephone"));
    ninjaRegistrationPage.password.sendKeys(data.get("Password"));
    ninjaRegistrationPage.passwordConfirm.sendKeys(data.get("Password_Confirm"));
    ninjaRegistrationPage.newsletterNo.click();
    ninjaRegistrationPage.agreeCheckbox.click();


    }
    @When("I click on Continue button")
    public void i_click_on_continue_button( ) {
        ninjaRegistrationPage.continueBtn.click();
    }
    @Then("I should see the {string} page")
    public void i_should_see_the_page(String msg) {
    String actualMsg=ninjaDashboardPage.successMsg.getText();
        Assert.assertEquals(msg,actualMsg);
    }
}
