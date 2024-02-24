package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;


public class Hooks {

    WebDriver driver= Driver.getDriver();

    @Given("user navigates to {string} application")
    public void user_navigates_to_web_orders_application(String webApp) {
        if(webApp.equals("WebOrders")){
            driver.get(ConfigReader.getProperty("WebOrdersURL"));
        } else if (webApp.equals("Etsy")) {
            driver.get(ConfigReader.getProperty("EtsyAppURL"));
        } else if (webApp.equals("Orange")) {
            driver.get(ConfigReader.getProperty("OrangeHRAppURL"));
        }else if(webApp.equals("PizzaApp")){
            driver.get(ConfigReader.getProperty("PizzaAppURL"));
        }else if(webApp.equals("RedShelf")){
            driver.get(ConfigReader.getProperty("RedShelfAppURL"));
        }else if(webApp.equals("Guru99")){
            driver.get(ConfigReader.getProperty("Guru99AppURL"));
        }else if(webApp.equals("XYZBank")){
            driver.get(ConfigReader.getProperty("XYZBankURL"));
        } else if (webApp.equals("Ninja")) {
            driver.get(ConfigReader.getProperty("NinjaAppURL"));
        }
    }

    @Before
    public void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        System.out.println("Method runs before scenario");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","myFailure");
        }
      //  driver.quit();
        System.out.println("Method runs after scenario");
    }
}
