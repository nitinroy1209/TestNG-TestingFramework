package com.w3schools.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

/*
 * This class will contain all the wrapper methods for built in selenium methods
 */

public class SeWrappers {
	
	public WebDriver driver=null;
	
	//Launch browser for the specified url
	//parameter-> url
	public void launchBrowser(String url)
	{
		try
		{
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(url);
			
		}
		catch(Exception ex)
		{
			//System.out.println("Problem in launching the browser");
			ex.printStackTrace();
		}
	}
	
	//method to close all the browsers
	public void closeAllBrowsers()
	{
		try
		{
			driver.quit();
		}
		catch(Exception ex)
		{
			System.out.println("Problem in closing all the browsers");
			ex.printStackTrace();
		}
	}
	
	//methods to close the current active browser
	public void closeBrowser()
	{
		try
		{
			driver.close();
		}
		catch(Exception ex)
		{
			System.out.println("Problem in closing the browser");
			ex.printStackTrace();
		}
	}
	
	public void typeText(WebElement ele, String text)//it takes two argument webelement whwre i need to type and what text i want to type
	{
		try
		{
			waitForMe(ele,20);
			ele.clear();
			ele.sendKeys(text);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void click(WebElement ele)
	{
		try
		{
			waitForMe(ele,20);
			ele.click();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void waitForMe(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void pollingWait(WebElement ele, int timeout, int pollingFrequency)
	{
		try
		{
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//selectby visibletext
	public void selectByVisibleText(WebElement ele, String visibleText)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByVisibleText(visibleText);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	//SelectbyIndex
	public void selectByIndex(WebElement ele, int value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByIndex(value);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//SelectByValue
	public void selectByValue(WebElement ele, String value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByValue(value);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//acceptAlert
	public void acceptAlert()
	{
		try
		{
			Alert promptAlert= driver.switchTo().alert();
			promptAlert.accept();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//dismissAlert
	public void dismissAlert()
	{
		try
		{
			Alert promptAlert= driver.switchTo().alert();
			promptAlert.dismiss();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//getTxtFromAlert
	public void getTextmethod()
	{
		try
		{
			Alert alert= driver.switchTo().alert();

			String alertText=alert.getText();
			System.out.println(alertText);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//typeTextInAlert
	public void typeTextmethod(String text)
	{
		try
		{
			Alert alert= driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//Frames --only for frame input wont be webelement but for select class we need to pass the driver object,need to create object for alert,select class and action..
	public void frameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//FrameByIndex
	public void frameByIndex(int frame)
	{
		try
		{
			driver.switchTo().frame(frame);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//FrameByIndex
		public void frameByIndex(String nameOrId)
		{
			try
			{
				driver.switchTo().frame(nameOrId);

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	public boolean verifySelected(WebElement ele)
	{
		boolean retVal=false;
		try
		{
			if(ele.isSelected())
			{
				retVal=true;
				System.out.println("Element is selected");
			}
			else
			{
				retVal=false;
				System.out.println("Element is not selected");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return retVal;
	}
		
		//isEnabled
	//isDisplayed
	
	public void actionClick(WebElement ele)
	{
		try
		{
			Actions act = new Actions(driver);
			act.click(ele).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void rightClick(WebElement ele)
	{
		try
		{
			Actions act = new Actions(driver);
			act.contextClick(ele).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void dragAndDrop(WebElement source, WebElement target)
	{
		try
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//clickAndHold
	//docubleClick
	//moveToElement
	//Keyboard actions
	
	public void jsVerticalScroll(int y)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,"+y+";)");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void jsHorizontalScroll(int x)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo("+x+",0);");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	//jsClick
	//jstitle
	//typeTextwithout snedkeys
	//scrollintoview
	
	public void switchWindows()
	{
		try
		{
			String parentWindow= driver.getWindowHandle();
			Set<String> allWindows= driver.getWindowHandles();
			
			for(String eachWindow:allWindows)
			{
				if(! parentWindow.equals(eachWindow))
				{
					driver.switchTo().window(eachWindow);
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//getCurrentUrl
	

}
