package com.StepDef;

import com.NewCucum.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCucumSteps {
	 //WebDriver driver = DriverManager.getDriver();

	    @Given("User is on login page")
	    public void user_is_on_login_page() throws InterruptedException {
	    	System.out.println("hello world");
	    	DriverManager.getDriver().manage().window().maximize();
	    	Thread.sleep(3000);
	    	DriverManager.getDriver().get("https://www.espncricinfo.com/live-cricket-score"); 
	    	
	    }

	    @When("user enters username")
	    public void user_enters_username() {
	        System.out.println("Entered username");
	    }

	    @Then("login should be successful")
	    public void login_should_be_successful() throws InterruptedException {
	    	Thread.sleep(3000);
	        System.out.println("Login success");
	    }

}
