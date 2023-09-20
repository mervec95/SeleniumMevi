package com.neotech.lesson08;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

//Homework 3:
//    Add Employee
//    Open chrome browser ===
//    Go to "https://hrm.neotechacademy.com/" ===
//    Login into the application ===
//    Click on PIM > Add Employee ===
//    Add Employee ===
//    Log out ===
//    Quit the browser ===
public class HW08Part03 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		Thread.sleep(200);

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//span[normalize-space()='Add Employee']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@ng-hide='usedForm.hideLabel']")));
		
		driver.findElement(By.cssSelector("#first-name-box")).sendKeys("Merve");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#middle-name-box")).sendKeys("Hazal");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#last-name-box")).sendKeys("Cuvan");
		Thread.sleep(500);
		
		WebElement we1 = driver.findElement(By.cssSelector("button[class='btn']"));
		we1.click();
		driver.findElement(By.xpath("//span[normalize-space()='Canadian Development Center']")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("span[id='account-job'] i[class='material-icons']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#logoutLink")).click();

		tearDown();

	}

}
