package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.base.BaseClass;

public class SignInPage extends BaseClass{
	
	@FindBy(id="fld-e")
	WebElement email;
	
	@FindBy(id="fld-p1")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[text()='Visit our homepage']")
	WebElement goToHomePage;
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String signInFunctionality(String email, String password,String textXpath) throws Exception {
		type(this.email, email);
		type(this.password, password);
		clickOn(signInButton);
		String actMsg=driver.findElement(By.xpath(""+textXpath+"")).getText();
		return actMsg;
	}
}
