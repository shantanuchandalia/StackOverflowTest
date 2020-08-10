package com.stackOverflow.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stackOverflow.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;
 
/***
 * 
 * @author Shantanu
 *
 */

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static WebDriverWait wait ;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase()
	{
		try {
			properties = new Properties();
			FileInputStream ip = new  FileInputStream(
					System.getProperty("user.dir")+"/src/main/java/com/stackOverflow/qa/configuration/config.properties");
			properties.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	
	public static void initialization()
	{
		String browserName = properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("google chrome") )
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		} else if(browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		driver.get(properties.getProperty("url"));
	}


	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
