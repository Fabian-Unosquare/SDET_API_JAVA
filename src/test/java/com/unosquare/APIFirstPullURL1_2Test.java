package com.unosquare;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.restassured.http.ContentType;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

public class APIFirstPullURL1_2Test {
  @Test
  public void f() {
	  
	  given()
	  .when()
	  		.get("https://reqres.in/api/users/2")
	  			.then()
	  			.assertThat().statusCode(200)
	  			.assertThat().contentType(ContentType.JSON)
	  			.assertThat()
	  			.body("data.id", equalTo(2))
	  			.and().body("data.email", equalTo("janet.weaver@reqres.in"))
	  			.and().body("data.first_name", equalTo("Janet"))
	  			.and().body("data.last_name", equalTo("Weaver"))
	  			.and().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
	  			.and().body("support.url", equalTo("https://reqres.in/#support-heading"))
	  			.and().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  
	  
	  Reporter.log("Success 200 code validation");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
