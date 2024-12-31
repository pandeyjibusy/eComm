package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions Act = new Actions(driver);
		/**driver.get("https://the-internet.herokuapp.com/hovers");
		Thread.sleep(5);
		
		//hover
		Act.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[1]"))).build().perform();
		driver.quit();**/
		//capital Letters
		driver.get("https://www.amazon.in");
		Thread.sleep(5);	
		Act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//Right Click
		Act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();		
	}

}
