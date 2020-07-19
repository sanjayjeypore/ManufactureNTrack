package com.mnt.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mnt.qa.base.TestBase;

public class CreateProductMaserPage extends TestBase{
	//Page Facotory
	@FindBy(xpath = "//input[@name=\"ITEM\"]")
	WebElement productID;
	
	@FindBy(xpath="//input[@value=\"Auto-Generate\"]")
	WebElement productIDAuto;
	
	@FindBy(xpath="//input[@name='DESC']")
	WebElement productDesc;
	
	@FindBy(xpath="//select[@name='ARTIST']")
	WebElement productTypeSelect;
	
	@FindBy(xpath ="//select[@name='PRD_BRAND']")
	WebElement prodcutBrandSelect;
	
	@FindBy(xpath ="//select[@name=\"UOM\"]")
	WebElement uomSelect;
	
	@FindBy(xpath ="//input[@name=\"STKQTY\"]")
	WebElement txtMinStockQty;
	
	@FindBy(xpath="//input[@name='MAXSTKQTY']")
	WebElement txtMaxStockQty;
	
	@FindBy(xpath="//input[@name='REMARKS']")
	WebElement txtDetailsDescription;
	
	@FindBy(xpath ="//input[@name='MANUFACT']/parent::td//a")
	WebElement popupManufacturer;
	
	@FindBy(xpath ="//input[@name='MANUFACT']")
	WebElement txtManufacturer;
	
	@FindBy(id = "LOC_0")
	WebElement txtPutAwayLoc;
	
	@FindBy(xpath="//input[@name='ITEM_CONDITION']")
	WebElement txtRemark1;
	
	@FindBy(xpath="//input[@name='TITLE']")
	WebElement txtRemark2;
	
	@FindBy(id ="NotNonStock")
	WebElement chkNonStockNO;
	
	@FindBy(id = "NonStock")
	WebElement chkNonStockYes;
	
	@FindBy(id = "PRICE")
	WebElement txtListPrice;
	
	@FindBy(id = "COST")
	WebElement txtCost;
	
	@FindBy(id ="MINSELLINGPRICE")
	WebElement txtMinSellingPrice;
	
	@FindBy(id = "DISCOUNT")
	WebElement txtDiscount;
	
	@FindBy(xpath ="//input[@value=\"Save\"]")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@value='Back']")
	WebElement btnBack;
	
	
	
	////input[@name='MANUFACT']/parent::td//a
	
	public CreateProductMaserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void CreateProduct(String productClass,String prdID,String prodDesc,String prodType,String prodBrand,
			String uom, String minStockQty,String maxStockQty, String detailDescription, String manufacturer,
			String putAwayLoc,String remark1,String remark2,String nonStock, String price, String cost,
			String minsellingPrice, String discount){
		Select select = new Select(driver.findElement(By.name("PRD_CLS_ID")));
		select.selectByValue(productClass);
		if(productID.equals("Auto"))
			productIDAuto.click();
		else
			productID.sendKeys(prdID);
		
		productDesc.sendKeys(prodDesc);
		Select prodTypeSelect = new Select(productTypeSelect);
		prodTypeSelect.selectByValue(prodType);
		
		Select prodBrandSelect = new Select(prodcutBrandSelect);
		prodBrandSelect.selectByValue(prodBrand);
		
		Select uomSel = new Select(uomSelect);
		uomSel.selectByValue(uom);
		
		txtMinStockQty.sendKeys(minStockQty);
		txtMaxStockQty.sendKeys(maxStockQty);
		txtManufacturer.sendKeys(manufacturer);
		
//		popupManufacturer.click();
//		Set<String> handler = driver.getWindowHandles();
//		
//		Iterator<String> it = handler.iterator();
//		String parentWindowHandle = it.next();
//		
//		String childWindowHandle = it.next();
//		
//		driver.switchTo().window(childWindowHandle);
//		driver.findElement(By.xpath("//a[contains(text(),'"+manufacturer+"')]")).click();
//		
//		driver.switchTo().window(parentWindowHandle);	
		txtPutAwayLoc.sendKeys(putAwayLoc);
		txtRemark1.sendKeys(remark1);
		txtRemark2.sendKeys(remark2);
		if(nonStock.contains("YES"))
			chkNonStockYes.click();
		else
			chkNonStockNO.click();
		
		txtListPrice.sendKeys(price);
		txtCost.sendKeys(cost);
		txtMinSellingPrice.sendKeys(minsellingPrice);
		txtDiscount.sendKeys(discount);
		btnBack.click();
		
	}
	
	public void selectManufacturer() {
		
		String parentWindowHandle = driver.getWindowHandle();
		String childWindowHandle = null;
		int count = 1;
		popupManufacturer.click();		
		
		
		System.out.println();
		for (String handle : driver.getWindowHandles()) {	
			System.out.println(count);
			if(!handle.equalsIgnoreCase(parentWindowHandle)) {
				childWindowHandle = handle;
			}			
			count++;
		}	
		System.out.println(childWindowHandle + "   " + parentWindowHandle );
		driver.switchTo().window(childWindowHandle);
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'S0010')]")).getText());
		System.out.println(driver.getTitle());
		//driver.switchTo().window(parentWindowHandle);
	}
}
