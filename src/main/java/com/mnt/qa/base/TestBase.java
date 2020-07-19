package com.mnt.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mnt.qa.util.TestUtil;
import com.mnt.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"F:\\Selenium WebDriver Training\\ManufactureAndTrackTest\\src\\main\\java\\com\\mnt\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium WebDriver Training\\geckodriver.exe");

			driver = new FirefoxDriver(); // launch firefox browser
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//create object of EventListnerHandler to register it with EventFiringWebDriver.
		eventListner = new WebEventListener();
		e_driver.register(eventListner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_LOAD, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
