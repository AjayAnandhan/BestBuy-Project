package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.CartPage;
import com.bestbuy.pages.CheckOutPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;
import com.bestbuy.pages.ProductPage;

import org.testng.annotations.BeforeTest;

public class TC_10_PlaceOrderAndValidate extends BaseClass {
	
	@BeforeTest
	public void setup() {
		testName = "TC_10_PlaceOrderAndValidate";
		testDescription = "Navigating to the checkout page and filling the form with dummy payment information then check the order is wheather placed or not";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=10)
	public void TC_10() throws Exception {
		LocationPage lp=new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp=new HomePage();
		hp.searchProduct("Google - Pixel 7a 5G 128GB");
		Thread.sleep(8);
		ProductPage pp=new ProductPage();
		pp.addGooglePhone();
		Thread.sleep(3);
		CartPage cp=new CartPage();
		cp.goToCheckOutPage();
		CheckOutPage cop=new CheckOutPage();
		cop.contactInfoAtCheckOut();
		cop.enterDetailsOnCheckOut();
		String orderResponseMessage = cop.validateOrder();
		if(assertCheck(orderResponseMessage, readProperty("orderConfirmationMessage"))) {
			reportStep("Order is placed Successfully - Pass", "Pass", testName);
		}
		else {
			reportStep("Order wasn't placed- Fail", "Fail", testName);
		}
		
	}
}
