package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginXpathDemo {
	public final static String url = "http://neotechacademy-sis.com:9000/Test/";

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		//full xpath example for username
		//driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td[2]/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[3]/input")).sendKeys("Admin");
		
		
		//relative xpath for username
		////*[@id="tUsername"]
		driver.findElement(By.xpath("//*[@id=\"tUsername\"]")).sendKeys("Admin");
		
		
		//create an xpath for the password
		driver.findElement(By.xpath("//*[@id=\"tPassword\"]")).sendKeys("Neotech$123"); //right click->inspect->copy->copy full xpath or xpath
		
		
		Thread.sleep(3000);
		
		
		
		driver.quit();
		
		
	}

}
