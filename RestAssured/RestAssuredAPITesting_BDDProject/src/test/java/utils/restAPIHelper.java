package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class restAPIHelper {
	
	public final static String BASE_URL = "https://userapi-8877aadaae71.herokuapp.com/uap";
	public final static String BASE_PATH = "./src/test/resources/";
	public final static String JSON_TEST_DATA = BASE_PATH + "testdatajson.java";
	public static RequestSpecification getBasicAuth() {
		return RestAssured.given().auth().basic("Numpy@gmail.com", "userAPI");
	}
	
	public static RequestSpecification getBasicUnAuth() {
		return RestAssured.given().auth().basic("Numpy123@gmail.com", "userAPI123");
	}

	public static String getBASE_URL() {
		return BASE_URL;
	}
}
