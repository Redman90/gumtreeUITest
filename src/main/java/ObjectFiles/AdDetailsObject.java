package ObjectFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdDetailsObject extends BaseObject {

	public AdDetailsObject(WebDriver driver) {
		super(driver);
	}
	
	By lstOtherAds = By.cssSelector(".vip-slidable-ads__item-wrapper");
	By txtBreadcrumbSummary = By.cssSelector(".breadcrumbs__summary");

	public boolean verifySimilarAds() throws Exception
	{
		try
		{
			List<WebElement> ads = driver.findElements(lstOtherAds);
			if(ads.size()>0) {
				System.out.println("Other ads present in ad results page");
			  return true;
			} else 
			{
				System.out.println("Other ads not present in ad results page");
				return false;
			}
		}catch (Exception e) {
			System.out.println("Error getting similar ads. Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public boolean verifyAdID() throws Exception
	{
		try
		{
			String id = driver.findElement(txtBreadcrumbSummary).getText();
			String[]splits = id.split(" ");
			Integer length = splits.length-1;
			// the last split should be the integer value
			String lastSplit = splits[length];
			// now convert to integer
			System.out.println("Ad ID is "+lastSplit);
			Integer i=Integer.parseInt(lastSplit);
			if(i instanceof Integer) {
				return true;
			} else {
				return false;
			}
			
			
		}catch (Exception e) {
			System.out.println("Error verifying ad ID. Exception is "+e.getMessage());
			throw(e);
		} 
	}
	
}


