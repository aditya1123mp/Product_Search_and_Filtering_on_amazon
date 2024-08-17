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


// Wait for the modal to appear
WebUI.waitForElementVisible(findTestObject('Object Repository/to_delete_addresee/selecting_new_addresee_window'), 10)

// Click on the select new addressee window
WebUI.click(findTestObject('Object Repository/to_delete_addresee/selecting_new_addresee_window'))

// Click on the remove button
WebUI.click(findTestObject('Object Repository/to_delete_addresee/remove_button'))

// Wait for the Full Name element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/to_delete_addresee/name'), 10)

// Get the full name
String fullName = WebUI.getText(findTestObject('Object Repository/to_delete_addresee/name'))
println('Full Name: ' + fullName)

// Get the first address line
String addressLineOne = WebUI.getText(findTestObject('Object Repository/to_delete_addresee/house_number'))
println('Address Line One: ' + addressLineOne)

// Get the second address line
String addressLineTwo = WebUI.getText(findTestObject('Object Repository/to_delete_addresee/road_name'))
println('Address Line Two: ' + addressLineTwo)

// Define the XPath for the phone number element
//String phoneNumberXPath = '//div[@id=\'a-popover-content-3\']//span[@id=\'address-ui-widgets-PhoneNumber\']'

// Wait for the phone number element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/to_delete_addresee/phone_number'), 10)

// Get the full text that includes "Phone number: 6306466515"
String phoneNumberText = WebUI.getText(findTestObject('Object Repository/to_delete_addresee/phone_number'))

// Extract only the phone number using a substring or regex
String phoneNumber = phoneNumberText.replaceAll('[^0-9]', '')

// Print the extracted phone number
println('Phone Number: ' + phoneNumber)

// Click on the Yes button to confirm deletion
WebUI.click(findTestObject('Object Repository/to_delete_addresee/yes_button'))