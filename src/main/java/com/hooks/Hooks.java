package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.NewCucum.DriverManager;
import com.Utility.PropertiesFile;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
public class Hooks {

    @Before
    public void setUp() throws Exception {
        // Read your framework config parameters dynamically
        String executionType = PropertiesFile.readProperties("executionType"); // e.g., local or remote
        String browser = PropertiesFile.readProperties("browsertype");       // e.g., chrome, firefox, edge
        String gridUrl = PropertiesFile.readProperties("gridHubUrl");         // e.g., http://192.168.29.130:4444
        String appUrl = PropertiesFile.readProperties("urlApplication");

        // Initialize the browser driver on the respective isolated thread pipeline
        DriverManager.setDriver(executionType, browser, gridUrl);
        
        // Open the target test webpage environment
        DriverManager.getDriver().get(appUrl);
    }

    @After
    //public void tearDown() {
        public void tearDown(Scenario scenario) {
            if (scenario.isFailed()) {
                try {
                    // Take the screenshot as a byte array
                    byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                    
                    // Attach the screenshot to the Cucumber HTML report
                    scenario.attach(screenshot, "image/png", scenario.getName() + "_Failure");
                } catch (Exception e) {
                    System.err.println("Failed to capture screenshot: " + e.getMessage());
                }
            }
            
            // Tear down the active driver instance securely
            DriverManager.quitDriver();
    }
}
