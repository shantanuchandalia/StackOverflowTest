package com.stackOverflow.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.stackOverflow.qa.base.TestBase;
import com.stackOverflow.qa.pages.QuestionsPage;
import com.stackOverflow.qa.pages.StackOverflowPage;
import com.stackOverflow.qa.pages.TagsPage;


public class TagsPageTest extends TestBase{

	StackOverflowPage stackoverflowpage;
	QuestionsPage questionsPage;
	TagsPage tagsPage;
	
	HashMap<String, Integer> hmap;
	
	public TagsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		stackoverflowpage = new StackOverflowPage();
		questionsPage = stackoverflowpage.BrowseQuestion();
		tagsPage = questionsPage.navigateToTags();
		tagsPage.tagByName(); //Sorting by Name is a preliminary step here for both the tests
	}
	
	@Test
	public void checkIftagsByNameSuccessful()
	{	
		Assert.assertTrue(tagsPage.checkIftagsByNameSuccessful(), "The tags could not be sorted by Name properly.");
	}
	
	@Test
	public void getTagNameWithMaxQuestions()
	{
		tagsPage.getTagsKeyValue();
		String key = tagsPage.getkeyWithMaxValue();
		Assert.assertEquals(key, ".htaccess" );
		System.out.println("Key with Maximum value : " + tagsPage.getkeyWithMaxValue()) ;
		System.out.println("Maximum value : " +tagsPage.getMaxValue());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
