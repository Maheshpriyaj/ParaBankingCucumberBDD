package com.banking.Basepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	Select select;
	public static WebDriver driver;

	public String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	public void mouseOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void elementSendKeysEnter(WebElement element, String data) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public void pressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// input--> sheetname, rownum,cellnum output-->String value
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		// C:\Users\DELL\eclipse-workspace\FrameworkTask (user.dir)
		// C:\Users\DELL\eclipse-workspace\FrameworkTask\Excel Sheets\GroceryAppln.xlsx
		File file = new File(getProjectPath() + "\\Excel Sheets\\GroceryAppln.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();

				// to get the date in given format(dd-MM-yyyy)
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				res = dateFormat.format(dateCellValue);
			}

			else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);
				}

				// double numericCellValue = cell.getNumericCellValue();
//				// to get the numbers in correct format
//				BigDecimal b = BigDecimal.valueOf(numericCellValue);
//				// to get the numbers in string
//				String num = String.valueOf(b);
//				System.out.println(num);

			}
			break;
		default:
			break;
		}

		return res;
	}

	// input--> sheetname, rownum,cellnum,olddata,newdata
	public void updateCellValue(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheets\\GroceryAppln.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
	}

	// input--->sheetname,rownum,cellnum,data
	public void createCellAndSetCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {

		File file = new File(getProjectPath() + "\\Excel Sheets\\GroceryAppln.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);

	}
	
		
	public void switchToIframe(WebElement element) {
		elementVisibility(element);
        driver.switchTo().frame(element);
    }

        public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public void promptAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	public List<String> getAllOptionsText(WebElement element) {
		List<String> lstText = new ArrayList<>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			lstText.add(text);

		}
		return lstText;
	}

	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindowsId = driver.getWindowHandles();

		for (String eachWindowId : allWindowsId) {
			if (!pWindow.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}
	}

	public void screenshot(WebElement element, String sName) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}

	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}

	public void elementClear(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.clear();
		}

	}

	public void elementVisibility(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}

	}

	public void enterApplnUrl(String url) {
		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		elementVisibility(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void elementclickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void elementClick(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement findElement = driver.findElement(By.xpath(attributeValue));
		return findElement;
	}
	
	public List<WebElement> findsLocatorByXpath(String attributeValue) {
	    List<WebElement> findElements = driver.findElements(By.xpath(attributeValue));
	    return findElements;
	}


	public String getAppnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void closeWindow() {
		driver.close();
	}

	public void quitWindow() {
		driver.quit();
	}

	public boolean elementIsEnabled(WebElement element) {
		elementVisibility(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean elementIsDisplayed(WebElement element) {
		elementVisibility(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsSelected(WebElement element) {
		elementVisibility(element);
		boolean selected = element.isSelected();
		return selected;
	}

	public String elementGetText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

	// 99%--->value fixed
	public String elementGetAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;

	}

	// 1%--->value is NOT fixed
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute(attributeName);
		}
		return attribute;
	}

	public void selectOptionByText(WebElement element, String text) {

		elementVisibility(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String text) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByValue(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

}