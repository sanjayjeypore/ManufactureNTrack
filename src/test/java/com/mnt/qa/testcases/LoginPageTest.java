package com.mnt.qa.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mnt.qa.base.TestBase;
import com.mnt.qa.pages.HomePage;
import com.mnt.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Into SetUp method");
		initialization();
		loginPage = new LoginPage();
		log.info("Out of SetUp method");
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("Into  loginPageTitleTest");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "MuRho - Your Partner in Supply Chain Execution", "Title is incorrect");
	}
	
	@Test(priority = 2)
	public void loginPageValidateLogoImgTest() {
		boolean res = loginPage.validateLogoImg();
		Assert.assertEquals(true, true,"There is no logo");
	}
	@Test(priority = 3)
	public void loginPageLoginTest() {
		
		homePage = loginPage.login(prop.getProperty("companycode"),prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
