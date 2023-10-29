package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;
import com.bestbuy.pages.SignInPage;

import org.testng.annotations.BeforeTest;


public class TC_04_SignInFunction extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_04_SignInFunction";
		testDescription = "Sign-In Functionality";
		testCategory = "Regression";
		testAuthor = "Ajay A";
		sheetName="signInTestData";
	}
	
	@Test(dataProvider="getFromExcel", priority=4)
	public void TC_04(String email,String password,String xpath,String expMsg) throws Exception {
		LocationPage lp=new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp=new HomePage();
		hp.goToSignIn();
		SignInPage sp=new SignInPage();
		String actMsg = sp.signInFunctionality(email,password,xpath);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating Sign-In Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating Sign-In Functionality - Fail", "Fail", testName);
		}
	}
}
