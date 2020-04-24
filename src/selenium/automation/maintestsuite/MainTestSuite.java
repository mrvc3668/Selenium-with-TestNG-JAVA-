package selenium.automation.maintestsuite;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import selenium.automation.pageobjects.*;
import selenium.automation.constants.*;


/**
 * Main Test Suite consisting of all the test cases
 * for automation using Selenium
 * @author Vusi.Mngomezulu
 *
 */
public class MainTestSuite {
	private WebDriver driver;
	private GmailLogin loginObject;
	private WebDriverWait waitWebDriver;
	private GmailHomeScreen gmailElements;

	
	/**
	 * Sets up the chrome driver relative location path before the test suite executes
	 */
	@BeforeSuite()
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	/**
	 * Initializes chrome driver and sets up a wait period before navigating to the url under test.
	 * Executes before test cases are ran
	 */
	@BeforeMethod()
	public void BeforeTestCase() {
		driver = new ChromeDriver();
		waitWebDriver = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(Constants.getUrlUnderTest());	
	}
	
	
	
	@Test(description="Checks and verifies that the correct given 'Sender' gmail username and password "+
	                   "leads to Gmail home page/index")
	public void VerifySenderGMailCredentials() {
		loginObject = new GmailLogin(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getSenderMailUsername(), Constants.getSenderMailPassword() );
		boolean expected = loginObject.searchBar();
		
		//If login successful then search bar should appear/exist
		Assert.assertTrue(expected);
	}
 
	@Test(description="Checks and verifies that the correct given 'Recipient' Gmail username and password" + 
			         "leads to Gmail home page/index")
	public void VerifyRecipientsGMailCredenetials() {
		loginObject = new GmailLogin(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getRecipientMailUsername(), Constants.getRecipientMailPassword() );
		boolean expected = loginObject.searchBar();
		
		//If login successful then search bar should appear/exist
		Assert.assertTrue(expected);
	}
	
	@Test(description="Verifies that the 'Sender' Gmail account has an inbox message with an attachment")
	public void VerifyAttachmentExistsOnTheMail() {
		loginObject = new GmailLogin(waitWebDriver);
		gmailElements = new GmailHomeScreen(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getSenderMailUsername(), Constants.getSenderMailPassword() );
		
		//Click on a message inbox
		gmailElements.openMessageInbox();
		
		//check to see if mail has an attachment
		Assert.assertTrue(gmailElements.attachmentExists());		
	}
	
	@Test(description="Checks to see if the Gmail message has been composed and sent to the recipient")
	public void VerifyEmailSent() {
		loginObject = new GmailLogin(waitWebDriver);
		gmailElements = new GmailHomeScreen(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getSenderMailUsername(), Constants.getSenderMailPassword() );
		//send mail with attachment
		gmailElements.sendMail(Constants.getRecipientMailUsername() + "@gmail.com", "Test message send");
	
		//Verify that e-mail has been sent
		Assert.assertTrue(gmailElements.messageSent());
	}
	
	
	@Test(description="Verifies that the message sent has been received by the recipient")
	public void VerifyEmailReceived() {
		loginObject = new GmailLogin(waitWebDriver);
		gmailElements = new GmailHomeScreen(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getRecipientMailUsername(), Constants.getRecipientMailPassword());
		
		//check message exists
		Assert.assertTrue(gmailElements.checkInboxContainsMessage());
		
	}
	
	@Test(description="Verifies that the message received has an attachment")
	public void VerifyEmailReceivedWithAttachment() {
		loginObject = new GmailLogin(waitWebDriver);
		gmailElements = new GmailHomeScreen(waitWebDriver);
		
		//login
		loginObject.loginToGMail(Constants.getRecipientMailUsername(), Constants.getRecipientMailPassword());
		
		//verify attachment exists
		Assert.assertTrue(gmailElements.attachmentExists());
	}
	
	/**
	 * Terminates/closes the chrome driver to ensure resources are not wasted.
	 * Executes after test cases are ran
	 */
	@AfterMethod()
	public void afterTestCase() {
		driver.close();
	}

}
