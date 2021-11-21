package ObjectFiles;

import org.openqa.selenium.*;

public class HeaderObject extends BaseObject {
	/*
	 * This object stores methods needed to access elements in the header object.
	 * That is everything under class=header
	 */
	
	public HeaderObject(WebDriver driver)
	{
		super(driver);
	}
	
	By btnCategoryChevron = By.cssSelector("#categoryId-wrp > svg.svg.svg-chevron.j-selectbox__arrow");
	By categoryElectronicsComputing = By.cssSelector("#categoryId-wrp-option-20045");
	By txtSearchTerm = By.cssSelector("#search-query");
	By txtSearchArea = By.cssSelector("#search-area");
	By lnkRadius = By.cssSelector("#srch-radius-input");
	By radiusOption = By.cssSelector("#srch-radius-wrp-option-20");
	By btnSearch = By.cssSelector(".header__search-button");
	By lnkClosePopup = By.cssSelector("#modal-close-button-0");
	
	public void selectCategory(String category) throws Exception
	{
		try
		{
			String selector = "#categoryId-wrp-option-"+category;
			By categorySelector = By.cssSelector(selector);
			// click chevron first
			driver.findElement(btnCategoryChevron).click();
			
			// select electronics and computing
			driver.findElement(categorySelector).click();
			
		} catch (Exception e) {
			System.out.println("Error selecting category for "+category+" Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public void enterSearchTerm(String searchItem) throws Exception
	{
		try
		{
			driver.findElement(txtSearchTerm).sendKeys(searchItem);
			
		} catch (Exception e) {
			System.out.println("Error entering text for "+searchItem+" Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public void setSearchArea(String searchArea) throws Exception
	{
		try
		{
			driver.findElement(txtSearchArea).sendKeys(searchArea);
			
		}catch (Exception e) {
			System.out.println("Error entering text for "+searchArea+" Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public void setSearchRadius20k() throws Exception
	{
		try
		{
			//first click the radius chevron
			driver.findElement(lnkRadius).click();
			
			// Then enter radius text
			driver.findElement(radiusOption).click();
			
		}catch (Exception e) {
			System.out.println("Error clicking 20k search radius. Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public void clickSearch() throws Exception
	{
		try
		{
			driver.findElement(btnSearch).click();
			
		}catch (Exception e) {
			System.out.println("Error clicking search button. Exception is "+e.getMessage());
			throw(e);
		}
	}
	
	public void closePopup () throws Exception
	{
		try
		{
			if (this.isElementVisible(lnkClosePopup, "Popup close button"))
			{
				driver.findElement(lnkClosePopup).click();
			}
			
		}catch (Exception e) {
			System.out.println("Error closing popup. Exception is "+e.getMessage());
			throw(e);
		}
	}
	
}
