package selenium.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Includes all the web elements found on the Gmail's index/home page
 * @author Vusi.Mngomezulu
 *
 */
public class GmailHomeScreen {
	private WebDriverWait waitWebDriver;
	private By inboxMessage = By.xpath("//*[@id=\":1\"]/div/div/div[6]");
	private By downloadAttachment = By.xpath("//div[@data-tooltip='Download']");
	private By attachmentElement = By.xpath("//span[text()='AttachmentExample.docx']");
	
	private By mailExistsElement = By.xpath("//table[role='grid']");
	
	//elements for sending mail
	private By composeElement = By.xpath("//div[text()='Compose']");
	private By toRecepient = By.xpath("//textarea[@name='to']");
	private By sendElement = By.xpath("//div[text()='Send']");
	private By subjectElement = By.xpath("//input[@name='subjectbox']");
	private By attachmentFile = By.xpath("//input[@name='Filedata']");
	private By messageSentElement = By.xpath("//span[text()='Message sent.']");
	
	public GmailHomeScreen(WebDriverWait webdriver) {
		this.waitWebDriver=webdriver;
	}
	
	/**
	 * Clicks on the inbox to view more details about the message 
	 */
	public void openMessageInbox() {
		waitWebDriver.until(ExpectedConditions.elementToBeClickable(inboxMessage)).click();
	}
	
	/**
	 * Clicks on the 'Download' link of the attachment
	 */
	public void downloadAttachment() {
		waitWebDriver.until(ExpectedConditions.elementToBeClickable(downloadAttachment)).click();
	}

	/**
	 * Checks to see if attachment is available on the message
	 * @return boolean
	 */
	public boolean attachmentExists() {
		boolean exists = waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(attachmentElement)).isDisplayed();
		return exists;
	}
	
	/**
	 * Clicks on the compose button
	 */
	public void composeNewMessage() {
		 waitWebDriver.until(ExpectedConditions.elementToBeClickable(composeElement)).click();
	}
	
	/**
	 * Enters the recipient's user name
	 * 	 * @param username
	 */
	public void forwardRecepient(String username) {
		 waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(toRecepient)).sendKeys(username);
	}
	
	/**
	 * Enters subject line of the message
	 * @param message
	 */
	public void forwardMessageBody(String message) {
		 waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(subjectElement)).sendKeys(message);
	} 
	
	/**
	 * Attaches a file to the message 
	 */
	public void attachFile() {
		 waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(attachmentFile)).sendKeys("./downloads/AttachmentExample.docx");
	} 
	
	/**
	 * Checks if 'Message sent' text is visible
	 * @return true if text appears
	 */
	public boolean messageSent() {
		boolean sent =  waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(messageSentElement)).isDisplayed();
		 return sent;
	} 
	
	/**
	 * Clicks send message button
	 */
	public void sendMessage() {
		 waitWebDriver.until(ExpectedConditions.elementToBeClickable(sendElement)).click();
	} 
	
	/**
	 * Checks if inbox has at least a single message
	 */
	public boolean checkInboxContainsMessage() {
		boolean inbox = waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(mailExistsElement)).isDisplayed();
		return inbox;
	
	} 
	/**
	 * Send's mail to the recipient mail
	 * @param recepient user name
	 * @param message subject
	 */
	public void sendMail(String recepient, String message) {
		this.composeNewMessage();
		this.forwardRecepient(recepient);
		this.forwardMessageBody(message);
		//this.attachFile();
		this.sendMessage();
		
	}

	

}
