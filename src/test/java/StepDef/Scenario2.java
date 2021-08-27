package StepDef;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Scenario2 {

	Response r;
	String api;

	@Given("API3 for foreign exchange")
	public void api3_for_foreign_exchange() {
		api ="http://api.exchangeratesapi.io/v1/lates?access_key=e625e47e738cc9f492228d55e6b5f5c9";
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("Posted with incorrect info")
		public void posted_with_incorrect_info() {
			r =  RestAssured.given().when().log().all().get(api).then().extract().response();
			
		}
	@Then("Validate positive response code recieved in request")
	public void validate_positive_response_code_recieved_in_request() { // Write code here that turns the phrase above into concrete actions
		JsonPath jp = r.jsonPath();
		String s = jp.get("error.code");
		Assert.assertEquals(s, "invalid_date");
		Assert.assertEquals(r.getStatusCode(),400);
	    
	}
}
