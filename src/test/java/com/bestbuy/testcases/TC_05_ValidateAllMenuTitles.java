package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;

import org.testng.annotations.BeforeTest;

public class TC_05_ValidateAllMenuTitles extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_05_ValidateAllMenuTitles";
		testDescription = "Check the different menu titles";
		testCategory = "Regression";
		testAuthor = "Ajay A";
		sheetName="menuGenricTestData";
	}
	
	@Test(dataProvider="getFromExcel", priority=5)
	public void TC_05(String menuName,String expTitle) throws Exception {
		LocationPage lp=new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp=new HomePage();
		String actTitle = hp.menuValidation(menuName);
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of different Menu - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of different Menu - Fail", "Fail", testName);
		}
	}
}
