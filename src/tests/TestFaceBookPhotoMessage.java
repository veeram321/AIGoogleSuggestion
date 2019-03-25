package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.FaceBookHomePage;
import pages.Page;


public class TestFaceBookPhotoMessage extends Page{
	
	FaceBookHomePage faceBookHomePage;
	
	public TestFaceBookPhotoMessage() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		faceBookHomePage = new FaceBookHomePage() ;;
	}
	
	@Test(priority=0)
	public void verifyFacebookHomePageLogin() {
		
		Assert.assertEquals(faceBookHomePage.facebookTitle(),"Facebook – log in or sign up");
		faceBookHomePage.faceBookEmail.clear();
		faceBookHomePage.faceBookEmail.sendKeys(facebookLogin);
		faceBookHomePage.faceBookPassword.clear();
		faceBookHomePage.faceBookPassword.sendKeys(facebookPassword);
		faceBookHomePage.faceBookSubmit.click();
		Assert.assertEquals(faceBookHomePage.facebookTitle(),"Facebook");
	}
	
	@Test(priority=1)
	public void verifyFacebookmessagePhoto() throws InterruptedException {
		faceBookHomePage.faceBookMEnabler.click();
		faceBookHomePage.faceBookMessage.sendKeys(facebookMessage);
		faceBookHomePage.faceBookPhoto.sendKeys(photoPath);
	    Thread.sleep(30000);
		faceBookHomePage.faceBookMyStories.click();
		faceBookHomePage.faceBookMessageSubmit.click();
	    Thread.sleep(30000);
		faceBookHomePage.faceBookStoryHome.click();
	    Thread.sleep(30000);
	    Assert.assertTrue(faceBookHomePage.isMessageElementPresent(facebookMessage),"Message not present in my stories of Facebook");
	    Assert.assertTrue(faceBookHomePage.isPhotoElementPresent(facebookMessage),"Photo not present in my stories of Facebook");
	}
	
	@AfterClass
	public void tearDown(){
		FaceBookHomePage.tearDown();
	}
}


