package com.unosquare;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class WriteJSON {

	
	public static void main(String[] args) {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "unosquare.com");
		obj.put("age", 333);
		
		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		
		obj.put("Messages"	, list);
		
		try{
			FileWriter file = new FileWriter("C:\\Users\\fabian.sanchez\\eclipse-workspace\\JavaAPI\\test-output\\JsonFiles\\writeJSON.json");
			file.write(obj.toJSONString());
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print(obj);
		
		
		
	}
	
	
}
