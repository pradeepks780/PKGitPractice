package com.pk.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);

	}

	@Test(groups = { "pradeep" }, description = "Test Method description")
	public void testMethod1() throws InterruptedException {

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table3");

		driver.switchTo().frame("iframeResult");

		WebElement table = driver.findElement(By.xpath("//*[text()='A basic HTML table']/following::table"));

		System.out.println("Table Displayed? " + table.isDisplayed());

		List<WebElement> rows = table.findElements(By.xpath(".//tr"));

		System.out.println(rows.get(2).findElements(By.xpath(".//td")).get(1).getText() );
		for (WebElement row : rows) {

			List<WebElement> td = row.findElements(By.xpath(".//th"));

			for (WebElement tableheader : td) {
				System.out.println(tableheader.getText());
			}
		}
	}

	@AfterTest(description = "Method to close all browsers post actions")
	public void tearDown() throws InterruptedException {

		driver.close();
		driver.quit();

	}

}
