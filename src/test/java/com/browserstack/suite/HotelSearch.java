package com.browserstack.suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class HotelSearch extends BrowserStackTestNGTest {

    @Test
    public void hotelSearch1() throws Exception {
       
    	driver.get("https://www.delta.com/merch/searchHotelAction.action");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.findElement(By.id("hotelLocation"));
		driver.findElement(By.id("hotelLocation")).sendKeys("Mumbai, India, IN (BOM)");
		driver.findElement(By.id("hotelCheckInDate"));
    	driver.findElement(By.id("hotelCheckInDate")).sendKeys("01/24/2017");
    	driver.findElement(By.id("hotelCheckOutDate"));
    	driver.findElement(By.id("hotelCheckOutDate")).sendKeys("01/30/2017");
  	
    	driver.findElement(By.id("btnSubmit")).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	
    	try {
    		wait.until(ExpectedConditions.elementToBeClickable(By.id("modifySearchDisplay")));
    	} catch(NoSuchElementException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	Assert.assertTrue(driver.getTitle().equals("Hotel Search Results : Delta Air Lines"));

       
    }
}
