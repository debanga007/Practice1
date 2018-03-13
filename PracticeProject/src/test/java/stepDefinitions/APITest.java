package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class APITest 
{
	String token ="";
	Response tcm_response;
	String responsebody="";
	
	@Given("^I hit token request$")
	public void i_hit_token_request() throws Throwable {
		//RestAssured.baseURI="https://cb.test.dev.telstra.com/org006/qa/v1/oauth/token";
		String body="client_id=4ooDWao0raAoLnfC10ON3RAdD5wyIjOz&client_secret=2yW2V7byaft2XJZ6&grant_type=client_credentials&scope=TCMCUSTOMER";
		RequestSpecification request= RestAssured.given();
		request.header("Content-Type", "application/x-www-form-urlencoded");
	    request.body(body);
	    Response response=request.post("https://cb.test.dev.telstra.com/org006/qa/v1/oauth/token");
	    int code=response.getStatusCode();
	    Assert.assertEquals(code, 200,"test pass");
	    token = response.getBody().jsonPath().get("access_token");
	    System.out.println("Token==> "+token);
	    
	}

	@When("^I trigger GET API Call for customerid \"([^\"]*)\"$")
	public void i_trigger_API_Call(String arg1) throws Throwable {
		RestAssured.baseURI="https://cb.test.dev.telstra.com/org006/qa/v2/customer-self-management/tcm/customer-accounts/";
		//String tcm_customer_url="https://cb.test.dev.telstra.com/org006/qa/v2/customer-self-management/tcm/customer-accounts/";
		RequestSpecification request= RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization","Bearer "+token);
		tcm_response =request.request(Method.GET,arg1+"?limit=50&offset=0");
		
	}

	@Then("^I should get status \"([^\"]*)\" OK$")
	public void i_should_get_status_OK(String statuscode) throws Throwable {
		
	   Assert.assertEquals(String.valueOf(tcm_response.getStatusCode()), statuscode);
	}

	@Then("^I should get response as per design$")
	public void i_should_get_response_as_per_design() throws Throwable {
	  System.out.println("Response body==> "+tcm_response.getBody().asString());  
	  
	  JsonPath jsonPathEvaluator= tcm_response.body().jsonPath();
	  System.out.println(jsonPathEvaluator.getString("data"));
	  System.out.println(jsonPathEvaluator.getString("paymentType"));
	  //System.out.println(jsonPathEvaluator.getJsonObject("data/customers").toString());
	  //System.out.println(jsonPathEvaluator.getString("data/customers/concession/paymentType"));
	  //System.out.println(jsonPathEvaluator.getString("data/customers/customerAccount/lastName"));
	  //System.out.println(jsonPathEvaluator.getString("/data/customers/customerAccount"));
	  
	}

}
