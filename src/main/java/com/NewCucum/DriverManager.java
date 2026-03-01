package com.NewCucum;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	 private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	 
	 
	 public static void setDriver(String browser, String executionType) {
		    WebDriver driver;
		    if (executionType.equalsIgnoreCase("remote")) {
		        try {
		        	
		        	  String huburl ="http://192.168.29.130:4444/wd/hub";
		            // URL of your Selenium Grid Hub
		            URL hubUrl = new URL(huburl); 
		          
		            if (browser.equalsIgnoreCase("chrome")) {
		                ChromeOptions options = new ChromeOptions();
		                options.addArguments("--remote-allow-origins=*");
		                driver = new RemoteWebDriver(hubUrl, options);
		            } else {
		                FirefoxOptions options = new FirefoxOptions();
		                driver = new RemoteWebDriver(hubUrl, options);
		            }
		        } catch (MalformedURLException e) {
		            throw new RuntimeException("Grid Hub URL is invalid", e);
		        }
		    } else {
		       ChromeOptions options = new ChromeOptions();
		    			options.addArguments("--headless=new");
		    			options.addArguments("--no-sandbox"); 
		    			options.addArguments("--disable-dev-shm-usage");
		    			//options.addArguments("--window-size=1920,1080");
		        // Your existing local setup
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver(options);
		    }
		    
		    driver.manage().window().maximize();
		    tlDriver.set(driver);
		}

	    /*public static void setDriver1(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            tlDriver.set(new ChromeDriver());
	        }
	        // Add other browsers as needed
	    }*/

	    public static WebDriver getDriver() {
	        return tlDriver.get();
	    }

	    public static void quitDriver() {
	        if (tlDriver.get() != null) {
	            tlDriver.get().quit();
	            tlDriver.remove(); // Crucial to prevent memory leaks
	        }
	    }
}
