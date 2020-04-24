package selenium.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Page Object representing the gmail's login page
 * 
 * @author Vusi.Mngomezulu
 *
 */
public class GmailLogin {
	private WebDriverWait waitWebDriver;
	private By username = By.xpath("//*[@id=\"identifierId\"]");
	private By usernextbutton = By.id("identifierNext");
	private By password = By.name("password");
	private By signin = By.id("passwordNext");
	private By gmailIcon = By.xpath("//*[@id=\"gs_lc50\"]/input[1]");

	//Pass in the driver and driver wait props
	public GmailLogin(WebDriverWait waitWebDriver) {
		this.waitWebDriver = waitWebDriver;
	}

	/**
	 * Inputs user text to Gmail user name input box
	 * @param user
	 */
	public void setUsername(String user) {
		waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
	}

	/**
	 * Inputs password to Gmail password input box
	 * @param pass
	 */
	public void setPassword(String pass) {
		waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	}

	/**
	 * Clicks next button after user name input
	 */
	public void usernameNextButton() {
		waitWebDriver.until(ExpectedConditions.elementToBeClickable(usernextbutton)).click();
	}
	
	/**
	 * Clicks next button after password input
	 */
	public void passwordNextButton() {
		waitWebDriver.until(ExpectedConditions.elementToBeClickable(signin)).click();
	}

	/**
	 * Returns true/false if search bar is found on Gmail's current page
	 * @return
	 */
	public boolean searchBar() {
		boolean exists = waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(gmailIcon)).isDisplayed();
		return exists;
	}
	
	/**
	 * Logs in to Gmail using provided user name and password
	 * @param strUserName
	 * @param strPasword
	 */
	public void loginToGMail(String strUserName,String strPasword){
        this.setUsername(strUserName);
        this.usernameNextButton();
        this.setPassword(strPasword);
        this.passwordNextButton();
    }
	
	

}
