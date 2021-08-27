package StepDef;

import org.json.JSONObject;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DataProvider {
	
	@org.testng.annotations.DataProvider (name = "DataForPost")

	public Object[][] dataForPost() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data[0][2] =2;
		
		data[0][0] = "Thomas";
		data[0][1] = "Edison";
		data[0][2] =1;
		
		return data;
	}
	
	@Test(dataProvider = "DataForPost")
	public void test_1_post(String firstName, String lastName, int subjectId) {
		
	System.out.println(firstName);
	JSONObject request = new JSONObject();
	
	request.put("firstName",firstName);
	request.put("lastName",lastName);
    request.put("subjectId",subjectId);
 	System.out.println(request);
		
		
	RestAssured.given().headers("content-type", "application/json").body(request.toString()).when().post("http://api.exchangeratesapi.io/v1/latest?access_key=e625e47e738cc9f492228d55e6b5f5c9"
).then().statusCode(201).log().all();
		
	}
}