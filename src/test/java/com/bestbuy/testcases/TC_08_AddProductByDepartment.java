package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.CartPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;
import com.bestbuy.pages.ProductPage;

import org.testng.annotations.BeforeTest;

public class TC_08_AddProductByDepartment extends BaseClass {

	@BeforeTest
	public void setup() {
		
		testName = "TC_08_AddProductByDepartment";
		testDescription = "Search a Item by Department in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=8)
	public void TC_08() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.selectTvMenuInHomePage();
		ProductPage pp = new ProductPage();
		String samsungTitleAtProdPage = pp.addSamsungTVInProdPage();
		hp.goToCartPage();
		CartPage cp = new CartPage();
		String samsungTitleAtCartPage = cp.validateSamsungTvInCart();
		softAssert(samsungTitleAtCartPage, samsungTitleAtProdPage);
		if (samsungTitleAtCartPage.equals(samsungTitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
