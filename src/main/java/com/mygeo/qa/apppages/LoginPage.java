package com.mygeo.qa.apppages;

import static com.mygeo.qa.base.MYGeoTestbase.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mygeo.qa.base.MYGeoTestbase;

public class LoginPage extends MYGeoTestbase {
	
	public LoginPage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//object-repository  
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement Loginbtn;
	
	@FindBy(xpath="//input[@id=\"account\"]")
	WebElement accountid;
	
	@FindBy(xpath="//input[@id=\"user\"]")
	WebElement userid;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement Loginpassword;
	
	@FindBy(xpath="//button[@type=\"button\"]")
	WebElement LoginBtnClick;
	
	@FindBy(xpath="//span[contains(text(),'admin')]")
	WebElement LogoutBtn;
	
	// Initialize the object 
	
	
	public void ValidateLoginbtn()
	{
		Loginbtn.click();
		Withoutenterinfo();
		
	}
	
	public void Withoutenterinfo()
	{
		LoginBtnClick.click();
	}

	public MygeoHomepage validatelogin(String accinfo,String userinfo,String password) throws InterruptedException
	{
		accountid.sendKeys(accinfo);
		userid.sendKeys(userinfo);
		Loginpassword.sendKeys(password);
		LoginBtnClick.click();
		return new MygeoHomepage();	
	}
	public void Validatelogout()
	{
		
		
		LogoutBtn.click();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))).click().build().perform();
		
		
		
	}

}
