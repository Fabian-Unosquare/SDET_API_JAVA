package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.core.IsEqual.*;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
 

public class FirstAPITest {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://reqres.in/api/";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/users/2");
	  
	  int statusCode = response.getStatusCode();
	  
	  
	  // Assert that correct status code is returned. 
	  Assert.assertEquals(statusCode, 200);
	  Reporter.log("Success 200 code validation");
	  

	  response.then().body("data.first_name", equalTo("Janet"));
	  Reporter.log(response.body().asString());
	  
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  Reporter.log("Before actions...");
	  
  }
  

}
