package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

	public static String url = "https://fs2.formsite.com/meherpavan/form2/index.html";

	public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			WebDriver driver = new ChromeDriver();

			driver.get(url);

			WebElement maleRB = driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']"));
			maleRB.click();
			Thread.sleep(2000);

			// One-line, method chaining
			driver.findElement(By.xpath("//label[text()='Female']")).click();
			Thread.sleep(2000);

			WebElement wednesdayCB = driver.findElement(By.cssSelector("label[for='RESULT_CheckBox-8_3']"));
			wednesdayCB.click();
			Thread.sleep(2000);

			// findElements will return a List of WebElements
			// 9 WebElements are located with the following xpath
			
			List<WebElement> elements = driver.findElements(By.xpath("//table[@class='inline_grid choices']/tbody/tr/td/label"));
			
					// I want to click on Female and Saturday and Sunday
			for (WebElement el : elements) {
             String text = el.getText();

				if (text.equals("Female")) {
					el.click();
				} else if (text.equals("Saturday")) {
					el.click();
				} else if (text.equals("Sunday")) {
					el.click();
				}

				Thread.sleep(1000);
			}

			driver.quit();

		}
}