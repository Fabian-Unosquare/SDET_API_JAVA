package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;



public class FirtPostTest {
  @Test
  public void f() {
	  
	  
	  JSONObject requestParams = new JSONObject(); 
	  
	  
	  requestParams.put("name", "JuanAPIs");
	  requestParams.put("Job", "Sir. QA");
	  
	 
	  
	  RestAssured.baseURI = "https://reqres.in/api";
	  RequestSpecification httpRequest = RestAssured.given();
	  httpRequest.headers("Content-Type", "application/json");
	  httpRequest.body(requestParams.toString());
	  Response response = httpRequest.post("/users");
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
