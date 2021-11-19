package ObjectFiles;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultObject extends BaseObject{
	/*
	 * This object stores methods needed to access elements in the search results page. 
	 */
	
	public SearchResultObject(WebDriver driver) {
		super(driver);
	}
	
	By lnkResult = By.cssSelector("a.user-ad-row-new-design");
	
	public void selectRandomResult () throws Exception
	{
		try
		{
			List<WebElement> results = driver.findElements(lnkResult);
			
			int maxResults = results.size();
			// get random number
			Random random = new Random();
			int randomResult = random.nextInt(maxResults);
			
			// select said random result
			results.get(randomResult).click();
			
		}catch (Exception e) {
			System.out.println("Error selecting random result. Exception is "+e.getMessage());
			throw(e);
		}
	}

}
