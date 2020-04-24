package selenium.automation.constants;

/**
 * Constants class containing of read-only
 *  properties
 * @author Vusi.Mngomezulu
 *
 */
public class Constants {
	
	private static final String SENDER_MAIL_USERNAME = "your_sender_mail";
	private static final String SENDER_MAIL_PASSWORD = "sender_password";
	private static final String RECIPIENT_MAIL_USERNAME = "your_recipient_mail";
	private static final String RECIPIENT_MAIL_PASSWORD = "recipient_password";
	private static final String URL_UNDER_TEST = "https://gmail.com";
	
	/**
	 *  Sender's GMail user name
	 * @return
	 */
	public static String getSenderMailUsername() {
		return SENDER_MAIL_USERNAME;
	}
	
	/**
	 * Sender's GMail password
	 * @return
	 */
	public static String getSenderMailPassword() {
		return SENDER_MAIL_PASSWORD;
	}
	
	/**
	 * Recipient's GMail user name
	 * @return
	 */
	public static String getRecipientMailUsername() {
		return RECIPIENT_MAIL_USERNAME;
	}
	
	/**
	 *  Recipient's GMail password
	 * @return
	 */
	public static String getRecipientMailPassword() {
		return RECIPIENT_MAIL_PASSWORD;
	}
	
	/**
	 * Returns the url of the system under test
	 * @return the urlUnderTest
	 */
	public static String getUrlUnderTest() {
		return URL_UNDER_TEST;
	}
	
}
