package com.neotech.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;

		public static void setUp() throws InterruptedException {
			ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

			String browser = ConfigsReader.getProperty("browser");
			// System.out.println(browser);

			switch (browser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;

			default:
				break;
			}
			if(browser.toLowerCase() == "chrome") {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
			} else if (browser.toLowerCase() == "firefox") {
				System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
				driver = new FirefoxDriver();
			}

			Thread.sleep(2000);
			driver.manage().window().maximize();
			String website = ConfigsReader.getProperty("url");
			driver.get(website);
		}

		public static void tearDown() {
			if (driver != null) {
				driver.quit();
			}
		}
		
		public static boolean login(String[] username, String[] password, String login, int _second) throws InterruptedException {
			if(!username[0].isEmpty() && !username[1].isEmpty() && !password[0].isEmpty() && !login.isEmpty()) {				
				driver.findElement(By.cssSelector(username[0])).sendKeys(username[1]);
				driver.findElement(By.cssSelector(password[0])).sendKeys(password[1]);
				driver.findElement(By.xpath(login)).click();
				
				Thread.sleep(_second*1000);
				return true;
			}
			
			return false;
		}
		
		public static List<WebElement> getTableRows(String _selector, int _second) throws InterruptedException {
			if(!_selector.isEmpty()) {
				List<WebElement> value = driver.findElements(By.cssSelector(_selector + ">tbody>tr"));
				Thread.sleep(_second*1000);
				return value;
			}
			
			return null;
		}
		
		public static void quit(int _second) throws InterruptedException {
			if(driver != null) {
				Thread.sleep(_second*1000);
				driver.quit();
			}
		}
	}