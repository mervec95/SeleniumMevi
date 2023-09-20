package com.neotech.lesson06;
//Homework 1:
//Amazon Department List Verification
//Open chrome browser
//Go to "http://amazon.com/"
//Verify how many department options available.
//Print each department 
//Select Computers
//Quit browser
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.neotech.utils.BaseClass;
public class HW06Part01 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		Thread.sleep(1000);

		WebElement we = driver.findElement(By.cssSelector("#searchDropdownBox"));
		we.click();
		Thread.sleep(500);

		Select s = new Select(we);
		System.out.println("The all department: " + s.getOptions().size());
		List<WebElement> options = s.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}

		s.selectByValue("search-alias=computers-intl-ship");
		Thread.sleep(500);
		//tearDown();

	}

}
