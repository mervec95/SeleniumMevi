package com.neotech.lesson09;

import java.util.Iterator;
//=================   Lesson 09 HW 2 =================================
//TC: Delete Orders
//
//1) Open chrome browser +++
//2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx" +++
//3) Login to the application +++
//4) Click on the checkbox of all orders with product FamilyAlbum +++
//5) Delete Selected orders
//6) Verify the orders have been deleted
//7) Quit the browser
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class HW09Part0222 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		setUp();
//		driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys(ConfigsReader.getProperty("username"));
//		driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys(ConfigsReader.getProperty("password"));
//		driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

		String buttonXpath = "//*[@id='ctl00_MainContent_login_button']";
		String[] usernameTag = { "input#ctl00_MainContent_username", ConfigsReader.getProperty("username") };
		String[] passwordTag = { "input#ctl00_MainContent_password", ConfigsReader.getProperty("password") };

		if (login(usernameTag, passwordTag, buttonXpath, 2))
			;
//		{
//			System.out.println("Logined!");
//		}

		// table>tbody>tr:not(:nth-child(1))>td:nth-child(3)
		// //table/tbody/tr[position()>1]/td[3]
		// //table/tbody/tr[position()>1]/td[3][text()='FamilyAlbum']/parent::tr/td[1]

		// List<WebElement> rows1 = getTableRows("table#customers", 1);
		// List<WebElement> cols1 = getTableHeaders("table#customers", 1);

		List<WebElement> target = driver.findElements(By.xpath("//table/tbody/tr[position()>1]/td[3][text()='FamilyAlbum']/parent::tr/td[1]/input"));
		System.out.println("Size of target -> " + target.size());
		for (WebElement element : target) {
			element.click();
		}

		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click(); // Deleted button is clicked!

		List<WebElement> target2 = driver.findElements(By.xpath("//table/tbody/tr[position()>1]/td[3][text()='FamilyAlbum']/parent::tr/td[1]/input"));
		System.out.println("Size of target -> " + target2.size());
		if (target2.size() == 0) {
			System.out.println("Test is pass!");
		} else {
			System.out.println("Test is fail!");
		}

//		2nd Way

//		String expected = "FamilyAlbum";
//		
//		List<WebElement> col3 = driver.findElements(By.cssSelector("table>tbody>tr:not(:nth-child(1))>td:nth-child(3)"));
//		int i=0;
//		for (WebElement element1 : col3) {
//			i++;
//			if(element1.getText().equalsIgnoreCase(expected)) { //FamilyAlbum
//				driver.findElement(By.cssSelector("table>tbody>tr:nth-child(" + i + ")>td:nth-child(1)>input")).click();
//			}		
//		}

//		Thread.sleep(1000);
//		tearDown();

		
		
//Shane in kodu tek tek ilk odev son part icin
//		List<WebElement> thirdRowNameColumn = driver.findElements(By.cssSelector(" table > tbody > tr:nth-child(4) > td:nth-child(1)"));
//		String name1 = thirdRowNameColumn.get(0).getText();
//		
//		
//		List<WebElement> thirdRowCreditCardColumn = driver.findElements(By.cssSelector(" table > tbody > tr:nth-child(4) > td:nth-child(9)"));
//		String creditCard= thirdRowCreditCardColumn.get(0).getText();
		quit(2);

	}

}
