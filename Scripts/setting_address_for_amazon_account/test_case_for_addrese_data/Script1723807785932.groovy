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
import com.kms.katalon.core.testobject.ConditionType


WebUI.verifyElementPresent(findTestObject('Object Repository/data_for_address/country_dropdown'),10)

WebUI.click(findTestObject('Object Repository/data_for_address/country_dropdown'))

//WebUI.verifyElementPresent(findTestObject('Object Repository/setting_address_for_amazon_account/add_new_addresse_link'), 10)

WebUI.click(findTestObject('Object Repository/data_for_address/dropdown_option_india'))

//WebUI.click(findTestObject('Object Repository/setting_address_for_amazon_account/add_addresee_icon'))

//*************************************************** FOR FULL USER NAME ***************************************************//

// Generate the random string
String randomString_001 = RandomStringUtils.randomNumeric(6)
String name_value = "First_name" + randomString_001 + "Last_name"

// Define the XPath
String xpath_for_full_name = "//input[@id='address-ui-widgets-enterAddressFullName']"

// Locate the input field using the XPath
TestObject inputField_001 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_full_name)

// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_full_name}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${name_value}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** FOR MOBILE NUMBER ***************************************************//

// Generate the random string
String randomString_002 = RandomStringUtils.randomNumeric(10)
String mobile_number_value = randomString_002

// Define the XPath
String xpath_for_mobile_number = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']"

// Locate the input field using the XPath
TestObject inputField_002 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_mobile_number)

// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_mobile_number}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${mobile_number_value}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** FOR PIN CODE ***************************************************//

// Generate the random string for password
//String randomString_for_password_001 = RandomStringUtils.randomNumeric(4)
String value_for_pincode = GlobalVariable.pincode

// Define the XPath
String xpath_for_pincode = "//input[@id='address-ui-widgets-enterAddressPostalCode']"

// Locate the input field using the XPath
TestObject inputField_003 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_pincode)


// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_pincode}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${value_for_pincode}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** FOR HOUSE NUMBER ***************************************************//

// Generate the random string
String randomString_004 = RandomStringUtils.randomNumeric(2)
String house_number_value = randomString_004

// Define the XPath
String xpath_for_house_number = "//input[@id='address-ui-widgets-enterAddressLine1']"

// Locate the input field using the XPath
TestObject inputField_004 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_house_number)

// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_house_number}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${house_number_value}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** FOR AREA ***************************************************//

// Generate the random string for password
//String randomString_for_password_001 = RandomStringUtils.randomNumeric(4)
String value_for_area = "mall godam road"

// Define the XPath
String xpath_for_area = "//input[@id='address-ui-widgets-enterAddressLine2']"

// Locate the input field using the XPath
TestObject inputField_005 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_area)


// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_area}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${value_for_area}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** LANDMARK ***************************************************//

// Generate the random string for password
//String randomString_for_password_001 = RandomStringUtils.randomNumeric(4)
String value_for_landmark = "dainik jagran headoffice"

// Define the XPath
String xpath_for_landmark = "//input[@id='address-ui-widgets-landmark']"

// Locate the input field using the XPath
TestObject inputField_006 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_landmark)


// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_landmark}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${value_for_landmark}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** TOWN AND CITY ***************************************************//

// Generate the random string for password
//String randomString_for_password_001 = RandomStringUtils.randomNumeric(4)
String value_for_city = "etawah"

// Define the XPath
String xpath_for_city = "//input[@id='address-ui-widgets-enterAddressCity']"

// Locate the input field using the XPath
TestObject inputField_007 = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_for_city)


// Use JavaScript to set the value and trigger the input event
WebUI.executeJavaScript(
	"""
    var element = document.evaluate("${xpath_for_city}", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '${value_for_city}';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
    }
    """, 
	null
)

WebUI.delay(1)

//*************************************************** STATE DROPDOWN ***************************************************//

WebUI.click(findTestObject('Object Repository/data_for_address/state_dropdown'))

WebUI.click(findTestObject('Object Repository/data_for_address/state_dropdwon_option'))

WebUI.click(findTestObject('Object Repository/data_for_address/add_addresse_button'))

