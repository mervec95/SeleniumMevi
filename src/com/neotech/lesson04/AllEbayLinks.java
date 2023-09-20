package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllEbayLinks {

	public static String url = "https://www.ebay.com";
	
	public static void main(String[] args) {
		//Go to the "https://www.ebay.com"
		//Get All links on ebay and how many there are
		//Print the links that have the text
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		
		
		int count = 0; 
		
		for (WebElement link : allLinks) {
			if(!link.getText().isEmpty()) { //if the link is not empty
				System.out.println(link.getText());
				count++;
			}
		}
		System.out.println("The total number of links is -> " + allLinks.size());
		System.out.println("The number of links that have text is -> " + count);
		
		driver.quit();
		
		

	}

}
