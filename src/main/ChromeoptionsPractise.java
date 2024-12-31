package main;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ChromeoptionsPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		// Accept certification
		options.setAcceptInsecureCerts(true);

		// Set proxy
		Proxy pr = new Proxy();
		pr.setHttpProxy("ipaddress:444433");
		options.setCapability("proxy", pr);

		// Add extension
		options.addExtensions(new File("path/to/extension/.crx"));

		// Block all pop ups which enables locations

		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		// set download directory

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver",
				"D:/Jyotsna Documents/Study/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}
}
