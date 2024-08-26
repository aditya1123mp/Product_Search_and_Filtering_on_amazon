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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.JavascriptExecutor

// Call the test cases to navigate to the page and log in
WebUI.callTestCase(findTestCase('sign_in_amazon_account/accessing_amazon_website'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('sign_in_amazon_account/test_case_to_input_login_creds'), [:], FailureHandling.STOP_ON_FAILURE)

// Set search term and submit search
String name_value = 'SmartPhone'
String xpath_for_full_name = '//input[@id=\'twotabsearchtextbox\']'
TestObject inputField_001 = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_for_full_name)

WebUI.executeJavaScript("""
    var element = document.evaluate("$xpath_for_full_name", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
        element.value = '$name_value';
        var event = new Event('input', { bubbles: true });
        element.dispatchEvent(event);
   }
    """, 
	null
)
WebUI.delay(1)
WebUI.click(findTestObject('To_get_data_of_the_smart_phone/submit_button'))

// Navigate and select brand filters
WebUI.click(findTestObject('Object Repository/TO_GET_DATA_OF_SMARTPHONES_BASED_ON_BRANDS_FILTER/see_more_brands'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/TO_GET_DATA_OF_SMARTPHONES_BASED_ON_BRANDS_FILTER/for_itel'))

// Wait for the price elements to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/price_slider/lowewr_bound_range'), 10)
WebUI.waitForElementVisible(findTestObject('Object Repository/price_slider/upper_bound_range'), 10)

// Locate the slider element
WebElement slider = DriverFactory.getWebDriver().findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_upper-bound-slider']"))

// Define the target value for the slider
int targetValue = 5000

// Use JavaScript to move the slider to the target value
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("""
    var slider = arguments[0];
    var targetValue = arguments[1];
    slider.value = targetValue;
    slider.dispatchEvent(new Event('change'));
""", slider, targetValue)

// Optionally, click the "Go" button to submit the price range
WebUI.click(findTestObject('Object Repository/price_slider/go_button'))