package com.mnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mnt.qa.base.TestBase;
import com.mnt.qa.pages.CreateProductMaserPage;
import com.mnt.qa.pages.HomePage;
import com.mnt.qa.pages.LoginPage;
import com.mnt.qa.util.TestUtil;

public class CreateProductMasterTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CreateProductMaserPage createProdMasterPage;
	String sheetName ="ProductMaster";
	
	public CreateProductMasterTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("companycode"),prop.getProperty("username"),prop.getProperty("password"));
		createProdMasterPage = homePage.clickCreateProductLink();
	}
	
//	@Test
//	public void selectManufacturerTest() {
//		createProdMasterPage.selectManufacturer();
//	}
	
	@DataProvider
	public Object[][] getProductMasterTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getProductMasterTestData")
	public void createProductTest(String productClass,String ProductID,String productDescription, String ProductType, 
			String productBrand, String uom, String minStockQty, String maxStockQty,
			String detailDescription, String manufacturer, String recomendedPutAwayLocation, String remark1, String remark2, 
			String nonStock, String listPrice, String cost, String minSellingPrice, String discountPrice){
		createProdMasterPage.CreateProduct(productClass, ProductID, 
				productDescription, ProductType, productBrand, uom, minStockQty, maxStockQty, 
				detailDescription, manufacturer, recomendedPutAwayLocation, remark1, remark2, 
				nonStock, listPrice, cost, minSellingPrice, discountPrice);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	

}
