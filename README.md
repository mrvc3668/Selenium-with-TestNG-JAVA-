# java_selenium_testNG
JAVA Selenium with TestNG framework

Project Setup/Requirements:
•	Google chrome web browser version 80.
•	Windows 10 Enterprise
•	Eclipse neon v2.2
•	TestNG Framework library installed in Eclipse
•	Maven dependency manager for managing selenium client library/dependencies
•	Two (2) Gmail accounts were temporarily created for sending and receiving mail messages(Sender & Recipient)

Project directories
•	downloads: Contains downloaded e-mail attachments
•	driver: Web driver used by selenium to perform automation
•	src: Contains java source code files
•	target: Contains compiled java files(classes) by Maven
•	test-output: Html reports created by the TestNG testing framework  

Test cases:
•	VerifySenderGMailCredentials
Checks and verifies that the correct given 'Sender' Gmail username and password leads to Gmail home page/index
•	VerifyRecipientsGMailCredenetials
Checks and verifies that the correct given 'Recipient' Gmail username and password leads to Gmail home page/index
•	VerifyAttachmentExistsOnTheMail
Verifies that the 'Sender' Gmail account has an inbox message with an attachment
•	VerifyEmailSent
Checks to see if the Gmail message has been composed and sent to the recipient
•	VerifyEmailReceived
Verifies that the message sent has been received by the recipient
•	VerifyEmailReceivedWithAttachment
Verifies that the message received has an attachment
Test Execution:
•	Open the project in Eclipse then click run as > TestNG suite.
This will execute/run the main test suite 
•	Once the tests execution is complete, navigate to the folder test-output:
•	Inside test-output go to the folder Main Gmail Suite, click on Default test.html
•	The html summary report/page will be visible showing all information related to the tests executed and their test result. 





