package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;

import org.testng.annotations.BeforeTest;

public class TC_06_ValidateLinksInBottom extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_06_ValidateLinksInBottom";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=6)
	public void TC_06() throws Exception {
		LocationPage lp=new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp=new HomePage();
		String actTitle = hp.validateTermsAndCondtionLink();
		String expTitle="BestBuy.com Terms and Conditions";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of link in bottom of Home Page - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of link in bottom of Home Page - Fail", "Fail", testName);
		}
	}
}
