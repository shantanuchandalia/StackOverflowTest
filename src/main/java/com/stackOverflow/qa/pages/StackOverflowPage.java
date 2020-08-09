package com.stackOverflow.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.stackOverflow.qa.base.TestBase;

public class StackOverflowPage extends TestBase{
	
	Actions action = new Actions(driver);
	WebElement bannerCrossbtn = driver.findElement(By.xpath("//*[@id='js-gdpr-consent-banner']/div/div[2]/a"));
	WebElement page_for_developers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("for-developers")));
	WebElement btn_browseQ = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"for-developers\"]/div[2]/div[1]/a")));
	
	public String validateStackOverFlowTitle()
	{
		return driver.getTitle();
	}
	
	public void dismissBanner()
	{
		bannerCrossbtn.click();
	}
	
	public void navigateToDeveloper()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page_for_developers);
	}
	
	public void navigatoToBrowseQuestion()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", btn_browseQ);
	}
	
	public QuestionsPage BrowseQuestion()
	{
		dismissBanner();
		navigateToDeveloper();
		navigatoToBrowseQuestion();
		action.pause(Duration.ofSeconds(2)).moveToElement(btn_browseQ).click().perform();
		return new QuestionsPage();
	}
			
			
}
