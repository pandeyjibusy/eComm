package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String monthNumber = "5";
		String day = "25";
		String Year = "2025";
		String[] expexctedList = { monthNumber, day, Year };
		driver.findElement(By.cssSelector(".react-date-picker__wrapper")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='" + Year + "']")).click();
		String cssSelector = "div[class='react-calendar__viewContainer'] button:nth-child(" + monthNumber + ")";
		driver.findElement(By.cssSelector(cssSelector)).click();
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (int i = 0; i < actualList.size(); i++) {

			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expexctedList[i]);
			// System.out.println(expexctedList);
		}
	}

}
