package com.unosquare;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.http.ContentType;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

public class PostUsingJSON_2 {

		
		public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
			
			String pathJSON = "C:\\Users\\fabian.sanchez\\eclipse-workspace\\JavaAPI\\test-output\\JsonFiles\\writeJSON.json";
			
			try {
				
				JSONParser json = new JSONParser();
				FileReader reader;
				reader = new FileReader(pathJSON);
				Object obj = json.parse(reader);
				
				//System.out.println(obj.toString());
				
				RestAssured.baseURI = "https://reqres.in/api";
				
				Response response = given()
						  .header("Content-type", "application/json")
						  .and()
						  .body(obj.toString())
						  .when()
						  .post("/users")
						  .then()
						  .extract().response();
				
				System.out.println("Code: " + response.statusCode());
				System.out.println("JSON body: " + obj.toString());
				System.out.println("Response body: " + response.body());
				
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
			
		}
	
	
}
