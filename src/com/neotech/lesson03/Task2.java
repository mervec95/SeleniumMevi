package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//1. Open chrome browser
//2. Go to "https://www.facebook.com/"
//3. Enter valid username and valid password and click login
//4. User successfully logged in

public class Task2 {

public final static String url = "https://www.facebook.com/";
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.cssSelector("#email")).sendKeys("john123");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("john123");
		
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		//this is a generated id, it will change the next time you run, so it 
		//cannot find the element
		//driver.findElement(By.cssSelector("button#u_0_5_mU")).click();
		
		//we could still use part of that id
		
		
		Thread.sleep(5000);
		
		
		//driver.quit();
	}

}
