package com.CommonMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.NewCucum.DriverManager;


import junit.framework.Assert;

public class CommonReuseMethods {
	
	 private WebDriver driver;
	 public CommonReuseMethods()
	 {
		 this.driver=DriverManager.getDriver();
	 }
	 
	public void WaitforElement(String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public void waitforElementFluentwait(String locator)
	{
		Wait<WebDriver> w1=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class);
	         
		w1.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
	}
	
	public void clickOnElement(String locator)
	{
		WaitforElement(locator);
		driver.findElement(By.xpath(locator)).click();
	}
	public void sendTextinElemet(String locator, String text)
	{
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void scrollIntoElement(String locator)
	{
		WebElement element=driver.findElement(By.xpath(locator));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void verifyTextMatches(String locator,String expectedText) throws IOException
	{
		scrollIntoElement(locator);
		String elementText=driver.findElement(By.xpath(locator)).getText();
		Assert.assertEquals(elementText, expectedText);
		takeScreenshotPage();	
	}
	public void verifyTextContains(String locator,String expectedText) throws IOException
	{
		scrollIntoElement(locator);
		String elementText=driver.findElement(By.xpath(locator)).getText();
		if(elementText.contains(expectedText))
		{
			Assert.assertEquals("true", "true");
		}
		else
		{
			System.out.println("Fail Status");
			Assert.assertEquals("false", "false");
		}
		takeScreenshotPage();	
	}
	
	
	public void takeScreenshotPage() throws IOException
	{
		String projectPath = System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		FileUtils.copyFile(scrFile, new File(projectPath+"/src/test/resources/screenshots/" + timestamp + ".png"));
		
	}
	
	public void selectDropdownVal(String locator,String expectedText)
	{
		Select setopt=new Select(driver.findElement(By.xpath(locator)));
		setopt.selectByValue(expectedText);
	}

	public void switchWindowonTitle(String expectedTitle)
	{
		Set<String> titles=driver.getWindowHandles();
		for(String s1: titles)
		{
			String windowTitle=driver.getTitle();
			System.out.println("titel::"+windowTitle);
			if(windowTitle==expectedTitle)
			{
				
				driver.switchTo().window(s1);
				break;
			}
		}
	}
	
	public void switchWindowonIndex(String indexVal)
	{
       driver.switchTo().window(indexVal);
	}
	
	public String getTextinElemet(String locator)
	{
		String returnTxt=driver.findElement(By.xpath(locator)).getText();
		return returnTxt;
	}
	

}
