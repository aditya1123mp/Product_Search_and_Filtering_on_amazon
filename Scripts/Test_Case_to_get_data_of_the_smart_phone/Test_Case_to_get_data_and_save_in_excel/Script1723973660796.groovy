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
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.io.File as File
import java.io.FileInputStream as FileInputStream
import java.io.FileOutputStream as FileOutputStream
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

// Excel file path and sheet name
String excelFilePath = 'C:\\Users\\DELL\\OneDrive\\Desktop\\mail\\amazon_product_data.xlsx'
String sheetName = 'Sheet1'

// Create the Excel file if it doesn't exist
File file = new File(excelFilePath)
Workbook workbook
Sheet sheet

if (!file.exists()) {
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
	headerRow.createCell(0).setCellValue('Product_name')
	headerRow.createCell(1).setCellValue('Brand_name')
	headerRow.createCell(2).setCellValue('CPU_SPEED')
	headerRow.createCell(3).setCellValue('MEMORY')
	headerRow.createCell(4).setCellValue('SCREEN_SIZE')
	headerRow.createCell(5).setCellValue('OPERATING_SYSTEM')
	headerRow.createCell(6).setCellValue('PRICE')
	headerRow.createCell(7).setCellValue('AVAILABILITY')
}

// Function to change the page number in the URL
def changePageNumber(String url, int newPageNumber) {
	return url.replaceAll(/page=\d+/, "page=${newPageNumber}")
}

// Function to get data for specified XPaths if they exist
def getDataIfPresent(String xpath) {
	TestObject testObject = new TestObject()
	testObject.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, xpath)
	if (WebUI.verifyElementPresent(testObject, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
		return WebUI.getText(testObject)
	}
	return null
}

// Original URL
String url = "https://www.amazon.in/s?k=smartphone&page=1"

// Convert the last page number from String to int
int lastPageNumber = GlobalVariable.last_page_number.toInteger()

// Start writing data from row 1
int rowNum = sheet.getPhysicalNumberOfRows()

// Loop through all pages from 1 to the last page
for (int i = 1; i <= lastPageNumber; i++) {
	// Update the URL with the current page number
	String updatedUrl = changePageNumber(url, i)
	
	// Navigate to the updated URL
	WebUI.navigateToUrl(updatedUrl)
	
	// Delay to ensure page loads
	WebUI.delay(3)
	
	// Get the list of all links on the current page
	def links = WebUI.findWebElements(findTestObject('Object Repository/To_get_data_of_the_smart_phone/link_to_click_to_get_data'), 10)
	
	for (def link : links) {
		// Click the link
		link.click()
		
		// Switch to the new window
		WebUI.switchToWindowIndex(1)
		
		// Collect data from the specified XPaths
		def productTitle = getDataIfPresent("//span[@id='productTitle']")
		def brand = getDataIfPresent("//table[@class='a-normal a-spacing-micro']//tr[@class='a-spacing-small po-brand']//td[@class='a-span9']/span")
		def cpuModel = getDataIfPresent("//table[@class='a-normal a-spacing-micro']//tr[@class='a-spacing-small po-cpu_model.family']//td[@class='a-span9']/span")
		def memoryStorage = getDataIfPresent("//table[@class='a-normal a-spacing-micro']//tr[@class='a-spacing-small po-memory_storage_capacity']//td[@class='a-span9']/span")
		def screenSize = getDataIfPresent("//table[@class='a-normal a-spacing-micro']//tr[@class='a-spacing-small po-screen_size']//td[@class='a-span9']/span")
		def operatingSystem = getDataIfPresent("//table[@class='a-normal a-spacing-micro']//tr[@class='a-spacing-small po-operating_system']//td[@class='a-span9']/span")
		def price = getDataIfPresent("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
		def availability = getDataIfPresent("//div[@id='availability']")
		
		// Write the collected data to the Excel sheet
		Row row = sheet.createRow(rowNum++)
		row.createCell(0).setCellValue(productTitle ?: "")
		row.createCell(1).setCellValue(brand ?: "")
		row.createCell(2).setCellValue(cpuModel ?: "")
		row.createCell(3).setCellValue(memoryStorage ?: "")
		row.createCell(4).setCellValue(screenSize ?: "")
		row.createCell(5).setCellValue(operatingSystem ?: "")
		row.createCell(6).setCellValue(price ?: "")
		row.createCell(7).setCellValue(availability ?: "")
		
		// Close the new window and switch back to the original window
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
		
		// Optional delay before clicking the next link
		WebUI.delay(2)
	}
}

// Save the Excel file
FileOutputStream fos = new FileOutputStream(file)
workbook.write(fos)
fos.close()
workbook.close()

// Close the input stream
fis.close()
