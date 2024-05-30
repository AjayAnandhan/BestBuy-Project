package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.LocationPage;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

public class TC_02_ValidateURLIsNotBroken extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_02_ValidateURLIsNotBroken";
		testDescription = "Given URL Link is broken or not";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=2)
	public void TC_02() throws Exception {
		LocationPage lp=new LocationPage();
		if (lp.urlResponseCode()==200) {
			reportStep("Validating Best Buy page URL is broken or not - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy page URL is broken or not - Fail", "Fail", testName);
		}
		AssertJUnit.assertTrue(lp.urlResponseCode()==200);
	}
}
