package com.browserstack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
    	
    	driver.get("http://www.delta.com");

    	driver.findElement(By.id("originCity"));
    	driver.findElement(By.id("originCity")).sendKeys("SFO");

    	driver.findElement(By.id("destinationCity"));
    	driver.findElement(By.id("destinationCity")).sendKeys("BOM");

    	driver.findElement(By.id("departureDate"));
    	driver.findElement(By.id("departureDate")).sendKeys("01/24/2017");

    	driver.findElement(By.id("returnDate"));
    	driver.findElement(By.id("returnDate")).sendKeys("01/30/2017");

    	driver.findElement(By.id("findFlightsSubmit")).click();

		Thread.sleep(10000);
		
		Assert.assertEquals("Google Search", driver.getTitle());

        Assert.assertEquals("BrowserStack - Google Search", driver.getTitle());

        Assert.assertTrue(driver.getPageSource().contains("Up and running"));
    }
}
