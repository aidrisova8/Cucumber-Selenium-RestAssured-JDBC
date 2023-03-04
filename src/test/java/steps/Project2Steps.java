package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.YardProject2;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Project2Steps {

    YardProject2 yardProject2;
    Response response;
    String id2;
    String location;
    String newLocation;

    @Given("user creates yard with post api call with data")
    public void user_creates_yard_with_post_api_call_with_data(DataTable dataTable) {
        Map<String,Object> data=dataTable.asMap(String.class,Object.class);
        yardProject2 = new YardProject2();
//       yardProject2.setId(Integer.valueOf(data.get("id").toString())); no need
        yardProject2.setContacts(new Object[0]);
        yardProject2.setLocation(data.get("location").toString());
        yardProject2.setName(data.get("name").toString());
        yardProject2.setStatus(data.get("status").toString());
        yardProject2.setAddress(data.get("address").toString());
        yardProject2.setApt_suite_company_co(Integer.valueOf(data.get("apt_suite_company_co").toString()));
        yardProject2.setCity(data.get("city").toString());
        yardProject2.setState(data.get("state").toString());
        yardProject2.setZip_code(Integer.valueOf(data.get("zip_code").toString()));
        yardProject2.setSpots(Integer.valueOf(data.get("spots").toString()));

        response=given().baseUri(ConfigReader.getProperty("LogisticsBaseURI"))
                .and().header("Content-Type","application/json")
                .and().header("Authorization","Token 0c35e6c58d0f260a1a312e4e26a3beef395182c2")
                .and().header("Accept","application/json")
                .and().body(yardProject2)
                .when().post("/yards/");
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
        response.then().log().all();
         id2=response.body().jsonPath().getString("id");
    }



    @When("user sends get yard api call")
    public void user_sends_get_yard_api_call() {
        response=given().baseUri(ConfigReader.getProperty("LogisticsBaseURI"))
                .and().header("Content-Type","application/json")
                .and().header("Authorization","Token 0c35e6c58d0f260a1a312e4e26a3beef395182c2")
                .and().header("Accept","application/json")
                .when().get("/yards/"+id2);
        System.out.println(response.statusCode());
        response.then().log().all();


    }
    @Then("user verify status code {int}")
    public void user_verify_status_code(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());

    }

    @Given("user updates yard with patch api call with data")
    public void userUpdatesYardWithPatchApiCallWithData(DataTable dataTable2) {
        Map<String,Object> data1=dataTable2.asMap(String.class,Object.class);
      newLocation= data1.get("location").toString();
        response=given().baseUri(ConfigReader.getProperty("LogisticsBaseURI"))
                .and().header("Content-Type","application/json")
                .and().header("Authorization","Token 0c35e6c58d0f260a1a312e4e26a3beef395182c2")
                .and().header("Accept","application/json")
                .and().body(data1)
                .when().patch("/yards/"+id2+"/");
        System.out.println(response.statusCode());
        response.then().log().all();
        location=response.body().jsonPath().getString("location");


    }

    @And("user validates updated location is displayed in get response body")
    public void userValidatesUpdatedLocationIsDisplayedInGetResponseBody() {
       Assert.assertEquals(newLocation,location);
    }
}
