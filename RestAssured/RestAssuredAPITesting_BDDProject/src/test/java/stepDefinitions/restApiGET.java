package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.restAPIHelper;

public class restApiGET {

	private Response response;
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^Unauthorized user makes GET request to ([^\"]*)$")
	public void makeGetCallToUrl(String string) throws URISyntaxException {
		RestAssured.baseURI = restAPIHelper.getBASE_URL();
		RequestSpecification requestSpecification = RestAssured.given();
		response = requestSpecification.spec(restAPIHelper.getBasicUnAuth()).contentType(ContentType.JSON).when().get(new URI(string));
	}

	@Given("^User makes GET request to ([^\"]*)$")
	public void getCallToUrl(String string) throws URISyntaxException {
		RestAssured.baseURI = restAPIHelper.getBASE_URL();
		RequestSpecification requestSpecification = RestAssured.given();
		response = requestSpecification.spec(restAPIHelper.getBasicAuth()).contentType(ContentType.JSON).when()
				.get(new URI(string));
	}

	@Then("Response is (\\d+)$")
	public void reponseIsStatusCode(int statusCode) {
		int actualReponseCode = response.then().extract().statusCode();
		Assert.assertEquals(statusCode, actualReponseCode);
	}
	
	@DataProvider(name="getTestData")
	public Object[] getTestDataUsingJson(){
		Object[] objArray = null;
		try {
			String jsonTestData = FileUtils.readFileToString(new File(restAPIHelper.JSON_TEST_DATA),"UTF-8");
			JSONArray jsonArray = JsonPath.read(jsonTestData, "$");
			
			objArray = new Object[jsonArray.length()];
			
			for(int i=0;i<objArray.length; i++) {
				objArray[i] = jsonArray.get(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objArray;
	}

}
