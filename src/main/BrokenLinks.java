package main;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
	

		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		//broken URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			 a.assertTrue(responseCode<400, "The link with Text"+link.getText()+" is broken with code" +responseCode);
			/**if(responseCode>400) {
				System.out.println("The link which is Broken is " +link.getText()+" with status code of " +responseCode);
				Assert.assertTrue(false);
			}**/
		}
		
		 a.assertAll();
		
		
		
		
		
		
		
		
		
		/**
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responsCode = conn.getResponseCode();
		System.out.println(responsCode);
		**/
		
		
	
		
		
	}
}
