package com.mnt.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.mnt.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate To URL:"  +url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigate To URL:"  +url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigate Back:");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigate Back:");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigate Forward:");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigate Forward:");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Navigate Refresh:");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigate Refresh:");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before Find	By:");
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before Find	By: " +by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before Click on: " +element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After Click on: " +element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before Change ValueOf : " +element.toString() + " Char: " + keysToSend);
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After Change ValueOf : " +element.toString() + " Char: " + keysToSend);
		
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before Script : " +script);
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("After Script : " +script);
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before Switch To Window  : " +windowName);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After Switch To Window  : " +windowName);
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("On Exception  : " +throwable);
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Before Get Screenshot ");
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("After Get Screenshot ");
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before Get Text : " +element.toString());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("After Get Text : " +element.toString());
		
	}

}
