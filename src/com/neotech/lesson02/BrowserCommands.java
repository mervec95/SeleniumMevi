package com.neotech.lesson02;

//1. Open chrome browser
//2. Navigate to “https://www.zillow.com/”
//3. Navigate to “https://www.google.com/”
//4. Navigate back to Zillow Page
//5. Refresh current page
//6. Verify url contains “Zillow”

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver(); 
		
		//1st way
		//there is not history
		//waits for the page to be fully loaded
		//driver.get("https://www.zillow.com/");
		
		//2nd way 
		//keeps history
		//does not wait for the page to be loaded
		driver.navigate().to("https://www.zillow.com/");
		
		Thread.sleep(1000);
		
		
		driver.manage().window().maximize(); // makes full screen
		// driver.manage().window().fullscreen(); //makes full screen
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(1000);
		
		driver.navigate().back(); //brings us back to zillow
		Thread.sleep(1000);
		
		driver.navigate().forward(); //brings us back to google
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}
