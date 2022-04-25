package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIDataDriven {
	Response resp;


    @Given("^I Api with url <http://api.zippopotam.us/(.+)/(.+)$")
    public void i_api_with_url_httpapizippopotamus(String country, String postalcode) throws Throwable {
    	RestAssured.baseURI="http://api.zippopotam.us";
		RestAssured.basePath=country+"/"+postalcode;
		resp = given().get();	
    	
    }
    @Then("^I verify resonse code is (.+)$")
    public void i_verify_resonse_code_is(int responsecode) throws Throwable {

    	Assert.assertEquals(resp.statusCode(), responsecode);
    	
		
    }
    @Then("^I verify ContentType is (.+)$")
    public void i_verify_contenttype_is(String contenttype) throws Throwable {
    	Assert.assertEquals(resp.contentType(), contenttype);

    	
    }
  
    @Then("I verify ResponseTime")
    public void i_verify_response_time() {
    	SoftAssert softAssertion= new SoftAssert();
    	softAssertion.assertTrue(resp.time()<1);
    }

    @Then("^I verify the (.+) in step$")
    public void i_verify_the_in_step(String placename) throws Throwable {
    	JsonPath extractor = resp.jsonPath();
		String s=extractor.getString("places[0]['place name']");
		Assert.assertEquals(s, placename);
	
    }


}
