package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxes {

	public static String url = "https://fs2.formsite.com/meherpavan/form2/index.html";

	public static void main(String[] args) throws InterruptedException {

		System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		// 1st way, locating the element multiple times
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']")).sendKeys("Yildirim");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']")).clear();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']")).sendKeys("Achraf");
		Thread.sleep(2000);

		driver.findElement(By.id("RESULT_TextField-2")).clear();
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("Elion");
		Thread.sleep(2000);

		// 2nd way, code redundancy and re-usability
		WebElement phone = driver.findElement(By.cssSelector("#RESULT_TextField-3"));
		phone.sendKeys("924-739-111");
		Thread.sleep(500);
		phone.clear();
		phone.sendKeys("123-456-789");
		Thread.sleep(2000);

		// Getting the value of an attribute
		String maxLength = phone.getAttribute("maxlength");
		System.out.println("The value of maxlength is -> " + maxLength);

		WebElement country = driver.findElement(By.name("RESULT_TextField-4"));
		String countryclass = country.getAttribute("class");
		System.out.println("The class attribute of country WebElement is -> " + countryclass);

		// Getting the text inside the WebElement
		String headerText = driver.findElement(By.xpath("//div[@id='q19']//h1")).getText();
		System.out.println("The header text is -> " + headerText);

		driver.quit();

	}

}
//div[@id='q19']//h1
// div[@id='q19']/div/h1
