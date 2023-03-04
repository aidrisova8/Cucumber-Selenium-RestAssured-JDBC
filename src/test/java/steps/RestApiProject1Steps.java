package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class RestApiProject1Steps {

    Response response;

    @Given("userr creates company with post call")
//    public void userr_creates_company_with_post_call() {
//        Random random=new Random();
//        long mc_number=999999999+random.nextInt(10000000);
//        long dot_number=999999999+random.nextInt(10000000);
//        Response response=given().baseUri(ConfigReader.getProperty("LogisticsBaseURI"))
//                .and().header("Authorization","Token 304ac80fb73abd62bfbcfcfac9d56ab405248062")
//                .and().header("Content-Type","application/json")
//                .and().body("{\n" +
//                        "    \"company_name\": \"Myoo\",\n" +
//                        "    \"company_type\": \"broker company\",\n" +
//                        "    \"status\": \"active\",\n" +
//                        "    \"mc_number\": \""+mc_number+"\",\n" +
//                        "    \"dot_number\": \""+dot_number+"\",\n" +
//                        "    \"ifta\": false,\n" +
//                        "    \"address\": \"21 Lake rd\",\n" +
//                        "    \"apt_suite_company_co\": null,\n" +
//                        "    \"city\": \"Trebton\",\n" +
//                        "    \"state\": \"DE\",\n" +
//                        "    \"zip_code\": \"45066\",\n" +
//                        "    \"insurance\": \"WoofWoof\",\n" +
//                        "    \"producer_address\": \"22 View Rd\",\n" +
//                        "    \"producer_apt_suite_company_co\": null,\n" +
//                        "    \"producer_city\": \"Cincy\",\n" +
//                        "    \"producer_state\": \"KY\",\n" +
//                        "    \"producer_zip_code\": \"23656\",\n" +
//                        "    \"policy_effective_day\": null,\n" +
//                        "    \"policy_expiration\": null,\n" +
//                        "    \"type_of_insurance\": null,\n" +
//                        "    \"automobile_liability\": \"\",\n" +
//                        "    \"num_of_truck_insured\": null,\n" +
//                        "    \"policy_number\": null,\n" +
//                        "    \"employer_id_num\": \"56-6666667\",\n" +
//                        "    \"billing_address\": null,\n" +
//                        "    \"bank_name\": null,\n" +
//                        "    \"routing_number\": null,\n" +
//                        "    \"account_number\": null,\n" +
//                        "    \"president_full_name\": null,\n" +
//                        "    \"trucks_in_fleet\": null,\n" +
//                        "    \"scac_code\": \"\",\n" +
//                        "    \"other_licenses\": false,\n" +
//                        "    \"license_name\": null,\n" +
//                        "    \"incorporated_in\": null,\n" +
//                        "    \"notes\": null,\n" +
//                        "    \"company_picture\": [],\n" +
//                        "    \"company_documents\": [],\n" +
//                        "    \"contacts\": [\n" +
//                        "        {\n" +
//                        "            \"phone\": \"567-526-9633\",\n" +
//                        "            \"ext\": \"\",\n" +
//                        "            \"contact_name\": \"\",\n" +
//                        "            \"email\": \"woof@gmail.com\",\n" +
//                        "            \"fax\": \"\",\n" +
//                        "            \"producer_phone\": \"598-636-6333\",\n" +
//                        "            \"producer_phone_ext\": \"\",\n" +
//                        "            \"producer_contact_name\": \"\",\n" +
//                        "            \"producer_email\": \"woof@gmail.com\"\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"phone_number\": [\n" +
//                        "        {\n" +
//                        "            \"phone\": \"567-526-9633\",\n" +
//                        "            \"ext\": \"\",\n" +
//                        "            \"contact_name\": \"\",\n" +
//                        "            \"email\": \"woof@gmail.com\",\n" +
//                        "            \"fax\": \"\",\n" +
//                        "            \"producer_phone\": \"598-636-6333\",\n" +
//                        "            \"producer_phone_ext\": \"\",\n" +
//                        "            \"producer_contact_name\": \"\",\n" +
//                        "            \"producer_email\": \"woof@gmail.com\"\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"fax_number\": [\n" +
//                        "        {\n" +
//                        "            \"fax\": \"\"\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"email_number\": [\n" +
//                        "        {\n" +
//                        "            \"email\": \"woof@gmail.com\"\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"producer_email_number\": [\n" +
//                        "        {\n" +
//                        "            \"producer_email\": \"woof@gmail.com\"\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"producer_phone_number\": [\n" +
//                        "        {\n" +
//                        "            \"producer_phone\": \"598-636-6333\",\n" +
//                        "            \"producer_phone_ext\": \"\",\n" +
//                        "            \"producer_contact_name\": \"\"\n" +
//                        "        }\n" +
//                        "    ]\n" +
//                        "}")
//                .when().post("/companies/");
//        System.out.println(response.statusCode());
//        System.out.println(response.body().asString());
//        response.then().log().all();
//
//    }
//


    @When("userr updates company name with patch call")
    public void userr_updates_company_name_with_patch_call() {
        Faker faker=new Faker();

        response=given().baseUri(ConfigReader.getProperty("LogisticsBaseURI"))
                .and().header("Authorization","Token 304ac80fb73abd62bfbcfcfac9d56ab405248062")
                .and().header("Content-Type","application/json")
                .and().body("{\n" +
                        "    \"company_name\": \""+faker.name().name()+"\",\n" +
                        "    \"company_type\": \"broker company\",\n" +
                        "    \"status\": \"active\",\n" +
                        "    \"mc_number\": \"25636655\",\n" +
                        "    \"dot_number\": \"89656621\",\n" +
                        "    \"ifta\": false,\n" +
                        "    \"address\": \"21 Lake rd\",\n" +
                        "    \"apt_suite_company_co\": null,\n" +
                        "    \"city\": \"Trebton\",\n" +
                        "    \"state\": \"DE\",\n" +
                        "    \"zip_code\": \"45066\",\n" +
                        "    \"insurance\": \"WoofWoof\",\n" +
                        "    \"producer_address\": \"22 View Rd\",\n" +
                        "    \"producer_apt_suite_company_co\": null,\n" +
                        "    \"producer_city\": \"Cincy\",\n" +
                        "    \"producer_state\": \"KY\",\n" +
                        "    \"producer_zip_code\": \"23656\",\n" +
                        "    \"policy_effective_day\": null,\n" +
                        "    \"policy_expiration\": null,\n" +
                        "    \"type_of_insurance\": null,\n" +
                        "    \"automobile_liability\": \"\",\n" +
                        "    \"num_of_truck_insured\": null,\n" +
                        "    \"policy_number\": null,\n" +
                        "    \"employer_id_num\": \"56-6666667\",\n" +
                        "    \"billing_address\": null,\n" +
                        "    \"bank_name\": null,\n" +
                        "    \"routing_number\": null,\n" +
                        "    \"account_number\": null,\n" +
                        "    \"president_full_name\": null,\n" +
                        "    \"trucks_in_fleet\": null,\n" +
                        "    \"scac_code\": \"\",\n" +
                        "    \"other_licenses\": false,\n" +
                        "    \"license_name\": null,\n" +
                        "    \"incorporated_in\": null,\n" +
                        "    \"notes\": null,\n" +
                        "    \"company_picture\": [],\n" +
                        "    \"company_documents\": [],\n" +
                        "    \"contacts\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"567-526-9633\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"woof@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"598-636-6333\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"woof@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"phone_number\": [\n" +
                        "        {\n" +
                        "            \"phone\": \"567-526-9633\",\n" +
                        "            \"ext\": \"\",\n" +
                        "            \"contact_name\": \"\",\n" +
                        "            \"email\": \"woof@gmail.com\",\n" +
                        "            \"fax\": \"\",\n" +
                        "            \"producer_phone\": \"598-636-6333\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\",\n" +
                        "            \"producer_email\": \"woof@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"fax_number\": [\n" +
                        "        {\n" +
                        "            \"fax\": \"\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"email_number\": [\n" +
                        "        {\n" +
                        "            \"email\": \"woof@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_email_number\": [\n" +
                        "        {\n" +
                        "            \"producer_email\": \"woof@gmail.com\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"producer_phone_number\": [\n" +
                        "        {\n" +
                        "            \"producer_phone\": \"598-636-6333\",\n" +
                        "            \"producer_phone_ext\": \"\",\n" +
                        "            \"producer_contact_name\": \"\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .when().patch("/companies/57/");
        System.out.println(response.statusCode());
        response.then().log().all();

    }
    @Then("userr validates status code {int}")
    public void userr_validates_status_code(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());

    }
    @When("userr connects to database")
    public void userr_connects_to_database() {


    }
    @Then("userr validates name is updated in Database")
    public void userr_validates_name_is_updated_in_database() {

    }
    @Then("userr validates name is updated in UI")
    public void userr_validates_name_is_updated_in_ui() {

    }

}
