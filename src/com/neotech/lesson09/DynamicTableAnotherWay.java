package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class DynamicTableAnotherWay extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//https://hrm.neotechacademy.com/

		
				setUp();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				
				//login 
				//get the username in cofiguration file and send it to the username box
				driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
				driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
						
				//log in
				driver.findElement(By.xpath("//button[@type='submit']")).submit();
						
				//navigate to PIM menu
				driver.findElement(By.id("menu_pim_viewPimModule")).click();		
				//click on Employee List
				driver.findElement(By.linkText("Employee List")).click();
				
				
				Thread.sleep(3000);
				
				//find all the rows that contain Linda
				
				String expected = "Linda";
				
				List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
				
				
				for (int i = 0; i < rows.size(); i++)
				{
					String rowText = rows.get(i).getText();
					System.out.println(i + " " + rowText);
					
					
					if(rowText.contains(expected))
					{
						//at this point, I know that linda will be in record number i
						
						//let us assume Linda is in the row with i = 4 (4+1)
						//then we can build this path //table[@id='employeeListTable']/tbody/tr[5]/td[1]
						
						int rowIndex = i+1;
						String path = "//table[@id='employeeListTable']/tbody/tr[" +rowIndex+ "]/td[1]";
						
						driver.findElement(By.xpath(path)).click();
						
						break;
					}
				}
				
				
				Thread.sleep(5000);
				
			
			tearDown();

	}

}