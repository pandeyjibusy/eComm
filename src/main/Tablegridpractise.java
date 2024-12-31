package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Tablegridpractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=1000");
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum = 0;
		for(int i= 0 ;i<values.size();i++) {
		sum =sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Number of rows : "+values.size());
		List<WebElement> col = driver.findElements(By.cssSelector(".table-display th"));
		System.out.println("Number of Columns : "+col.size());
		List<WebElement> secondowitems = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
		for(int j = 0 ;j<secondowitems.size() ;j++) {
			
		System.out.println(secondowitems.get(j).getText());
		}
		
		//int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()) ;
		//Assert.assertEquals(sum, total);
	}

}
