package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.CartPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;
import com.bestbuy.pages.ProductPage;

import org.testng.annotations.BeforeTest;

public class TC_09_AddProductByBrand extends BaseClass {

	@BeforeTest
	public void setup() {

		testName = "TC_09_AddProductByBrand";
		testDescription = "Search a Item by Brands in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}

	@Test(priority=9)
	public void TC_09() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.selectSonyBrand();
		ProductPage pp = new ProductPage();
		String sonyWooferTitleAtProdPage = pp.addSonyWooferInProdPage();
		Thread.sleep(5000);
		hp.goToCartPage();
		CartPage cp = new CartPage();
		String sonyWooferTitleAtCartPage = cp.validateSonyWooferInCart();
		softAssert(sonyWooferTitleAtCartPage, sonyWooferTitleAtProdPage);
		if(sonyWooferTitleAtCartPage.equals(sonyWooferTitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
