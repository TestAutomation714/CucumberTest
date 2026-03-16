package com.Utility;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonDataReader {
	public String jsonFileData(String filename, String parameterType )
	{
		String executionEnvType = PropertiesFile.readProperties("executionEnvType").toString();	
		String filenameTCid[]=filename.split("_");
	    ObjectMapper mapper = new ObjectMapper();
	    String projectPath = System.getProperty("user.dir");
	    JsonNode fullData = null;
		try {
			fullData = mapper.readTree(new File(projectPath + "/src/test/resources/"+filenameTCid[0]));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
      System.out.println("1 index::" +filenameTCid[1]);
	    JsonNode tciDData = fullData.get(filenameTCid[1]);
	    String parameterVal = tciDData.get(executionEnvType).get(parameterType).textValue();
	    System.out.println("Data for " + filenameTCid[1]+": " + parameterVal);
		return parameterVal;
	}
	
	
	/* no test case ID required */
	public String jsonLoginData(String filename, String parameterType )
	{
		String executionEnvType = PropertiesFile.readProperties("executionEnvType").toString();	
	    ObjectMapper mapper = new ObjectMapper();
	    String projectPath = System.getProperty("user.dir");
	    JsonNode fullData = null;
		try {
			fullData = mapper.readTree(new File(projectPath + "/src/test/resources/"+filename));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    String parameterVal = fullData.get(executionEnvType).get(parameterType).textValue();
	    System.out.println("Login Data "+ parameterType+":" + parameterVal);
		return parameterVal;
	}


}

