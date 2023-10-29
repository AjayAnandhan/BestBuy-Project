package com.bestbuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.base.BaseClass;

public class ProductPage extends BaseClass {
	
	@FindBy(xpath="(//button[text()='Add to Cart'])[1]")
	WebElement addToCartGooglePhone;
	
	@FindBy(xpath="//a[@data-track='Attach Modal: Go to cart']")
	WebElement goToCartButton;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cartBtn;
	
	@FindBy(xpath="//button[text()='Continue shopping']")
	WebElement continueShoping;
	
//	@FindBy(xpath="//li[contains(., 'Logitech - G502 Lightspeed')]//button[@class='c-button c-button-primary c-button-sm c-button-block c-button-icon c-button-icon-leading add-to-cart-button']")
//	WebElement logitechMouseAtProductPage;
	
	@FindBy(xpath="//a[contains(text(),'Google - Pixel 7a 5G 128GB (Unlocked) - Charcoal')]")
	WebElement googlePhoneAtProductPage;
	
	@FindBy(xpath="(//button[text()='Add to Cart'])[1]")
	WebElement addToCartTv;
	
	@FindBy(xpath="/html/body/div[5]/main/div[3]/div/div/div/div/div/div/div[2]/div[2]/div[5]/div/div[5]/ol/li[2]/div/div/div/div/div/div[2]/h4")
	static
	WebElement samsungTvHeading;
	
	@FindBy(xpath="//a[contains(text(),'Sony - 75\" Class BRAVIA XR X90K 4K HDR Full Array LED Google TV')]")
	WebElement sony75InchTvHeadingM2;
	
	@FindBy(xpath="//a[text()='Sony home audio']")
	WebElement sonyHomeAudioAtSonyProdPage;
	
	@FindBy(xpath="//a[text()='Sony - SA-SW5 300W Wireless Subwoofer - Black']")
	WebElement sonyWooferAtProdPage;
	
	@FindBy(xpath="(//button[text()='Add to Cart'])[1]")
	WebElement addToCartSonyWoofer;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String addGooglePhone() throws Exception {
		String googlePhoneTitleAtProdPage = extractText(googlePhoneAtProductPage);
		Thread.sleep(10000);
		jsClickOn(addToCartGooglePhone);
		Thread.sleep(5000);
		clickOn(goToCartButton);
		return googlePhoneTitleAtProdPage;
	}
	
	public String addSamsungTVInProdPage() throws Exception {
		clickOn(samsungTvHeading);
		Thread.sleep(10000);
		String samsungTVTitleAtProdPage = extractText(samsungTvHeading);
		clickOn(addToCartTv);
		Thread.sleep(10000);
		return samsungTVTitleAtProdPage;
	}
	public static String samsungTvValidationText() {
			return extractText(samsungTvHeading);
	}
	
	public String addSonyWooferInProdPage() throws Exception {
		clickOn(sonyHomeAudioAtSonyProdPage);
		Thread.sleep(10000);
		String sonyWooferTitleAtProdPage = extractText(sonyWooferAtProdPage);
		clickOn(sonyWooferAtProdPage);
		clickOn(addToCartSonyWoofer);
		Thread.sleep(10000);
		return sonyWooferTitleAtProdPage;
	}




}
