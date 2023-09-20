package com.neotech.lesson09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework3 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
/*	        Add Employee
	        Open chrome browser
	        Go to "https://hrm.neotechacademy.com/"
	        Login into the application
	        Click on PIM > Add Employee 
	        Add Employee
	        Log out 
	        Quit the browser*/
		
		
		setUp();
		
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//get the username in cofiguration file and send it to the username box
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		
		//log in
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		//navigate to PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		//click on Add Employee
		driver.findElement(By.linkText("Add Employee")).click();
		
		//it seems not always the implicit wait can cover the add employee late showing
		WebDriverWait nameBoxWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		nameBoxWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box")));
		
		//send employee data
		driver.findElement(By.id("first-name-box")).sendKeys("Mert");
		driver.findElement(By.id("last-name-box")).sendKeys("Sorkun");
		
		
		//get the select element
		WebElement sl = driver.findElement(By.id("location"));
		Select s = new Select(sl);
		s.selectByVisibleText("France Regional HQ");
		
		
		
		//Wait for the save button
		WebDriverWait saveBtnWait = new WebDriverWait(driver, Duration.ofSeconds(25));
		saveBtnWait.until(ExpectedConditions.elementToBeClickable(By.id("modal-save-button")));
		//save the entered employee
		driver.findElement(By.id("modal-save-button")).click();
		
		
		//it takes a bit long to save the employee
		//so I will wait until the personal details tab is shown and then click to logout
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(20));
		fluentWait.pollingEvery(Duration.ofSeconds(2));
		
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_details_tab")));
		
		
		//log out
		driver.findElement(By.id("account-job")).click();
		driver.findElement(By.id("logoutLink")).click();
		
		tearDown();
		

	}

}