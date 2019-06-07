package br.ce.fmilagres.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	private AndroidDriver<MobileElement> driver;

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();	
		desiredCapabilities.setCapability("udid", "192.168.227.102:5555");
	    desiredCapabilities.setCapability("deviceName", "Google_Nexus_6");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    
	    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	 	
	    Assert.assertEquals("4", el4.getText());	   
	}	
	
	@After
	  public void tearDown() {
	    driver.quit();
	}
}