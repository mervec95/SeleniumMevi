package com.neotech.lesson05;

import com.neotech.utils.BaseClass;

public class OrangeHRM3 extends BaseClass {


	public static void main(String[] args) throws InterruptedException {
		// this will open the browser and navigate to the url
		setUp();

		// write test code here
		String title = driver.getTitle();
		System.out.println("title: " + title);
		Thread.sleep(3000);

		// this will close the browser
		tearDown();

	}

}
