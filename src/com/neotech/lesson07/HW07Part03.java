package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

//================== HW_3 Overall Practice of WebElements and handling Windows, Alerts ==================
//
//1) Launch the browser and open the site "https://www.tutorialspoint.com/selenium/selenium_automation_practice" =====
//2) Fill in the all text boxes, Choose your preferred radio button, check box and drop down option 
//EXCEPT Profile Picture (Dissmiss this Section) =====
//3) Click on the Button and you will see an Alert pops up then click Ok
//4) When user clicks on Ok new Window will open then get All window handles and get the size and Quit all of them =====
public class HW07Part03 {
	public final static String url = "https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Merve");
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Cuvan");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[value='1']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("Sep 14 2023");
		driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[value='Manual Tester']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[value='RC']")).click();
		Thread.sleep(500);

		Select Cont = new Select(driver.findElement(By.name("continents")));
		Cont.selectByVisibleText("North America");
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Select SC = new Select(driver.findElement(By.name("selenium_commands")));
		SC.selectByIndex(1);
		Thread.sleep(500);

		driver.findElement(By.cssSelector("button[name='submit']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		Set<String> pages = driver.getWindowHandles();
		System.out.println("All window size: " + pages.size());
		Thread.sleep(500);
		Iterator <String>i = pages.iterator();
		String p1 = i.next();
		String p2 = i.next();

		driver.switchTo().window(p2);
		Thread.sleep(500);
		System.out.println("First window: " + p1);
		System.out.println("New window: " + p2);
		

//		driver.close();
//
//		driver.quit();

	}

}
