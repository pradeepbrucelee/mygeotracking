package com.mygeo.qa.test;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mygeo.qa.apppages.LoginPage;
import com.mygeo.qa.apppages.MainLoginPage;
import com.mygeo.qa.apppages.MygeoHomepage;
import com.mygeo.qa.base.MYGeoTestbase;

public class LoginTest extends MYGeoTestbase{
	public  LoginPage login;
	MygeoHomepage homepage;
	
	public LoginTest()
	{
		super();
	}	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		initialization();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginBtnTest()
	{
		 String Loginbtntitel=driver.getTitle();
		 Assert.assertEquals(Loginbtntitel, "myGeoTracking | Mobile Workforce Management | Load Tracking","login btn test case failed");
		 System.out.println("Loging btn test pass");
		 login.ValidateLoginbtn();
	}
	@Test(priority=2,dependsOnMethods="LoginBtnTest")
	public void WhitoutinfoTest() throws InterruptedException
	{
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String usertext = alert.getText();
		System.out.println(usertext);
		alert.accept();
		Assert.assertEquals(usertext, "Please enter the account.","user text box not pass");
	}
		
	@Test(priority=3,dependsOnMethods="LoginBtnTest")
	public void MainloginpageTest() throws InterruptedException
	{
		//login.ValidateLoginbtn();
		Thread.sleep(3000);
		homepage = login.validatelogin(prop.getProperty("accountid"),prop.getProperty("userid"),prop.getProperty("password"));
	}
	@Test(priority=4,dependsOnMethods="MainloginpageTest")
	public void MygeoLogoutTest()
	{
		String MainTitel = driver.getTitle();
		Assert.assertEquals(MainTitel, "myGeoTracking Login","logout test failed");
		System.out.println("Logout pass"+MainTitel);
	}
		
	@AfterTest
	public void tearDown() 
	{
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
