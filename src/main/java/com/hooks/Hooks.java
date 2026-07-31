package com.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;

import com.CommonMethods.CommonReuseMethods;
import com.NewCucum.DriverManager;

public class Hooks {

	CommonReuseMethods obj=new CommonReuseMethods();
	
	 @Before
	    public void setUp() throws IOException, InterruptedException {
	        // Initialize the thread-local driver before each scenario
	        DriverManager.setDriver();
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	    	 
	        //validate if scenario has failed
	        if(scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	        }   
	         
	        DriverManager.quitDriver();
	    }
}
