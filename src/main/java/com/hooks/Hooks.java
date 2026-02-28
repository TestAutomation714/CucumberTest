package com.hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;

import com.NewCucum.DriverManager;

public class Hooks {

	 @Before
	    public void setUp() {
	        // Initialize the thread-local driver before each scenario
	        DriverManager.setDriver("chrome","");
	    }

	    @After
	    public void tearDown() {
	        // Quit the driver and clean up the thread
	        DriverManager.quitDriver();
	    }
}
