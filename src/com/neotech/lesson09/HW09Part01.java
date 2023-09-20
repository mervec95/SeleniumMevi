package com.neotech.lesson09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

//==================  Lesson 09 HW 1 =======================
//TC: Update Customer Information
//
//1) Open chrome browser +++
//2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx" +++
//3) Login to the application +++
//4) Verify customer "Susan McLaren" is present in the table +++
//5) Click on customer details +++
//6) Update customers last name and credit card info +++
//7) Verify updated customers name and credit card number is displayed in table +++
//8) Close browser +++
public class HW09Part01 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys(ConfigsReader.getProperty("username"));
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys(ConfigsReader.getProperty("password"));
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
		Thread.sleep(500);

		List<WebElement> name = driver.findElements(By.cssSelector("table>tbody>tr:nth-child(6)>td:nth-child(2)"));
		for (WebElement e : name) {
			String expectedname = "Susan McLaren";

			if (e.getText().contains(expectedname)) {
				System.out.println("Name is -> " + e.getText());
			} else {
				System.out.println("Wrong!");
			}
		}
		List<WebElement> beforechange = driver.findElements(By.cssSelector("table>tbody>tr:nth-child(6)"));
		for(WebElement el : beforechange) {
			System.out.println("Before change -> " + el.getText());
		}
		
	    driver.findElement(By.cssSelector("table>tbody>tr:nth-child(6)>td:nth-child(13)>input")).click();
		Thread.sleep(500);
		
		WebElement updateln = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
		updateln.clear();
		updateln.sendKeys("Susan Watson");
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_2']")).click();
		Thread.sleep(500);
		
		WebElement updateccn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
		updateccn.clear();
		updateccn.sendKeys("000111222333");
		Thread.sleep(500);
		
		WebElement updateccd = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
		updateccd.clear();
		updateccd.sendKeys("09/17");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("table>tbody>tr>td>div>a")).click();

		List<WebElement> afterchange = driver.findElements(By.cssSelector("table>tbody>tr:nth-child(6)"));
	
		for(WebElement el1 : afterchange) {
			System.out.println("After change -> " + el1.getText());
			
		}
		
		
				
		
		quit(1);

	}

}
