package com.unosquare;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

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

public class APIFirstPullURL2_1Test {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://reqres.in/api/";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("unknown/2");
	  
	  int statusCode = response.getStatusCode();
	  
	  //Assert that correct status code is returned.
	  Assert.assertEquals(statusCode, 200);
	  Reporter.log("Success 200 code validation");
	  
	  response.then().body("data.id", equalTo(2));
	  response.then().body("data.name", equalTo("fuchsia rose"));
	  response.then().body("data.year", equalTo(2001));
	  response.then().body("data.color", equalTo("#C74375"));
	  response.then().body("data.pantone_value", equalTo("17-2031"));
	  
	  response.then().body("support.url", equalTo("https://reqres.in/#support-heading"));
	  response.then().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  
	  Reporter.log(response.body().asPrettyString());
	  	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
