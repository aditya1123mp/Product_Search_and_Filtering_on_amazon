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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

//WebUI.click(findTestObject('Object Repository/To_get_data_of_the_smart_phone/link_to_click_to_get_data'))

// Switch to the new window
WebUI.switchToWindowIndex(1)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/get_product_name'), 10, 
    FailureHandling.OPTIONAL)) {
    GlobalVariable.product_name = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/get_product_name'))

    System.out.println('Product Name: ' + GlobalVariable.product_name)
} else {
    GlobalVariable.product_name = 'Not_available'
}

//System.out.println(GlobalVariable.product_name)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_brand_name'), 10, 
    FailureHandling.OPTIONAL)) {
    GlobalVariable.brand_name = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_brand_name'))

    System.out.println('Brand Name: ' + GlobalVariable.brand_name)
} else {
    GlobalVariable.brand_name = 'Not_available'
}

//System.out.println(GlobalVariable.product_name)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_cpu_model'), 10, 
    FailureHandling.OPTIONAL)) {
    GlobalVariable.cpu_model = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_cpu_model'))

    System.out.println('CPU Model: ' + GlobalVariable.cpu_model)
} else {
    GlobalVariable.cpu_model = 'Not_available'
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_in_stock_data'), 
    10, FailureHandling.OPTIONAL)) {
    GlobalVariable.in_stock_data = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_in_stock_data'))

    System.out.println('In Stock Data: ' + GlobalVariable.in_stock_data)
} else {
    GlobalVariable.in_stock_data = 'Not_available'
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_memory_storage'), 
    10, FailureHandling.OPTIONAL)) {
    GlobalVariable.memory_storage = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_memory_storage'))

    System.out.println('Memory Storage: ' + GlobalVariable.memory_storage)
} else {
    GlobalVariable.memory_storage = 'Not_available'
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_operating_system'), 
    10, FailureHandling.OPTIONAL)) {
    GlobalVariable.operating_system = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_operating_system'))

    System.out.println('Operating System: ' + GlobalVariable.operating_system)
} else {
    GlobalVariable.operating_system = 'Not_available'
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_price_of_the_product'), 
    10, FailureHandling.OPTIONAL)) {
    GlobalVariable.price_of_the_product = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/getting_price_of_the_product'))

    System.out.println('Price: ' + GlobalVariable.price_of_the_product)
} else {
    GlobalVariable.price_of_the_product = 'Not_available'
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/sold_by'), 10, 
    FailureHandling.OPTIONAL)) {
    GlobalVariable.sold_by = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/sold_by'))

    System.out.println('Sold_by: ' + GlobalVariable.sold_by)
} else {
    GlobalVariable.sold_by = 'Not_available'
}


if (WebUI.verifyElementPresent(findTestObject('Object Repository/To_get_data_of_the_smart_phone/ships_from'), 10,
	FailureHandling.OPTIONAL)) {
	GlobalVariable.ships_from = WebUI.getText(findTestObject('Object Repository/To_get_data_of_the_smart_phone/ships_from'))

	System.out.println('ships_from: ' + GlobalVariable.ships_from)
} else {
	GlobalVariable.ships_from = 'Not_available'
}




// Close the new window and switch back to the original window
WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)

// Optional delay before clicking the next link
WebUI.delay(2)


