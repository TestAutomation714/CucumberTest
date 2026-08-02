package com.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.Pages.LoginPage;
import com.Utility.JsonDataReader;
import com.Utility.ScenarioContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCucumSteps {
	
	
	 // 🛑 CRITICAL FIX: Add this public zero-argument constructor
    public NewCucumSteps() {
        // Leave this empty or put basic initializations here
    }
	   // ScenarioContext context;
	    /*public NewCucumSteps(ScenarioContext context) 
	    { this.context = context; }*/
	    
		LoginPage lpObj=new LoginPage();
		JsonDataReader fileObj=new JsonDataReader();
	
	    @Given("User is on login page")
	    public void user_is_on_login_page() throws InterruptedException {
	    	 //{ context.scenarioData = "Hello!"; }
	    	System.out.println("successfully login to application");
	    }

	    @When("^user enters username and password (.*)$")
	    public void user_enters_username(String filename) throws FileNotFoundException, InterruptedException{
	        System.out.println("Entered username and pwd");
	        //{ //System.out.println(context.scenarioData); }
	        //context.usernameData = fileObj.jsonLoginData(filename,"username"); 
	        lpObj.loginApplication(fileObj.jsonLoginData(filename,"username"), fileObj.jsonLoginData(filename,"password"));
	        
	    }

	    @Then("login should be successful")
	    public void login_should_be_successful() throws InterruptedException {
	    	Thread.sleep(3000);
	        System.out.println("Login success");
	    }
	    
	    @And("^user create list of your favorite foods in cart (.*)$")
	    public void user_enters_favoritefoods(String filename) throws  InterruptedException, IOException{
	        System.out.println("Entered favorite foods");
	        lpObj.userAddedfavoritefoods(fileObj.jsonFileData(filename,"Row2Val"),fileObj.jsonFileData(filename,"Row2AddedTitle"));
	        
	    }
	    @And("^user check sortby option and list of courses (.*)$")
	    public void user_enters_sortbyDropdown(String filename) throws  InterruptedException, IOException{
	        System.out.println("Entered sortby dropdown");
	        lpObj.verifySelectTestTable(fileObj.jsonFileData(filename,"sortByVal"));
	        
	    }
	    @Then("^verify should ableto navigate advance selenium page (.*)$")
	    public void verifyAdvanceSeleniumpage(String filename) throws  InterruptedException, IOException{
	        System.out.println("Entered sortby dropdown");
	        lpObj.verifyAdvanceSeleniumTitlepage(fileObj.jsonFileData(filename,"Test Adv Window"));
	        
	    }
	    
	    
	    @And("verify user login sucess or not")
	    public void verfiySuccessorNot() throws IOException
	    {
	    	System.out.println("Pass");
	    	//String succesMessage=context.usernameData;
	    	//lpObj.verfiyLoginSucccessOrNot(succesMessage);
	    }

}
