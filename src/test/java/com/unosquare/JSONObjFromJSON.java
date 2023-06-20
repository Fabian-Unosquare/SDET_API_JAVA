package com.unosquare;

import groovy.json.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class JSONObjFromJSON {
	
	public static void main(String[] args) throws IOException {
		
		String pathJSON = "C:\\Users\\fabian.sanchez\\eclipse-workspace\\JavaAPI\\test-output\\JsonFiles\\writeJSON.json";
		
		try {
			
			JSONParser json = new JSONParser();
			FileReader reader;
			reader = new FileReader(pathJSON);
			Object obj = json.parse(reader);
			
			System.out.println(obj);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
	
	}
	
	

}
