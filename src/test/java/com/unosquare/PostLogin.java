package com.unosquare;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.core.IsEqual.equalTo;

import java.io.IOException;

import org.json.simple.JSONObject;
import com.unosquare.*;


public class PostLogin extends ApiCore {

	ApiCore apicore = null;
	public String endPoint = "/users/";
	public String pathJSON = "C:\\Users\\fabian.sanchez\\eclipse-workspace\\JavaAPI\\test-output\\JsonFiles\\";
	
	
  @Test
  public void testPost1() throws IOException, org.json.simple.parser.ParseException {
	  	 
	Response test = apicore.PostLogin(pathJSON + "RegisterPost.json", endPoint);	  
	Assert.assertEquals(201, test.statusCode());
	    
  }
  
  
  @Test
  public void testPost2() throws IOException, org.json.simple.parser.ParseException{
	  	  
	  Response testPost2 = apicore.PostLogin(pathJSON + "RegisterPost_1.json" , endPoint);  
	  Assert.assertEquals(201, testPost2.statusCode());
	  	  
  }
  
  
  @Test
  public void testPost3() throws IOException, org.json.simple.parser.ParseException{
	  
	  String id = "10";
	  String name = "Pedro Perez";
	
	  
	  Response testPost3 = apicore.PostLogin(id, name, endPoint);	  
	  Assert.assertEquals(201, testPost3.getStatusCode());	  
	  System.out.println(testPost3.getBody().asString());
	  
  
  }
  
  
  @Test
  public void testPost4() throws IOException, org.json.simple.parser.ParseException{
	  
	  String id = "11";
	  String name = "Juan Fernandez Perez";
	  
	  Response testPost3 = apicore.PostLogin(id, name, endPoint);
	  
	  Assert.assertEquals(201, testPost3.getStatusCode());
	  System.out.println(testPost3.getBody().asString());
	  
  
  }
  
  @Test
  public void testGet1() throws IOException, org.json.simple.parser.ParseException {

	  Response testGet1 = apicore.GetUsers(endPoint + "1");
	  Assert.assertEquals(200, testGet1.getStatusCode());
	  
	  testGet1.then().body("data.id", equalTo(1));
	  testGet1.then().body("data.email", equalTo("george.bluth@reqres.in"));
	  testGet1.then().body("data.first_name", equalTo("George"));
	  
  }
  
  
  @Test
  public void testGet2() throws IOException, org.json.simple.parser.ParseException{
	  	  
	  
	  Response testGet2 = apicore.GetUsers(endPoint + 2);
	  Assert.assertEquals(200, testGet2.getStatusCode());
	  
	  testGet2.then().body("data.id", equalTo(2));
	  testGet2.then().body("data.email", equalTo("janet.weaver@reqres.in"));
	  testGet2.then().body("data.first_name", equalTo("Janet"));
	  	  
  }
  
  
  @Test
  public void testGet3() throws IOException, org.json.simple.parser.ParseException{
	  
	  Response testGet3 = apicore.GetUsers(endPoint +"3");
	  Assert.assertEquals(200, testGet3.getStatusCode());
	  
	  testGet3.then().body("data.id", equalTo(3));
	  testGet3.then().body("data.email", equalTo("emma.wong@reqres.in"));
	  testGet3.then().body("data.first_name", equalTo("Emma"));
	 
  }
  
  
  @Test
  public void testGet4() throws IOException, org.json.simple.parser.ParseException{
	  

	  Response testGet4 = apicore.GetUsers(endPoint + "4");
	  Assert.assertEquals(200, testGet4.getStatusCode());
	  
	  testGet4.then().body("data.id", equalTo(4));
	  testGet4.then().body("data.email", equalTo("eve.holt@reqres.in"));
	  testGet4.then().body("data.first_name", equalTo("Eve"));
	 
  }
  
  
  @Test
  public void testPut() throws IOException, org.json.simple.parser.ParseException {
	  	  
	  Response testPut = apicore.PutUsers(pathJSON + "RegisterPut.json", endPoint);
	  
	  Assert.assertEquals(200, testPut.getStatusCode());
	  System.out.println(testPut.getBody().asString());	  
	  
  }
  

  @BeforeTest
  public static void beforeSuite() {
	  
	  ApiCore apicore = new ApiCore();
  
  }
  

}
