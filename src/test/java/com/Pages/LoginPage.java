package com.Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import com.CommonMethods.CommonReuseMethods;

public class LoginPage extends CommonReuseMethods {
	
	public static String username="//input[@name='username']";
	public static String password="//input[@name='password']";
	public static String submitBtn="//button[text()='Submit']";
	
	public static String practiceLink="//a[text()='Practice']";
	public static String testExceptLink="//a[text()='Test Exceptions']";
	public static String addBtn="//button[text()='Add']";
	public static String row2editinput="//label[text()='Row 2']//following::input[@class='input-field']";
	public static String saveBtn="//label[text()='Row 2']//following::button[@id='save_btn']";
	public static String row2savedTitle="//*[text()='Row 2 was saved']";
	
	

	public static void loginApplication(String usernametxt, String passwordtxt) throws FileNotFoundException, ParseException, InterruptedException
	  {
		CommonReuseMethods.WaitforElement(username);
		CommonReuseMethods.sendTextinElemet(username,usernametxt);
		CommonReuseMethods.sendTextinElemet(password,passwordtxt);
		CommonReuseMethods.scrollIntoElement(submitBtn);
		Thread.sleep(4000);
		CommonReuseMethods.clickOnElement(submitBtn);
	}
	
	public static void userAddedfavoritefoods(String fooditemname, String expectedName) throws InterruptedException, IOException
	{
		CommonReuseMethods.clickOnElement(practiceLink);
		CommonReuseMethods.clickOnElement(testExceptLink);
		CommonReuseMethods.clickOnElement(addBtn);
		CommonReuseMethods.sendTextinElemet(row2editinput,fooditemname);
		CommonReuseMethods.clickOnElement(saveBtn);
		CommonReuseMethods.verifyTextMatches(row2savedTitle,expectedName);
		
	}
	
	
}
