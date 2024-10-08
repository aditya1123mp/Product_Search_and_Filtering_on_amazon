import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable

// Function to change the page number in the URL
def changePageNumber(String url, int newPageNumber) {
    return url.replaceAll(/page=\d+/, "page=${newPageNumber}")
}

// Original URL
String url = "https://www.amazon.in/s?k=smartphone&page=1"

// Convert the last page number from String to int
int lastPageNumber = GlobalVariable.last_page_number.toInteger()

// Loop through all pages from 1 to the last page
for (int i = 1; i <= lastPageNumber; i++) {
    // Update the URL with the current page number
    String updatedUrl = changePageNumber(url, i)
    
    // Print the updated URL to verify
    println("Navigating to page ${i}: " + updatedUrl)
    
    // Navigate to the updated URL
    WebUI.navigateToUrl(updatedUrl)
    
    // Add a delay to allow the page to load before moving to the next page
    WebUI.delay(3)
    
    // Additional actions can be added here if needed
}