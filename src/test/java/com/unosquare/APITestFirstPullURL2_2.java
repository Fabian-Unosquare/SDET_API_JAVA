package com.unosquare;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.restassured.http.ContentType;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;


public class APITestFirstPullURL2_2 {
  @Test
  public void f() {
	  
	  given()
	  .when()
	  		.get("https://reqres.in/api/unknown/2")
	  		.then()
	  		.assertThat().statusCode(200)
	  		.assertThat().contentType(ContentType.JSON)
	  		.assertThat()
	  		.body("data.id", equalTo(2))
	  		.and().body("data.name", equalTo("fuchsia rose"))
	  		.and().body("data.year", equalTo(2001))
	  		.and().body("data.color", equalTo("#C74375"))
	  		.and().body("data.pantone_value", equalTo("17-2031"))
	  		.and().body("support.url", equalTo("https://reqres.in/#support-heading"))
	  		.and().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	   
	  
	  Reporter.log("Success 200 code validartion");
	  	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
