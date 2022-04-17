package com.mystore.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;


	public class BaseClass {
		public static Properties prop;
		public static WebDriver driver;
		public void loadConfig() {
			
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
			return driver.get();}
		

		public void launchApp(String browserName) {
			// String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				
				driver.set(new ChromeDriver());
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver.set(new InternetExplorerDriver());
			}
		}
		public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
			// TODO Auto-generated method stub
			
		}
}

