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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

// Check if the element exists
boolean isElementPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/TO_GET_DATA_OF_SMARTPHONES_BASED_ON_BRANDS_FILTER/pagination_xpath'), 10)

if (isElementPresent) {
    // Run the test case for scraping Samsung smartphone data
    WebUI.callTestCase(findTestCase('TO_GET_DATA_OF_SMARTPHONES_BASED_ON_BRANDS_FILTER_brand_itel/TEST_CASE_TO_SCRAPE_DATA_FOR_SAMSUNG_SMARTPHONE'), 
        [:], FailureHandling.STOP_ON_FAILURE) // Run the alternative test case where the page does not change
} else {
    WebUI.callTestCase(findTestCase('TO_GET_DATA_OF_SMARTPHONES_BASED_ON_BRANDS_FILTER_brand_itel/TEST_CASE_FOR_SCRAPPING_DATA_FOR_SINGLE_PAGE'), 
    [:], FailureHandling.STOP_ON_FAILURE)
}



