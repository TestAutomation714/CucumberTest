#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.

@tag
Feature: Test Table Scenarios

  Background:
  Given User is on login page
  
 @tag143
  Scenario Outline: Title of your scenario new outline
		When user enters username and password <logindata>
		And user check sortby option and list of courses <testcaseData>
		Then verify should ableto navigate advance selenium page <testcaseData>
		
		Examples:
		|logindata        |testcaseData               |
		|LoginData.json   |testcaseData.json_TC002    |

 @tag144
  Scenario Outline: Title of your scenario new outline
		When user enters username and password <logindata>
		And user check sortby option and list of courses <testcaseData>
		
		Examples:
		|logindata        |testcaseData               |
		|LoginData.json   |testcaseData.json_TC002    |



  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
