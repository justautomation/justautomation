package restassuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo1_GET_Request {

	@Test
	public void getWeatherDetails() {
		given()
		.when()
			.get("https://userapi-8877aadaae71.herokuapp.com/uap/users")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.header("Content Type","application/json");
			
	}

}
