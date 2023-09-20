package com.neotech.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.neotechacademy.com/");
		  
		  String title = driver.getTitle();
		  System.out.println("title - " + title);
		  
		  Thread.sleep(5000); // 5000 milliseconds = 5 seconds
		  
		  driver.close();
		 }
		}

	