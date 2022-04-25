package stepdefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTescase {
	Response response;

	@Given("^I have url apizippop$")
	public void i_have_url_apizippop() throws Throwable {
		response = given().get("http://api.zippopotam.us/de/bw/stuttgart");
	}

	@Then("^I verify That country is Germany and state is BadenWurttemberg$")
	public void i_verify_that_country_is_germany_and_state_is_badenwurttemberg() throws Throwable {
		JsonPath extractor = response.jsonPath();
		String Country = extractor.getString("country");
		String State = extractor.getString("state");

		Assert.assertEquals(Country, "Germany");
		Assert.assertEquals(State, "Baden-Württemberg");

	}

	@Then("^I Verify Post Code  the place name has Stuttgart Degerloch$")
	public void i_verify_post_code_the_place_name_has_stuttgart_degerloch() throws Throwable {
		JsonPath j = new JsonPath(response.asString());

		// get values of JSON array after getting array size
		int s = j.getInt("places.size()");
		for (int i = 1; i <= s; i++) {

			String state = j.getString("places[" + i + "]['post code']");
			if (state.equalsIgnoreCase("70597")) {
				String postcode = j.getString("places[" + i + "]['place name']");
				Assert.assertEquals(postcode, "Stuttgart Degerloch");
				System.out.println(postcode);
				break;
			}
		}
	}

	

	@Then("^I verify ContentType ContentType as applicationjson$")
	public void i_verify_contenttype_contenttype_as_applicationjson() throws Throwable {
		Assert.assertEquals(response.contentType(),"application/json");
	}



	
	@Then("I verify resonse code")
	public void i_verify_resonse_code() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(),200);
	}

	@Then("I verify ResponseTime in seconds")
	public void i_verify_response_time_in_seconds() {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(response.time() < 1);
	}
}
