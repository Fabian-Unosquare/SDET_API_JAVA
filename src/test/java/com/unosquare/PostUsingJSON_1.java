package com.unosquare;

import java.io.FileNotFoundException;
import java.text.ParseException;


import groovy.json.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import groovy.json.JsonParser;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

import org.json.simple.JSONObject;


public class PostUsingJSON_1 {
	
	public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
		
		String pathJSON = "C:\\Users\\fabian.sanchez\\eclipse-workspace\\JavaAPI\\test-output\\JsonFiles\\writeJSON.json";
		
		try {
			
			JSONParser json = new JSONParser();
			FileReader reader;
			reader = new FileReader(pathJSON);
			Object obj = json.parse(reader);
			
			//System.out.println(obj.toString());
			
			RestAssured.baseURI = "https://reqres.in/api";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.headers("Content-Type", "application/json");
			httpRequest.body(obj.toString());
			Response response = httpRequest.post("/users");
			
			
			System.out.println("JSON body: " + obj.toString());
			System.out.println("Response body: " + response.body());
			System.out.println("Code: " + response.getStatusCode());
						
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		
	}
	
}
