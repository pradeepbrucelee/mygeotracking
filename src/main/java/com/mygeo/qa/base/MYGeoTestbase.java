package com.mygeo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MYGeoTestbase {
	public static Properties prop;
	public static FileInputStream ip;
	public static WebDriver driver;
	public MYGeoTestbase(){
		try {
			prop = new Properties();
			ip = new FileInputStream("C:\\Automation mygeotracking\\workspace\\Mygeotracking\\src\\main\\java\\com\\mygeo\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
	public  void initialization() throws InterruptedException{
 		String browserName = prop.getProperty("browser");
 		
 		if(browserName.equals("ff")){
 			System.setProperty("webdriver.gecko.driver", "C:\\Automation mygeotracking\\geckodriver.exe");	
 			driver = new FirefoxDriver();
 		}
 		else if(browserName.equals("chrome")){
 			System.setProperty("webdriver.chrome.driver", "C://Automation mygeotracking//chromedriver.exe");	
 			driver = new ChromeDriver(); 
 			Thread.sleep(2000);
 		} 
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
 		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		
 		String Mygeomainurl = prop.getProperty("url");
 		driver.get(Mygeomainurl);
 		
    }
}
