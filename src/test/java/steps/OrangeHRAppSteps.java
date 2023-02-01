package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.Driver;

import java.util.Map;

public class OrangeHRAppSteps {

        WebDriver driver= Driver.getDriver();
        OrangeLoginPage orangeLoginPage=new OrangeLoginPage();
        OrangeHomePage orangeHomePage=new OrangeHomePage();
        OrangePIMPage orangePIMPage=new OrangePIMPage();
        OrangeCreateEmployeePage orangeCreateEmployeePage=new OrangeCreateEmployeePage();
        OrangeAdminUserAddPage orangeAdminUserAddPage=new OrangeAdminUserAddPage();
        OrangeAdminUserSearchPage orangeAdminUserSearchPage=new OrangeAdminUserSearchPage();

    @When("user enters username {string} and password {string} and clicks on login button and creates employee and admin user")
    public void userEntersUsernameAndPasswordAndClicksOnLoginButtonAndCreatesEmployeeAndAdminUserAndSearchAdminUser(String username, String password) throws InterruptedException {
        orangeLoginPage.username.sendKeys(username);
        orangeLoginPage.password.sendKeys(password);
        orangeLoginPage.loginBtn.click();
        orangeHomePage.PIMTab.click();
        orangePIMPage.addBtn.click();
        orangeCreateEmployeePage.firstNameInput.sendKeys("Ammy");
        orangeCreateEmployeePage.lastNameInput.sendKeys("Doe");
        Thread.sleep(3000);
        orangeCreateEmployeePage.saveBtn.click();
        orangeHomePage.adminBtn.click();
        orangePIMPage.addBtn.click();

        WebDriverWait wait1=new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOf(orangeAdminUserAddPage.password)).sendKeys("Admin134$");
        orangeAdminUserAddPage.dropdown1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@role='listbox']//div[2]")).click();
//        orangeAdminUserAddPage.dropdown1.sendKeys(Keys.ARROW_DOWN);
//        orangeAdminUserAddPage.dropdown1.click();

        orangeAdminUserAddPage.dropdown2.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Enabled']")).click();
//        orangeAdminUserAddPage.dropdown2.sendKeys(Keys.ARROW_DOWN);
//        orangeAdminUserAddPage.dropdown2.click();
        WebDriverWait wait2=new WebDriverWait(driver,10);
        wait2.until(ExpectedConditions.visibilityOf(orangeAdminUserAddPage.confirmPassword)).sendKeys("Admin134$");
        orangeAdminUserAddPage.employeeName.sendKeys("Ammy Doe");
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@role='option'])[1]")))).click();
        orangeAdminUserAddPage.userName.sendKeys("AmmyDoe");
        Thread.sleep(5000);
                orangeAdminUserAddPage.saveBtn.click();

 }

    @And("user search for System User with data")
    public void user_search_for_system_user_with_data(DataTable dataTable) throws InterruptedException {
        Map<String,String> data=dataTable.asMap(String.class,String.class);
        for(String el:data.values()){
            System.out.println(el);
        }
        orangeHomePage.adminBtn.click();
        orangeAdminUserSearchPage.usernameBox.sendKeys(data.get("Username"));
        orangeAdminUserSearchPage.userRoleBox.click();
        orangeAdminUserSearchPage.adminSelection.click();
        Thread.sleep(3000);
        orangeAdminUserSearchPage.employeeNameBox.sendKeys(data.get("Employee Name"));
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orangeAdminUserSearchPage.employeeNameChoose)).click();
        orangeAdminUserSearchPage.statusBox.click();
        orangeAdminUserSearchPage.enabledSelection.click();
        orangeAdminUserSearchPage.searchBtn.click();


    }


    @Then("user validates admin user was found with message {string}")
    public void user_validates_admin_user_was_found_with_message(String expectedMessage) {
     String actualMsg=orangeAdminUserSearchPage.actualMsg.getText();
        System.out.println(actualMsg);
        Assert.assertEquals(expectedMessage,actualMsg);
    }

}

