package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.CreateAccountPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;

import org.testng.annotations.BeforeTest;


public class TC_03_CreateAccountFunction extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_03_CreateAccountFunction";
		testDescription = "CreatAccount Functionality";
		testCategory = "Regression";
		testAuthor = "Ajay A";
		sheetName="loginTestData";
	}
	
	@Test(dataProvider="getFromExcel", priority=3)
	public void TC_03(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		LocationPage lp=new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp=new HomePage();
		hp.goToCreatAccount();
		CreateAccountPage ca=new CreateAccountPage();
		String actMsg = ca.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText, expMsg);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}
}
