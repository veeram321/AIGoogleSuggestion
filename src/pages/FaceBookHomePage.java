package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.Page;

public class FaceBookHomePage extends Page {
	
	@FindBy(id="email")
	public WebElement faceBookEmail;
	
	@FindBy(id="pass")
	public WebElement faceBookPassword;
			
	 @FindBy(xpath="//input[@value='Log In']")
     public WebElement faceBookSubmit;
	 
	 @FindBy(xpath="//input[@type='file']")
     public WebElement faceBookPhoto;
	 
	 @FindBy(xpath="//textArea[contains(@title,'Write something here')]")
     public WebElement faceBookMEnabler;
	 
	 @FindBy(xpath="//div[contains(text(),'Write something here')]/../../div[2]/div")
     public WebElement faceBookMessage;
	 
	 @FindBy(xpath="//li[@data-destination='STORIES']/div/div[1]/div")
     public WebElement faceBookMyStories;
	 
	 @FindBy(xpath="//button[@type='submit']/span[contains(text(),'Share')]")
     public WebElement faceBookMessageSubmit;

	 @FindBy(xpath="//a[contains(text(),'Home')]")
     public WebElement faceBookStoryHome;
	 
	// Initializing the Page Objects:
	public FaceBookHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String facebookTitle() {
		return driver.getTitle();
	}
	 
     public boolean isMessageElementPresent(String message) {
    	 try {
    		 driver.findElement(By.xpath("//p[contains(text(), '"+ message + "')]"));
 	    } catch (NoSuchElementException e) {
 	        return false;
 	    }
 	    return true;
     }
     
     public boolean isPhotoElementPresent(String message) {
    	 try {
    		 driver.findElement(By.xpath("//p[contains(text(), '"+ message + "')]/../../div[3]"));
 	    } catch (NoSuchElementException e) {
 	        return false;
 	    }
 	    return true;
     }
     	
	public static void tearDown() {
	driver.quit();
	}
	
}
