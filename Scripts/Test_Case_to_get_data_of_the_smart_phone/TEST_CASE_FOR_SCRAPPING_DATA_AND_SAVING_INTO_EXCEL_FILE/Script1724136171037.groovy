import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.io.File as File
import java.io.FileInputStream as FileInputStream
import java.io.FileOutputStream as FileOutputStream
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebElement

// Define the Excel file path and sheet
String excelFilePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\mail\\amazon_product_data.xlsx"
String sheetName = 'Sheet1'

// Create the Excel file if it doesn't exist
File file = new File(excelFilePath)
Workbook workbook
Sheet sheet

if (!(file.exists())) {
	workbook = new XSSFWorkbook()
	sheet = workbook.createSheet(sheetName)
	FileOutputStream fos = new FileOutputStream(file)
	workbook.write(fos)
	fos.close()
	workbook.close()
}

// Now open the existing file
FileInputStream fis = new FileInputStream(file)
workbook = new XSSFWorkbook(fis)
sheet = workbook.getSheet(sheetName)

if (sheet == null) {
	sheet = workbook.createSheet(sheetName)
}

// Add headers if the sheet is empty
if (sheet.getPhysicalNumberOfRows() == 0) {
	Row headerRow = sheet.createRow(0)
	headerRow.createCell(0).setCellValue('PRODUCT_NAME')
	headerRow.createCell(1).setCellValue('BRAND_NAME')
	headerRow.createCell(2).setCellValue('OPERATING_SYSYTEM')
	headerRow.createCell(3).setCellValue('CPU_SPEED')
	headerRow.createCell(4).setCellValue('MEMORY_STORAGE')
	headerRow.createCell(5).setCellValue('SCREEN_SIZE')
	headerRow.createCell(6).setCellValue('PRICE_OF_PRODUCT')
	headerRow.createCell(7).setCellValue('IN_STOCK_PRODUCT')
}

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

	// Find all the product links on the page
	List<WebElement> productLinks = WebUI.findWebElements(findTestObject('Object Repository/To_get_data_of_the_smart_phone/link_to_click_to_get_data'), 10)
	
	int productIndex = 1
	
	for (WebElement link : productLinks) {
		link.click()
		
		// Call your test case to extract product data
		WebUI.callTestCase(findTestCase('Test_Case_to_get_data_of_the_smart_phone/TEST_CASE_TO_GET_DATA_OF_THE_PRODUCT_PAGE'), [:], FailureHandling.STOP_ON_FAILURE)
		
		// Store the product data in Excel
		int rowIndex = sheet.getLastRowNum() + 1
		Row row = sheet.createRow(rowIndex)
		row.createCell(0).setCellValue(GlobalVariable.product_name)
		row.createCell(1).setCellValue(GlobalVariable.brand_name)
		row.createCell(2).setCellValue(GlobalVariable.operating_system)
		row.createCell(3).setCellValue(GlobalVariable.cpu_model)
		row.createCell(4).setCellValue(GlobalVariable.memory_storage)
		row.createCell(5).setCellValue(GlobalVariable.screen_size)
		row.createCell(6).setCellValue(GlobalVariable.price_of_the_product)
		row.createCell(7).setCellValue(GlobalVariable.in_stock_data)

		productIndex++
		
		// Close the newly opened tab and switch back to the main tab
		//WebUI.closeWindowIndex(1)
		//WebUI.switchToWindowIndex(0)
	}
	
	// Add a delay to allow the page to load before moving to the next page
	WebUI.delay(1)
}

// Save the Excel file
fis.close()
FileOutputStream fos = new FileOutputStream(file)
workbook.write(fos)
fos.close()
workbook.close()

println('Product data has been successfully saved in Excel.')
