package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile{
	
	public String readProperties(String propValue) {

		FileInputStream input;
		Properties prop;
		String valProp = null;
		try {
			input = new FileInputStream("src/test/resources/testdata.properties");
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