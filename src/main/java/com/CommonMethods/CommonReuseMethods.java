package com.CommonMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NewCucum.DriverManager;

import junit.framework.Assert;

public class CommonReuseMethods {
	
	static WebDriver driver=DriverManager.getDriver();
	public static void WaitforElement(String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public static void clickOnElement(String locator)
	{
		WaitforElement(locator);
		driver.findElement(By.xpath(locator)).click();
	}
	public static void sendTextinElemet(String locator, String text)
	{
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public static void scrollIntoElement(String locator)
	{
		WebElement element=driver.findElement(By.xpath(locator));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public static void verifyTextMatches(String locator,String expectedText) throws IOException
	{
		scrollIntoElement(locator);
		String elementText=driver.findElement(By.xpath(locator)).getText();
		Assert.assertEquals(elementText, expectedText);
		takeScreenshotPage();	
	}
	
	public static void takeScreenshotPage() throws IOException
	{
		String projectPath = System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		FileUtils.copyFile(scrFile, new File(projectPath+"/src/test/resources/screenshots/" + timestamp + ".png"));
		
	}


}
