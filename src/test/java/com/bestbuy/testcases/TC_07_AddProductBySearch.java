package com.bestbuy.testcases;

import org.testng.annotations.Test;

import com.bestbuy.base.BaseClass;
import com.bestbuy.pages.CartPage;
import com.bestbuy.pages.HomePage;
import com.bestbuy.pages.LocationPage;
import com.bestbuy.pages.ProductPage;

import org.testng.annotations.BeforeTest;

public class TC_07_AddProductBySearch extends BaseClass {

	@BeforeTest
	public void setup() {

		testName = "TC_07_AddProductBySearch";
		testDescription = "Search a Item in search box and add it in cart";
		testCategory = "Regression";
		testAuthor = "Ajay A";
	}
	
	@Test(priority=7)
	public void TC_07() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.searchProduct("Google - Pixel 7a 5G 128GB");
		ProductPage pp = new ProductPage();
		String prodTitleAtProductPage = pp.addGooglePhone();
		CartPage cp = new CartPage();
		String prodTitleAtCartPage = cp.validateGooglePhoneInCart();
		softAssert(prodTitleAtProductPage, prodTitleAtCartPage);
		if (prodTitleAtProductPage.equals(prodTitleAtCartPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
