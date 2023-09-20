package com.neotech.lesson02;

public class C_ChromeDriver implements I_WebDriver {

	public C_ChromeDriver() {
		System.out.println("Chrome is opening");
	}

	@Override
	public void get(String url) {
		System.out.println("Navigate to url:" + url);

	}

	@Override
	public String getTitle() {
		System.out.println("Chrome gets the title");
		return "Page title";
	}

	@Override
	public String getCurrentUrl() {
		System.out.println("Chrome gets the current url");
		return "Page current url";
	}

	@Override
	public void close() {
		System.out.println("Chrome is closing");

	}

	@Override
	public void quit() {
		System.out.println("Chrome is quitting");

	}

}
