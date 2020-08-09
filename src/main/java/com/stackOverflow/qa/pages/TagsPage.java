package com.stackOverflow.qa.pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.stackOverflow.qa.base.TestBase;

public class TagsPage extends TestBase{

	WebElement tagOrderedByName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-value='name']")));
	List <WebElement> tag_name_list;
	HashMap<String, Integer> hmap;
	WebElement firstTagName;
	WebElement LastTagName;
	
	static String KeyWithMaxValue;
	static int maxValue;
	
	public void tagByName()
	{
		tagOrderedByName.click();
	}
	
	public boolean checkIftagsByNameSuccessful()
	{
		firstTagName = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@id='tags-browser']//div[1]//div[1]//div[1]")));
		LastTagName = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@id='tags-browser']//div[36]//div[1]//div[1]")));
		boolean success = !(firstTagName.getText().trim().charAt(1) > LastTagName.getText().trim().charAt(1));
		return success;
	}
	
	public void getTagsKeyValue()
	{
		tag_name_list = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//div[@id='tags-browser']//div[@class='s-card js-tag-cell grid fd-column']")));	
		hmap = new HashMap<String, Integer>();
		for(WebElement w : tag_name_list)
		{
			WebElement TagNameElement = w.findElement(
					By.xpath(".//div[1]/div[1]"));
			WebElement TagNameCount = w.findElement(
					By.xpath(".//div[@class='mt-auto grid jc-space-between fs-caption fc-black-300']//div[contains(text(),'question')]"));
			hmap.put(TagNameElement.getText(), Integer.parseInt(TagNameCount.getText().trim().replaceAll("[^0-9]", "")));
		}
		maxValue = Collections.max(hmap.values());
		KeyWithMaxValue = Collections.max(hmap.entrySet(), Map.Entry.comparingByValue()).getKey().toString();
	}
	
	public int getMaxValue()
	{
		return maxValue;
	}
	
	public String getkeyWithMaxValue()
	{
		return KeyWithMaxValue;
	}
	
	
}