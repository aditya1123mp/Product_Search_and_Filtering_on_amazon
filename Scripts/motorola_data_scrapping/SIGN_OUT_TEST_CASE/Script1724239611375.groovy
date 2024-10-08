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

WebUI.click(findTestObject('sign_in_amazon_account/amazon_logo'))

//WebUI.delay(2)

//WebUI.click(findTestObject('sign_in_amazon_account/account_button'))

//WebUI.mouseOver(findTestObject('sign_in_amazon_account/account_button'), 'font-size')

//WebUI.click(findTestObject('Object Repository/sign_in_amazon_account/sign_out'))
// Hover over the account list element
TestObject accountList = findTestObject('sign_in_amazon_account/account_button')
WebUI.mouseOver(accountList)

// Wait for the sign-out option to appear
WebUI.delay(2) // Adjust the delay as needed

// Click on the sign-out option
TestObject signOut = findTestObject('Object Repository/sign_in_amazon_account/sign_out')
WebUI.click(signOut)