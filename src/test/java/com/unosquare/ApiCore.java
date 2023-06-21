package com.unosquare;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiCore {
	
		public static String Client = "https://reqres.in/api";
		
		
		public void setClient(String client) {
			this.Client = client;
		}
		
		public static String getClient() {
			return Client;
		}
		
		
	public static Response PostLogin(String pathJSONFile, String EndPoint) throws IOException, org.json.simple.parser.ParseException {
		
		
		  JSONParser json = new JSONParser();
		  FileReader reader;
		  reader = new FileReader(pathJSONFile);
		  Object obj = json.parse(reader);
		
		  RestAssured.baseURI = getClient();
		  RequestSpecification httpRequest = RestAssured.given();
		  httpRequest.headers("Content-Type", "application/json");
		  httpRequest.body(obj.toString());
		  Response statusCode1 = httpRequest.post(EndPoint);

		return statusCode1;
		
	}
	
	public static Response PostLogin(String id, String name, String endPoint) throws IOException, org.json.simple.parser.ParseException{
		
		JSONObject requestParams = new JSONObject();
	
		requestParams.put("id", id);
		requestParams.put("name", name);
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post(endPoint);
		
		return response;
				
	}

	
	public static Response GetUsers(String EndPoint) throws IOException, org.json.simple.parser.ParseException{
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		Response response = httpRequest.get(EndPoint);

		return response;
		
	}
	
	
	public static  Response PutUsers(String pathJSONFile, String EndPoint) throws IOException, org.json.simple.parser.ParseException{
		
		JSONParser json = new JSONParser();
		FileReader reader;
		reader = new FileReader(pathJSONFile);
		Object obj = json.parse(reader);
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		
		//System.out.println("obj: " + obj.toString());
		
		httpRequest.body(obj.toString());
		Response response = httpRequest.put(EndPoint);
		
		return response;
		
	}
		

}
