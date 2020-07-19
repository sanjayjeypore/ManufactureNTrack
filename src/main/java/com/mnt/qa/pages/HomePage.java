package com.mnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mnt.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),\"test company\")]")
	WebElement companyName;
	
	@FindBy(xpath="//a[@href='logout.jsp']")
	WebElement logOut;
	
	@FindBy(xpath="//a[text()=\"SYS MASTER\"]")
	WebElement sysMasterLink;
	
	@FindBy(xpath="//table[@id=\"sublink12\"]//a[text()='Create Product ID Details']")
	WebElement createProductLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public CreateProductMaserPage clickCreateProductLink() {
		Actions action = new Actions(driver);
		action.moveToElement(sysMasterLink).build().perform();
		createProductLink.click();
		return new CreateProductMaserPage();
		
	}

}
