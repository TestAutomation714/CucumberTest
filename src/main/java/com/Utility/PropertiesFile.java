package com.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile{
	
	public static  String readProperties(String propValue) {

		FileInputStream input;
		Properties prop;
		String valProp = null;
		try {
			
			String projectPath = System.getProperty("user.dir");
            input = new FileInputStream(projectPath + "/src/test/resources/config.properties");
			//input = new FileInputStream("src/test/resources/testdata.properties");
			prop = new Properties();
			prop.load(input);
			valProp = prop.getProperty(propValue).toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valProp;

	}
   
}