package com.neotech.lesson07;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
//        Alert text verification
//        Open chrome browser
//        Go to https://web.archive.org/web/20220318045943/https://demoqa.com/alerts
//        Click on "Alerts, Frame & Windows" link
//        Click on "Alerts" links on the left side
//        Click on button to see Alert
//        Verify alert box with text "You clicked a button" is present
//        Click on 3rd button in the page
//        Verify alert box with text "Do you confirm action?" is present and click "confirm"
//        Click on 4 th button in the page and enter your name and click ok.
//        Quit browser

		setUp();

		Thread.sleep(1000);

//		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
//		Thread.sleep(2000);

		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);

		// Now the pop-up alert is shown
		Alert alert = driver.switchTo().alert();
		System.out.println("The text of the alert -> " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(1000);

		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("The text of confirm alert -> " + confirmAlert.getText());
		confirmAlert.accept();
		Thread.sleep(1000);

		// Click on the prompt alert
		driver.findElement(By.id("promtButton")).click();

		// I am re-assigning the new Alert to the existing variable
		alert = driver.switchTo().alert();

		alert.sendKeys("Albania");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		tearDown();

	}

}