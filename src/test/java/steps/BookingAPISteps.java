package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Booking;
import pojos.Bookingdates;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingAPISteps {
    Response response;
    String bookingId;
    Booking booking;

    @Given("user creates booking with post api call with data")
    public void userCreatesBookingWithPostApiCallWithData(DataTable dataTable) {
        Map<String,Object> data=dataTable.asMap(String.class,Object.class);

        booking=new Booking();
        booking.setFirstname(data.get("firstname").toString());
        booking.setLastname(data.get("lastname").toString());
        booking.setTotalprice(Integer.valueOf(data.get("totalprice").toString()));
        booking.setDepositpaid(Boolean.valueOf(data.get("depositpaid").toString()));
        booking.setAdditionalneeds(data.get("additionalneeds").toString());
        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin(data.get("chekin").toString());
        bookingdates.setCheckout(data.get("chekout").toString());
        booking.setBookingdates(bookingdates);

       response=given().baseUri("https://restful-booker.herokuapp.com")
               .and().header("Content-Type","application/json")
               .and().header("Accept","application/json")
               .and().body(booking) //POJO ->JSON == Serialization
               .when().post("/booking");
       response.then().log().all();
       bookingId=response.body().jsonPath().getString("bookingid");
    }

    @When("user sends get booking api call")
    public void userSendsGetBookingApiCall() {
        response=given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Accept","application/json")
                .when().get("/booking/"+bookingId);
        response.then().log().all();
    }


    @Then("user validates status code {int}")
    public void userValidatesStatusCode(int statusCode) {
        response.then().statusCode(statusCode);

    }

    @And("user validates data matches with created data")
    public void userValidatesDataMatchesWithCreatedData() {
    Booking responseBody =response.body().as(Booking.class);//JSON ->POJO =Deserialization
        Assert.assertEquals(booking.toString(),responseBody.toString());

    }

    @When("user deletes booking")
    public void userDeletesBooking() {
        response=given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Cookie","token="+generateToken())
                .when().delete("/booking/"+bookingId);
        response.then().log().all();
    }

    public  String generateToken(){
       response=given().baseUri("https://restful-booker.herokuapp.com")
               .and().contentType(ContentType.JSON)
               .and().body("{\n" +
                       "    \"username\" : \"admin\",\n" +
                       "    \"password\" : \"password123\"\n" +
                       "}")
               .when().post("/auth");
       response.then().log().all();
       return response.body().jsonPath().getString("token");
    }

    @When("user updates booking")
    public void userUpdatesBooking(DataTable dataTable) {
        Map<String,Object> data=dataTable.asMap(String.class,Object.class);

        booking=new Booking();
        booking.setFirstname(data.get("firstname").toString());
        booking.setLastname(data.get("lastname").toString());
        booking.setTotalprice(Integer.valueOf(data.get("totalprice").toString()));
        booking.setDepositpaid(Boolean.valueOf(data.get("depositpaid").toString()));
        booking.setAdditionalneeds(data.get("additionalneeds").toString());
        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin(data.get("chekin").toString());
        bookingdates.setCheckout(data.get("chekout").toString());
        booking.setBookingdates(bookingdates);

        response=given().baseUri("https://restful-booker.herokuapp.com")
                .and().contentType(ContentType.JSON)
                .and().header("Accept","application/json")
                .and().header("Cookie","token="+generateToken())
                .and().body(booking)
                .when().put("/booking/"+bookingId);
        response.then().log().all();

    }

    @And("user validates response body matches with updated data")
    public void userValidatesResponseBodyMatchesWithUpdatedData() {
       Booking responseBooking= response.body().as(Booking.class);
       Assert.assertEquals(booking.toString(),responseBooking.toString());
    }
}
