package StepDef;

import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;

public class dp {
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		
		
		Object[][] obj = new Object[3][1];
		obj[0][0] = "shavya";
		obj[1][0] = "jain";
		obj[2][0] = "ok";
		
		return obj;
	}
	
	@org.testng.annotations.Test(dataProvider = "data-provider")
	public void mydp (String a) {
			System.out.println(a);
	}
}
