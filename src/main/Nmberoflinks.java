package main;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Nmberoflinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println("Number of links in footer section " + footerdriver.findElements(By.tagName("a")).size());

		WebElement footerDriverFirstColumn = footerdriver
				.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));
		System.out.println(
				"Number of link in first column " + footerDriverFirstColumn.findElements(By.tagName("a")).size());

		// click on each link and check if link is working
		for (int i = 1; i < footerDriverFirstColumn.findElements(By.tagName("a")).size(); i++) {
			String clickonTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			Thread.sleep(5000L);
			footerDriverFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
		}

		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> it = windowId.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
