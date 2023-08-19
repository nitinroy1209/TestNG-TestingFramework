package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class HomePage extends SeWrappers {
	
	@FindBy(xpath="//div[text()='My learning']")
	WebElement myLearning;
	
	public void waitForLearning()
	{
		waitForMe(myLearning,20);
	}

}
