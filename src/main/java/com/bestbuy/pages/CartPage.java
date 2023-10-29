package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.base.BaseClass;

public class CartPage extends BaseClass {
	
	static ProductPage pp = new ProductPage();
	
	@FindBy(xpath = "//button[@data-track='Paid Membership Contextual Upsell: Plus: No Thanks']")
	WebElement noThanks;
	
	@FindBy(xpath = "(//button[@aria-label='Close'])[2]")
	WebElement close;
	
	@FindBy(xpath="//a[contains(text(),'Google - Pixel 7a 5G 128GB (Unlocked) - Charcoal')]")
	WebElement googlePhoneAddedInCart;
	
	@FindBy(xpath="//a[text()='Samsung - 65” Class CU7000 Crystal UHD 4K Smart Tizen TV']")
	WebElement samsungTvAddedInCart;
	
	@FindBy(xpath="//a[contains(text(),'Sony - SA-SW5 300W Wireless Subwoofer - Black')]")
	WebElement sonyWooferAddedInCart;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutInCart;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateGooglePhoneInCart() {
		return extractText(googlePhoneAddedInCart);
	}
	
	public String validateSamsungTvInCart() {
		WebElement text = driver.findElement(By.xpath("//a[text()='"+ProductPage.samsungTvValidationText()+"']"));
		String text1 = extractText(text);
		return text1;
	}
	
	public String validateSonyWooferInCart() {
		waitUntilClickable(checkOutInCart);
		return extractText(sonyWooferAddedInCart);
	}
	
	public void goToCheckOutPage() {
		clickOn(noThanks);
		clickOn(checkOutInCart);
	}
	
}
