package main;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Windowhandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowid = driver.getWindowHandles();	
		Iterator<String> it = windowid.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		String emailIdFulltext = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(emailIdFulltext);
		String[] emailidList = emailIdFulltext.split("at ");
		String[] emailIdfirstPart = emailidList[1].split(" with");
		String emailId = emailIdfirstPart[0];
		System.out.println(emailId);
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailId);
	}

}
