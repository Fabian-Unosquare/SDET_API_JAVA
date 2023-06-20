package com.unosquare;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


public class ReadJSON {

	
	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		
		try (Reader reader = new FileReader("C:\\\\Users\\\\fabian.sanchez\\\\eclipse-workspace\\\\JavaAPI\\\\test-output\\\\JsonFiles\\\\writeJSON.json")){
			
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			System.out.println(jsonObject);
			
			String name = (String) jsonObject.get("name");
			System.out.println(name);
			
			long age = (Long) jsonObject.get("age");
			System.out.println(age);
			
			JSONArray msgs = (JSONArray) jsonObject.get("Messages");
			Iterator<String> iterator = msgs.iterator();
			
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
