package StepDef;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Scenario1 {

	
	Response r;
	String api;
	
	
	@Given("API2 for foreign exchange")
	public void api2_for_foreign_exchange() {
	    // Write code here that turns the phrase above into concrete actions
		 api ="http://api.exchangeratesapi.io/v1/latest?access_key=e625e47e738cc9f492228d55e6b5f5c9";
			
	}

	@When("Posted with correct info")
	public void posted_with_correct_info() {
	    // Write code here that turns the phrase above into concrete actions
		r =  RestAssured.given().when().log().all().get(api).then().log().all().extract().response();
				
	}		
		@Then("Validate positive response code recieved")
		public void validate_positive_response_code_recieved() {
		    // Write code here that turns the phrase above into concrete actions
			JsonPath j = r.jsonPath();
			int statusCode = r.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			
			r.getStatusLine();
			String a="HTTP/1.1 200 OK";
			String statusLine = r.getStatusLine();
			Assert.assertEquals(statusLine, a);
			 System.out.println(r.getStatusLine());
			
				
		    
		}


	}
