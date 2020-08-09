package com.stackOverflow.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.stackOverflow.qa.base.TestBase;

public class QuestionsPage extends TestBase {
	
	WebElement btn_tag = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-tags")));
	
	public TagsPage navigateToTags()
	{
		btn_tag.click();
		return new TagsPage();
	}
}
