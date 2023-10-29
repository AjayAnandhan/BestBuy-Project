package com.bestbuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.base.BaseClass;

public class CheckOutPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='fld-e']")
	WebElement emailSignInAtCheckOut;
	
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement passSignInAtCheckOut;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement submitSigInAtCheckOut;
	
	@FindBy(xpath="//input[@id='user.emailAddress']")
	WebElement emailAtCheckOut;
	
	@FindBy(xpath="//input[@id='user.phone']")
	WebElement mobileNumAtCheckOut;
	
	@FindBy(xpath="//input[@id='text-updates']")
	WebElement textUpdateCheckBox;
	
	@FindBy(xpath="//span[text()='Continue to Payment Information']")
	WebElement continueToPayement;
	
	@FindBy(xpath="//input[@id='number']")
	WebElement debitCardNumber;
	
	@FindBy(id="expMonth")
	WebElement expMonth;
	
	@FindBy(id="expYear")
	WebElement expYear;
	
	@FindBy(id="cvv")
	WebElement cvv;
	
	@FindBy(id="save-to-profile")
	WebElement saveToProfile;
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(xpath="//button[text()='Hide Suggestions']")
	WebElement hideSuggestion;
	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(id="//button[text()='Edit this address']")
	WebElement editThisAddress;
	
	@FindBy(id="//button[text()='Add a new address']")
	WebElement addNewAddress;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement postalCode;
	
	@FindBy(xpath="//span[text()='Place Your Order']")
	WebElement placeYourOrder;
	
	@FindBy(xpath="//p[text()='Please enter a valid card number.']")
	WebElement inValidCardMsg;
	
	@FindBy(xpath="//p[text()='Please enter a valid card number.']")
	WebElement sryMsgAfterSignInB4CheckOut;
	
	@FindBy(xpath="//span[text()='Sorry, there was a problem. Please try that again.']")
	WebElement sryMsgWitOutSignInB4CheckOut;
	
	@FindBy(xpath = "//span[text()='Thanks for your order!']")
	WebElement orderMsg;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void contactInfoAtCheckOut() throws Exception {
		type(emailSignInAtCheckOut, readProperty("email"));
		type(passSignInAtCheckOut, readProperty("password"));
		clickOn(submitSigInAtCheckOut);
		clickOn(continueToPayement);
	}
	public void enterDetailsOnCheckOut() throws Exception {
		type(debitCardNumber, readProperty("cardNum"));
		selectFromDropDown(expMonth, readProperty("month"));
		selectFromDropDown(expYear, readProperty("year"));
		type(cvv, readProperty("cvv"));
		type(firstName, readProperty("fname"));
		type(lastName, readProperty("lname"));
		type(address, readProperty("streetAddress"));
		type(city, readProperty("city"));
		selectFromDropDown(state, readProperty("state"));
		type(postalCode, readProperty("zipCode"));
		clickOn(placeYourOrder);
	}
	
	public String validateOrder() {
		String msg = extractText(orderMsg);
		return msg;
	}
}
