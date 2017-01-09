package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class HotelSearch extends BrowserStackTestNGTest {

    @Test
    public void hotelSearch() throws Exception {
       
    	driver.get("https://www.delta.com/merch/searchHotelAction.action");
       
    	driver.findElement(By.id("hotelLocation"));
		driver.findElement(By.id("hotelLocation")).sendKeys("BOM");
		driver.findElement(By.id("hotelCheckInDate"));
    	driver.findElement(By.id("hotelCheckInDate")).sendKeys("01/24/2017");
    	driver.findElement(By.id("hotelCheckOutDate"));
    	driver.findElement(By.id("hotelCheckOutDate")).sendKeys("01/30/2017");
    	
    	/* USING DEFUALT AS 1
    	 * driver.findElement(By.id("hotelNumberOfRooms-required"));
    	driver.findElement(By.id("hotelNumberOfRooms-required")).sendKeys("2");
    	
    	driver.findElement(By.id("hotelNumberOfRooms-required"));
    	driver.findElement(By.id("hotelNumberOfRooms-required")).sendKeys("2");
    	*
    	**/

        Assert.assertEquals("Hotel Search Results : Delta Air Lines", driver.getTitle());
    }
}
