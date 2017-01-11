package com.browserstack.suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class FlightSearch extends BrowserStackTestNGTest {

    @Test
    public void flightSearch() throws Exception {
    	
    	driver.get("http://www.delta.com");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.findElement(By.id("originCity"));
    	driver.findElement(By.id("originCity")).sendKeys("SFO");
    	driver.findElement(By.id("destinationCity"));
    	driver.findElement(By.id("destinationCity")).sendKeys("BOM");
    	driver.findElement(By.id("departureDate"));
    	driver.findElement(By.id("departureDate")).sendKeys("01/24/2017");
    	driver.findElement(By.id("returnDate"));
    	driver.findElement(By.id("returnDate")).sendKeys("01/30/2017");
    	driver.findElement(By.id("findFlightsSubmit")).click();
    	
     	WebDriverWait wait = new WebDriverWait(driver, 20);
     	try {
     		wait.until(ExpectedConditions.elementToBeClickable(By.className("searchBtnHolder")));
     	} catch(NoSuchElementException e) {
     		e.printStackTrace();
     	}
    	
    	
    	Assert.assertTrue(driver.getTitle().equals("Flight Results : Find & Book Airline Tickets : Delta Air Lines"));
    	

    }
   
}
