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

public class FlightStatus extends BrowserStackTestNGTest {

    @Test
    public void flightStatus() throws Exception {
        
    	driver.get("http://www.delta.com/flightinfo/viewFlightStatusSetup");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("flightNumber"));
		driver.findElement(By.id("flightNumber")).sendKeys("2049");
		driver.findElement(By.id("viewFlightStatusByOrigin")).click();
	    	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.className("detailsOpenCloseText")));
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}		
		Assert.assertTrue(driver.getTitle().equals("Flight Status Results : Delta Air Lines"));

       
    }
}
