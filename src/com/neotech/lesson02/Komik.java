package com.neotech.lesson02;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Komik {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.neotechacademy.com/");
		
		List<WebElement> elements = driver.findElements(By.tagName("h1"));
		elements.addAll(driver.findElements(By.tagName("a")));
		for(WebElement element: elements) {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='&#9829;&#9829;Merve&#9829;&#9829;'", element);
			Thread.sleep(1000);
		}
		
	}
}

//MERVE kodu :D


