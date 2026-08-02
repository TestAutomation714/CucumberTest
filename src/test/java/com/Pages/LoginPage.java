package com.Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.CommonMethods.CommonReuseMethods;
import com.Utility.CommonValues;


public class LoginPage extends CommonReuseMethods {
	
	CommonReuseMethods reuseObj=new CommonReuseMethods();
	
	public static String username="//input[@name='username']";
	public static String password="//input[@name='password']";
	public static String submitBtn="//button[text()='Submit']";
	
	public static String practiceLink="//a[text()='Practice']";
	public static String testExceptLink="//a[text()='Test Exceptions']";
	public static String addBtn="//button[text()='Add']";
	public static String row2editinput="//label[text()='Row 2']//following::input[@class='input-field']";
	public static String saveBtn="//label[text()='Row 2']//following::button[@id='save_btn']";
	public static String row2savedTitle="//*[text()='Row 2 was saved']";
	
	public static String testTableLinke="//a[text()='Test Table']";
	public static String sortbySelect="//select[@id='sortBy']";
	public static String sortbyOptionOne="(//a[text()='View'])[1]";
	public static String advSelenimTitle="(//div[text()='Advanced Selenium WebDriver with Java and TestNG'])[1]";
	
	public static String successMesg="//strong[contains(text(),'Congratulations ')]";
	public static String usenameValue="(//*[contains(text(),'Use next credentials to execute Login')]//b)[1]";
			
	//CommonValues obj1=new CommonValues();
	

	public void loginApplication(String usernametxt, String passwordtxt) throws FileNotFoundException, InterruptedException
	  {
		CommonValues.usernameVal=reuseObj.getTextinElemet(usenameValue);
		reuseObj.WaitforElement(username);
		reuseObj.sendTextinElemet(username,usernametxt);
		reuseObj.sendTextinElemet(password,passwordtxt);
		reuseObj.scrollIntoElement(submitBtn);
		Thread.sleep(4000);
		reuseObj.clickOnElement(submitBtn);
	}
	
	public void userAddedfavoritefoods(String fooditemname, String expectedName) throws InterruptedException, IOException
	{
		reuseObj.clickOnElement(practiceLink);
		reuseObj.clickOnElement(testExceptLink);
		reuseObj.clickOnElement(addBtn);
		reuseObj.sendTextinElemet(row2editinput,fooditemname);
		reuseObj.sendTextinElemet(row2editinput,fooditemname);
		reuseObj.clickOnElement(saveBtn);
		reuseObj.verifyTextMatches(row2savedTitle,expectedName);
		
	}
	
	public void verifySelectTestTable(String sortbyOption) throws InterruptedException
	{
		Thread.sleep(14000);
		reuseObj.clickOnElement(practiceLink);
		reuseObj.clickOnElement(testTableLinke);
		reuseObj.selectDropdownVal(sortbySelect, sortbyOption);
	}
	public void verifyAdvanceSeleniumTitlepage(String windowTitle) throws IOException
	{
		reuseObj.clickOnElement(sortbyOptionOne);
		reuseObj.switchWindowonIndex("1");
		//reuseObj.switchWindowonTitle(windowTitle);
		reuseObj.verifyTextMatches(advSelenimTitle,"Advanced Selenium WebDriver with Java and TestNG");
	}
	
	public void verfiyLoginSucccessOrNot(String SucccMsg) throws IOException
	{
		reuseObj.verifyTextContains(successMesg,CommonValues.usernameVal); //"Congratulations student. You successfully logged in!"
		
	
		
	}
	
	
}
