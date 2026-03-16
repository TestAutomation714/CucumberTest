package com.hooks;

import io.cucumber.java.Before;
import java.io.IOException;
import io.cucumber.java.After;
import com.NewCucum.DriverManager;

public class Hooks {

	 @Before
	    public void setUp() throws IOException, InterruptedException {
	        // Initialize the thread-local driver before each scenario
	        DriverManager.setDriver();
	    }

	    @After
	    public void tearDown() {
	        // Quit the driver and clean up the thread
	        DriverManager.quitDriver();
	    }
}
