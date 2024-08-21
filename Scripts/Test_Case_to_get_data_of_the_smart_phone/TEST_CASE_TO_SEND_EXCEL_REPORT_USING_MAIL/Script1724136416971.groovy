import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import javax.mail.*
import javax.mail.internet.*
import javax.activation.*
import java.util.Properties

// Define email properties
Properties props = new Properties()
props.put("mail.smtp.host", "smtp-mail.outlook.com") // Replace with your SMTP server
props.put("mail.smtp.port", "587") // Replace with your SMTP port
props.put("mail.smtp.auth", "true")
props.put("mail.smtp.starttls.enable", "true")

// Define email credentials
final String username = "aditya_T2_WORK@outlook.com" // Replace with your email
final String password = "Fiboo112358@@" // Replace with your email password

// Create session
Session session = Session.getInstance(props, new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password)
    }
})

try {
    // Create a default MimeMessage object
    Message message = new MimeMessage(session)

    // Set From: header field
    message.setFrom(new InternetAddress(username))

    // Set To: header field
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("aditya1993tue@gmail.com")) // Replace with recipient email

    // Set Subject: header field
    message.setSubject("Automation Test Results")

    // Create the message part
    BodyPart messageBodyPart = new MimeBodyPart()
    
    // Include global variable in the message body
    String emailBody = "Please find the attached test results from the latest automation run.\n\n"
    //emailBody += "Test Result: " + GlobalVariable.textboxvalue // Include the value of your global variable
    messageBodyPart.setText(emailBody)

    // Create a multipart message
    Multipart multipart = new MimeMultipart()
    multipart.addBodyPart(messageBodyPart)

    // Part two is the attachment
    messageBodyPart = new MimeBodyPart()
    String filename = "C:\\Users\\DELL\\OneDrive\\Desktop\\mail\\amazon_product_data.xlsx" // Replace with the path to your file
    DataSource source = new FileDataSource(filename)
    messageBodyPart.setDataHandler(new DataHandler(source))
    messageBodyPart.setFileName(filename)
    multipart.addBodyPart(messageBodyPart)

    // Send the complete message parts
    message.setContent(multipart)

    // Send message
    Transport.send(message)

    println("Email sent successfully!")

} catch (MessagingException e) {
    e.printStackTrace()
}