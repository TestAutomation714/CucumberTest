package com.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.Pages.LoginPage;
import com.Utility.JsonDataReader;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCucumSteps {
	 //WebDriver driver = DriverManager.getDriver();
	LoginPage lp=new LoginPage();
	JsonDataReader fileObj=new JsonDataReader();
	
	    @Given("User is on login page")
	    public void user_is_on_login_page() throws InterruptedException {
	    	
	    	System.out.println("successfully login to application");
	    }

	    @When("^user enters username and password (.*)$")
	    public void user_enters_username(String filename) throws FileNotFoundException, ParseException, InterruptedException{
	        System.out.println("Entered username and pwd");
	        LoginPage.loginApplication(fileObj.jsonLoginData(filename,"username"), fileObj.jsonLoginData(filename,"password"));
	        
	    }

	    @Then("login should be successful")
	    public void login_should_be_successful() throws InterruptedException {
	    	Thread.sleep(9000);
	        System.out.println("Login success");
	    }
	    
	    @And("^user create list of your favorite foods in cart (.*)$")
	    public void user_enters_favoritefoods(String filename) throws ParseException, InterruptedException, IOException{
	        System.out.println("Entered favorite foods");
	        LoginPage.userAddedfavoritefoods(fileObj.jsonFileData(filename,"Row2Val"),fileObj.jsonFileData(filename,"Row2AddedTitle"));
	        
	    }
	    

}
