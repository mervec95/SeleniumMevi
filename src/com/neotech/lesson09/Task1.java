package com.neotech.lesson09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		setUp();
		
//		https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html
		
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
		
		String expected = "Financial Center";
		String actual = table.getText();
		
		if (actual.contains(expected))
		{
			System.out.println(expected + " is in the table!");
		}
		else
		{
			System.out.println(expected + " is NOT in the table!");
		}
		
		System.out.println("----- All Column Headers -------");
		
		List<WebElement> headerData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));
		
		for (WebElement data : headerData)
		{
			System.out.print(data.getText() + " | ");
		}
		System.out.println();
		
		
		
		System.out.println("---- All Row Data ------");
		
		
		List<WebElement>  rowData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
		
		for (WebElement row : rowData)
		{
			System.out.println(row.getText());
		}
		
		
		tearDown();
	}

}