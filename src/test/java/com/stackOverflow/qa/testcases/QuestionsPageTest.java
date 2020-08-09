package com.stackOverflow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stackOverflow.qa.base.TestBase;
import com.stackOverflow.qa.pages.QuestionsPage;
import com.stackOverflow.qa.pages.StackOverflowPage;
import com.stackOverflow.qa.pages.TagsPage;

public class QuestionsPageTest extends TestBase{

	StackOverflowPage stackoverflowpage;
	QuestionsPage questionsPage;
	TagsPage tagsPage;
	
	public QuestionsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		stackoverflowpage = new StackOverflowPage();
		questionsPage = stackoverflowpage.BrowseQuestion();
	}
	
	
	@Test(description = "Verify navigation to Tags Page")
	public void checkNavigationToTags()
	{
		tagsPage = questionsPage.navigateToTags();
		Assert.assertEquals(driver.getTitle(), "Tags - Stack Overflow", "Could not Navigate to Tags page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
