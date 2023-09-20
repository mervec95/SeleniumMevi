package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Komik2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.neotechacademy.com/");
		
		for(WebElement element: driver.findElements(By.tagName("img"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('src', 'https://ca.slack-edge.com/T058935L5FV-U059857R1RA-7aaee1105d2b-100');", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('srcset', 'https://ca.slack-edge.com/T058935L5FV-U059857R1RA-7aaee1105d2b-100');", element);
			Thread.sleep(200);
		}
		
	}
}

//merve takla atiyo:D