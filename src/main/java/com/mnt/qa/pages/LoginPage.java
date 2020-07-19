package com.mnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mnt.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory --OR
	@FindBy(id="compny")
	WebElement company;
	
	@FindBy(id="userid")
	WebElement userid;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),\"Sign up\")]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotPassowrdLink;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logoImg;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions: Methods
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogoImg() {
		return logoImg.isDisplayed();
	}
	
	public HomePage login(String comp,String uName, String pwd) {
		company.sendKeys(comp);
		userid.sendKeys(uName);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
}
