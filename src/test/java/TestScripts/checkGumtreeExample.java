package TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import ObjectFiles.AdDetailsObject;
import ObjectFiles.HeaderObject;
import ObjectFiles.SearchResultObject;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class checkGumtreeExample {
/*
 * This test does the following:
 * Visit gumtree.com.au
	Search for "Sennheiser Headphones"
	In Category "Electronics & Computer"
	In "Sydney Region, NSW"
	Within 20km
	In the search results, open a random result
	Verify the ad details page opens
	Verify a numeric ad id is displayed in the breadcrumbs
	Verify at least one similar ad is displayed in the page  
 */
	
@Test
  public void loadGumtree() throws Exception {

      driver.get("http://www.gumtree.com.au");
	  
	  HeaderObject headerObject = new HeaderObject(driver);
	  SearchResultObject searchResultObject = new SearchResultObject(driver);
	  AdDetailsObject adDetailsObject = new AdDetailsObject(driver);
	  
	  headerObject.closePopup();
	  headerObject.selectCategory("20045");
	  headerObject.enterSearchTerm("Sennheiser Headphones");
	  headerObject.setSearchArea("Sydney Region, NSW");
	  headerObject.setSearchRadius20k();
	  headerObject.clickSearch();
	  
	  // now we have our search results, click a random one
	  searchResultObject.selectRandomResult();
	  
	  // verify similar ads present
	  boolean booleanFlag;
	  booleanFlag = adDetailsObject.verifySimilarAds();
	  AssertJUnit.assertEquals(booleanFlag, true);
	  
	  // verify numeric ad ID in breadcrumbs
	  booleanFlag= adDetailsObject.verifyAdID();
	  AssertJUnit.assertEquals(booleanFlag, true);

  }
  
  private WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Quitting Selenium");
	  driver.quit();
  }

}
