package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.Page;

public class FaceBookHomePage extends Page {
	
	@FindBy(id="email")
	public WebElement faceBookEmail;
	
	@FindBy(id="pass")
	public WebElement faceBookEmail;
			
	 @FindBy(xpath="//input[@value='Log In']")
     public WebElement faceBookSubmit;
	 
	 @FindBy(xpath="//input[@display='inline']")
     public WebElement faceBookPhoto;
	 
	 @FindBy(xpath="//div[@data-testid='status-attachment-mentions-input']")
     public WebElement faceBookMessage;
	 
	 @FindBy(xpath="//div[@class='_1se_']")
     public WebElement faceBookMyStories;
	 
	 @FindBy(xpath="//button[@type='submit']")
     public WebElement faceBookMessageSubmit;

     public static WebElement getMessageElement(String message) {
    	 
    	 return driver.findElement(By.xpath("//p[@@text(), '"+ messaage + "']"));
     }
     
     public static WebElement getPhotoElement() {
    	 
    	 return driver.findElement(By.xpath("//p[@@text(), '"+ messaage + "']"));
     }
     
     
	// Initializing the Page Objects:
	public FaceBookHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String facebookTitle() {
		return driver.getTitle();
	}
	
	public boolean googleSearchBoxisPresent() {
		try {
	        driver.findElement(By.xpath("//input[@title='Search']"));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	public static void tearDown() {
	driver.quit();
	}
	
}
