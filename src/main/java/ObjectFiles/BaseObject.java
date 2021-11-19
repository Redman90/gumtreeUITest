package ObjectFiles;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseObject {
	
	private static final int TIMEOUT = 5;

	protected WebDriver driver;
	private WebDriverWait wait;
	
	//class constructor
	public BaseObject(WebDriver driver) { 
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
			}
	
	public boolean isElementVisible(By element, String Desc)
	{
	   try
	   {
	      wait.until(ExpectedConditions.visibilityOfElementLocated(element)); 
	      return true;
	   }
	   catch (Exception e)
	       {
	      System.out.println("Element not visible: "+Desc);
	      return false;
	       }
	}
}
