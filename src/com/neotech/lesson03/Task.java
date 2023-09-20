package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//1. Open chrome browser
//2. Go to "https://www.facebook.com/"
//3. Enter valid username and valid password and click login
//4. User successfully logged in
public class Task {

	public final static String url = "https://www.facebook.com/";

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Merve@yahoo.com");
		Thread.sleep(200);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input")).sendKeys("12345");
		Thread.sleep(200);
		
		//clicking on login button
		//1.  //button[@name='login']
		//2. //button[@type='submit']
		//3. //button[@id='u_0_5_mU'] ---> this is generated, next time I try to test might be different
		//4. //button[contains(@id, 'u_0')]
				
		driver.findElement(By.xpath("//button[contains(@id, 'u_0')]")).click();
				
		Thread.sleep(5000);
				
		//driver.quit();
		
		

	}

}
