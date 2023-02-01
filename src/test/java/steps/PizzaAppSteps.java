package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver = Driver.getDriver();
    PizzaAppPage pizzaAppPage = new PizzaAppPage();
    String totalPrice = "";
    String pizzaName="";
    String costValue="";
    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) throws InterruptedException {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for (String value: data.values()){
          //System.out.println(value);
        }
//        int quantityInt=Integer.parseInt(data.get("Quantity"));
//        double cost=Double.parseDouble(data.get("Cost"));
//        double total=quantityInt*cost;
//        totalPrice=Double.toString(total);
//        pizzaName=data.get("Pizza");
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropdown,data.get("Pizza")); //selecting value from the Pizza dropdown
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping1Dropdown,data.get("Topping1")); // Mushrooms
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping2Dropdown,data.get("Topping2")); // Extra Cheese
//        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.CONTROL+"A");
//        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity")); // "1";
        pizzaAppPage.nameBox.sendKeys(data.get("Name")); // "Patel Harsh"
        pizzaAppPage.emailBox.sendKeys(data.get("Email"));// "patel@gmail.com
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone")); //"123456789"
        costValue=pizzaAppPage.pizzaCostBox.getAttribute("value");//
        if(data.get("Payment").equals("Cash on Pickup")){
            pizzaAppPage.cashRadioButton.click();
        }pizzaAppPage.creditCardRadioButton.click();
        pizzaAppPage.placeOrderButton.click();

    }


    @Then("user validates that order is created with message {string} {string} {string}")
    public void userValidatesThatOrderIsCreatedWithMessage(String success, String quantity, String pizza) {
       //String expectedMsgDynamic=success+" "+totalPrice+" "+pizzaName;
        String expectedMsg=success+costValue+" "+pizza;
        System.out.println(expectedMsg);
        String actualMessage = pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMsg,actualMessage);

    }
}
