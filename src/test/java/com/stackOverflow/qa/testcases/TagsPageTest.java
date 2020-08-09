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
	
	@Test(description = "Verify if Tag names are sorted when we click on Name filter")
	public void checkIftagsByNameSuccessful()
	{	
		Assert.assertTrue(tagsPage.checkIftagsByNameSuccessful(), "The tags could not be sorted by Name properly.");
	}
	
	@Test(description = "Verify that the tag with Maximum number of questions is <.htaccess> and prints it in the console")
	public void getTagNameWithMaxQuestions()
	{
		tagsPage.getTagsKeyValue();
		String key = tagsPage.getkeyWithMaxValue();
		Assert.assertEquals(key, ".htaccess" );
		System.out.println();
		System.out.println("Key with Maximum value : " + tagsPage.getkeyWithMaxValue()) ;
		System.out.println("Maximum value : " +tagsPage.getMaxValue());
		System.out.println();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
