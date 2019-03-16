package tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomeSearchAutoPage;
import pages.Page;


public class TestAutoSearchComplete extends Page{
	
	HomeSearchAutoPage homeSearchAutoPage ;
	
	public TestAutoSearchComplete() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		homeSearchAutoPage = new HomeSearchAutoPage() ;;
	}
	
	@Test(priority=0)
	public void verifyGoogleHomePage() {
		
		Assert.assertEquals(homeSearchAutoPage.googleTitle(),"Google");
		Assert.assertTrue(homeSearchAutoPage.googleSearchBoxisPresent(), "The Search field in Google does not exists");
	}
	
	@Test(priority=1)
	public void verifyGoogleAutoSuggestion() {
		
		homeSearchAutoPage.googleSearchAuto.clear();
		homeSearchAutoPage.googleSearchAuto.sendKeys(searchString);

		List<WebElement> homeSearchAutoList =  homeSearchAutoPage.getGoogleSearchAutoList();	
		
		for(int i = 0 ;i < homeSearchAutoList.size();i++)
		{		
			Assert.assertTrue(homeSearchAutoList.get(i).getText().contains(searchString), "The google suggestion does not have search string in the suggestion");
		}
	}
	
	@AfterClass
	public void tearDown(){
		HomeSearchAutoPage.tearDown();
	}
}


