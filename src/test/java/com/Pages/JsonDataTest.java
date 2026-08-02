package com.Pages;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
	import java.io.IOException;

	public class JsonDataTest {
	   public static JsonObject main(String[] args) throws IOException {

	      //object of JSONParser
	      //JSONParser j = new JSONParser();

	      // load json file to be read
	     // FileReader f = new FileReader("C:\\Users\\PC\\Automation_workspace\\CucumberProject\\CucumberTest\\src\\test\\resources\\testdata.json");

	      JsonObject root = JsonParser.parseReader(new FileReader("C:\\Users\\PC\\Automation_workspace\\CucumberProject\\CucumberTest\\src\\test\\resources\\testdata.json")).getAsJsonObject();
	      String user = root.getAsJsonObject("QA")
	                        .get("username").getAsString();
	      System.out.println(root);
	      return root;
	      
	      
	      // parse json content
	     /* Object o = j.parse(f);

	      // convert parsing object to JSON object
	      JSONObject detail = (JSONObject)o;

	      // get values from JSON file
	      String name = (String)detail.get("name");
	      String email = (String)detail.get("email");
	      System.out.println("First Name: " + name);
	      System.out.println("Email: " + email);
	      String emailqa = (String)detail.get("QA.username");

	      // get values from JSON array
	      JSONArray h = (JSONArray)detail.get("QA");

	      // iterate through the JSONArray
	      for(int i = 0; i < h.size(); i ++){
	         JSONObject home = (JSONObject) h.get(i);
	         String username = (String)home.get("username");
	         String password = (String)home.get("password");
	         System.out.println("username: " + username);
	         System.out.println("password: " + password);
	      }*/
	      
	   }
	}