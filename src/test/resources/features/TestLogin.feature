#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.


Feature: Title of your feature
  #I want to use this template for my feature file

  Background:
  Given User is on login page
  
 @tag3
  Scenario Outline: Title of your scenario new outline
		When user enters username and password <logindata>
		And verify user login sucess or not
		And user create list of your favorite foods in cart <testcaseData>
		Then login should be successful
		
		Examples:
		|logindata        |testcaseData                |
		|LoginData.json   |testcaseData.json_TC001     |
		
 @tag4
  Scenario Outline: verify user successfully login application
		When user enters username and password <logindata>
		And verify user login sucess or not
		
		Examples:
		|logindata        |testcaseData                |
		|LoginData.json   |testcaseData.json_TC001     |		
			
		
		
		