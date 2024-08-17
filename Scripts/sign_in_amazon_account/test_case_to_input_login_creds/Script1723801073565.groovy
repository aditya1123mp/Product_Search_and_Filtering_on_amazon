import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType

'Refresh the current web page'
WebUI.refresh()

WebUI.delay(3)


// Store the email value in a variable
String new_Value_for_email_id = GlobalVariable.email_id_amazon

// Define the XPaths for both possible email input fields
String xpath_for_email_id1 = "//input[@id='ap_email_login']"
String xpath_for_email_id2 = "//input[@id='ap_email']"

// Locate the input field using JavaScript and set the value
WebUI.executeJavaScript(
	"""
    var element1 = document.evaluate("${xpath_for_email_id1}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    var element2 = document.evaluate("${xpath_for_email_id2}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    var element = element1 || element2;
    if (element) {
        element.value = '${new_Value_for_email_id}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(3)

//WebUI.click(findTestObject('sign_in_amazon_account/email_or_moblie_number_text_box'))

//WebUI.setText(findTestObject('sign_in_amazon_account/email_or_moblie_number_text_box'), GlobalVariable.email_id_amazon)

String xpath_for_continue_button = "//span[@id='continue' and contains(@class, 'a-button-primary')]//input[@type='submit' and contains(@class, 'a-button-input')]"
WebUI.click(new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_continue_button))

//WebUI.verifyElementPresent(findTestObject('sign_in_amazon_account/password_input_text_box'), 10)

//WebUI.click(findTestObject('sign_in_amazon_account/password_input_text_box'))

//WebUI.setText(findTestObject('sign_in_amazon_account/password_input_text_box'), GlobalVariable.email_id_password_amazon)

String new_Value_for_password_001 = GlobalVariable.email_id_password_amazon

// Define the XPath
String xpath_for_password_001 = "//input[@id='ap_password' and @type='password']"

// Locate the input field using the XPath
TestObject inputField_for_password_001 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_password_001)


WebUI.delay(2)  // Add a delay before setting the password

// Now set the password
WebUI.executeJavaScript(
    """
    var element = document.evaluate("$xpath_for_password_001", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.setAttribute('value', '$new_Value_for_password_001');
        element.value = '$new_Value_for_password_001';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
        console.log('Password set successfully');
    } else {
        console.log('Password field not found');
    }
    """, 
    null
)


WebUI.verifyElementPresent(findTestObject('Object Repository/sign_in_amazon_account/sign_in_button'), 10)

WebUI.click(findTestObject('Object Repository/sign_in_amazon_account/sign_in_button'))



