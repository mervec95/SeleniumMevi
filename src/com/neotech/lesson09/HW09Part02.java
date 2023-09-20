package com.neotech.lesson09;

import java.util.Iterator;
//=================   Lesson 09 HW 2 =================================
//TC: Delete Orders
//
//1) Open chrome browser +++
//2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx" +++
//3) Login to the application +++
//4) Click on the checkbox of all orders with product FamilyAlbum +++
//5) Delete Selected orders +++
//6) Verify the orders have been deleted +++
//7) Quit the browser +++
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class HW09Part02 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		String login = "//*[@id='ctl00_MainContent_login_button']";
		String[] username = { "input#ctl00_MainContent_username", ConfigsReader.getProperty("username") };
		String[] password = { "input#ctl00_MainContent_password", ConfigsReader.getProperty("password") };

		if (login(username, password, login, 2));
			
		List<WebElement> target = driver.findElements(By.xpath("//table/tbody/tr[position()>1]/td[3][text()='FamilyAlbum']/parent::tr/td[1]/input"));
		System.out.println("Size of target -> " + target.size());
		for (WebElement element : target) {
			element.click();
		}

		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click(); 

		List<WebElement> target2 = driver.findElements(By.xpath("//table/tbody/tr[position()>1]/td[3][text()='FamilyAlbum']/parent::tr/td[1]/input"));
		System.out.println("Size of target -> " + target2.size());
		if (target2.size() == 0) {
			System.out.println("Test is pass!");
		} else {
			System.out.println("Test is fail!");
		}

//		=====  2nd WAY  =====

//		String expected = "FamilyAlbum";
//		
//		List<WebElement> col3 = driver.findElements(By.cssSelector("table>tbody>tr:not(:nth-child(1))>td:nth-child(3)"));
//		int i=0;
//		for (WebElement element1 : col3) {
//			i++;
//			if(element1.getText().equalsIgnoreCase(expected)) { 
//				driver.findElement(By.cssSelector("table>tbody>tr:nth-child(" + i + ")>td:nth-child(1)>input")).click();
//			}		
//		}
		quit(2);

	}

}
