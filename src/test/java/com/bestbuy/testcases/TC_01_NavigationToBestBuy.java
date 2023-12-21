	package com.bestbuy.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.LocationPage;

public class TC_01_NavigationToBestBuy extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_01_NavigationToBestBuy";
		testDescription = "Navigating to the Best Buy e-commerce website";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=1)
	public void TC_01_ValidateTitle() throws Exception {
		LocationPage lp=new LocationPage();
		String actTitle = lp.bestBuyPageTitle();
		String expTitle="Best Buy International: Select your Country - Best Buy";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating Best Buy Page Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy Page Title - Fail", "Fail", testName);
		}
	}
	
}
