package main;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login2 {
	static String name = "John";
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());	
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		String pwwd = getPassword(driver);
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys(pwwd);
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals((driver.findElement(By.tagName("p")).getText()), "You are successfully logged in.");
		Assert.assertEquals((driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText()), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();	
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String pswddtxt = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/p")).getText();
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		String pswdarray[] = pswddtxt.split("'");
		String password= pswdarray[1].split("'")[0];
		System.out.println(password);
		return password;
	}

}
