package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class FlightStatus extends BrowserStackTestNGTest {

    @Test
    public void flightStatus() throws Exception {
        
    	driver.get("http://www.delta.com/flightinfo/viewFlightStatusSetup");
		driver.findElement(By.id("flightNumber"));
		driver.findElement(By.id("flightNumber")).sendKeys("2049");
		driver.findElement(By.id("viewFlightStatusByOrigin")).click();
		

        Assert.assertEquals("Flight Status Results : Delta Air Lines", driver.getTitle());
    }
}
