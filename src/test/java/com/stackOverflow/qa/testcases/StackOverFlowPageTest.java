package com.stackOverflow.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stackOverflow.qa.base.TestBase;
import com.stackOverflow.qa.pages.QuestionsPage;
import com.stackOverflow.qa.pages.StackOverflowPage;

public class StackOverFlowPageTest extends TestBase{
	
	StackOverflowPage stackoverflowpage;
	QuestionsPage questionsPage;
	
	public StackOverFlowPageTest() {
		// TODO Auto-generated constructor stub
		//to call the constructor of TestBase Class
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		stackoverflowpage = new StackOverflowPage();
	}
	
	@Test(priority = 1)
	public void StackOverflowPageTitleTest()
	{
		String title = stackoverflowpage.validateStackOverFlowTitle();
		Assert.assertEquals(title, "Stack Overflow - Where Developers Learn, Share, & Build Careers" );
	}
	
	@Test(priority = 2)
	public void CheckNavigationToBrowseQuestion()
	{
		questionsPage = stackoverflowpage.BrowseQuestion();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Newest Questions - Stack Overflow", "Could not navigate to Questions Page");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
