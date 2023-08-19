package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;

public class W3Wrappers extends SeWrappers {
	SeWrappers se= new SeWrappers();
	
	//This class would contain all the reusable methods for W3Schools application
	
	public void loginW3Schools(String mailid, String pwd)
	{
		try
		{
			LoginPage lpPage= PageFactory.initElements(driver, LoginPage.class);
			HomePage home= PageFactory.initElements(driver, HomePage.class);
			
			lpPage.setEmail(mailid);
			lpPage.setPassword(pwd);
			lpPage.clickLogin();
			
			home.waitForLearning();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
