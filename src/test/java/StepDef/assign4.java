package StepDef;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class assign4 {
	
	Response r;
	String api;
	
	@Given("I am providing base api")
	public void i_am_providing_base_api() {
	    api ="http://api.exchangeratesapi.io/v1/latest?access_key=e625e47e738cc9f492228d55e6b5f5c9";
	}

	@When("I try to hit the request")
	public void i_try_to_hit_the_request() {
		 r =  RestAssured.get(api).then().log().all().extract().response(); 
		// r = RestAssured.get().then().log().all().extract().response();
	}
	  
	

	@Then("I validate the outcomes for status code and json body")
	public void i_validate_the_outcomes_for_status_code_and_json_body() {
		
		JsonPath j = r.jsonPath();
		String base = j.get("base");
		Assert.assertEquals(base, "EUR");
		
		System.out.println(j.get("rates.AED"));
		Integer rates = j.getInt("rates");
		Assert.assertEquals(rates,  "AED");
		
	   int statusCode = r.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		System.out.println(r.getHeaders());
}}
