package org.test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	WebDriver driver;
	Actions actions;
	Robot robot;
	Alert al;
	JavascriptExecutor executor;
	FileInputStream stream;
	TakesScreenshot screenshot;
	Workbook workbook;
	File file;
	Sheet sheet;
	Row row;
	int cell;
	int type;

	// 1.LAUNCH 3 steps
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	// 2.URL LAUNCH(GET())
	public void url(String url) {
		driver.get(url);
	}

	// 3.FINDELEMENT(id)
	public WebElement elementLocator(String Locator) {
		return driver.findElement(By.id(Locator));
	}

	// 4.MAXIMIZE
	public void maximize() {
		driver.manage().window().maximize();
	}

	// 5.SENDKEYS
	public void enterText(WebElement findElement, String Text) {
		findElement.sendKeys(Text);
	}

	// 6.XPATH
	public WebElement elementLocatorByXpath(String Xpath) {
		WebElement findElement = driver.findElement(By.xpath(Xpath));
		return findElement;
	}

	// 7.GET TITLE
	public String launchTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 8.CuRRENT URL
	public String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	// 9. GET KEYS
	public String toGetkeys(WebElement findElement) {
		String text2 = findElement.getText();
		return text2;
	}

	// 10 GET ATTRIBUTE
	public String toGetValues(WebElement findElement) {
		String text3 = findElement.getAttribute("Value");
		return text3;
	}

	// 11.MOUSEOVER
	public void toMove(WebElement findElement) {
		new Actions(driver).moveToElement(findElement).perform();
	}

	// 12.RIGHTCLICK
	public void toRightClick(WebElement findElement) {
		new Actions(driver).contextClick(findElement).perform();
	}

	// 13.DRAG AND DROP
	public void toDragAndDrop(WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).perform();
	}

	// 14.KEY UP AND KEY DOWN
	public void tokeyuandD(WebElement element, String name) {
		new Actions(driver).keyDown(element, Keys.SHIFT).sendKeys(element, name).keyUp(element, Keys.SHIFT);
	}

	// 15.ALERT
	public Alert toAlert() {
		return driver.switchTo().alert();
	}

	// 16.simpleAlert
	public void toSimpleAlert() {
		toAlert().accept();
	}

	// 17.CONFIRM ALERT
	public void toConfirmAlert() {
		toAlert().dismiss();
	}

	// 18.PROMPT ALERT
	public void toPromptAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
		al.accept();
	}

	// 19 JavaScriptExecutor
	private void toJavaScript(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value'," + data + ")", element);
	}

	// 20 SCREENSHOT
	public File toTakeScreens(String data) throws IOException {
		screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(data);
		FileUtils.copyFile(s, d);
		return s;
	}

	// 21.SYSOUT
	public void toPrint(String name) {
		System.out.println(name);
	}

	// 22.FRAMES
	public void byUsingIdName(String data) {
		driver.switchTo().frame(data);
	}

	// 23 FRAMES WEBELEMENT
	public void byUsingWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// 24 FRAME INDEX
	public void byUsingIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 25 TAGNAME
	public void toXPATHTagName(String data) {
		driver.findElement(By.tagName(data));
	}

	// 26 return to window in frames
	public void returnToWindow() {
		driver.switchTo().defaultContent();
	}

	//// 27 SCROLLUP
	public void toScrollUp(WebElement s, WebElement d) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", s);
		executor.executeScript("arguments[0].scrollIntoView(false)", d);
	}

	// 28.PARENTWINDOW
	public String toParentWindow() {
		return driver.getWindowHandle();
	}

	// 29.ALLWINDOWID
	public Set<String> toAllWIndow() {
		return driver.getWindowHandles();
	}

	// 30.Switching to parentID
	public void SwitchPwid(String data) {
		driver.switchTo().window(data);
	}

	// 31.INNER FRAMES
	public void frameI(int num) {
		driver.switchTo().frame(num);
	}

	// 32.SWITCHING
	public void frame1() {
		driver.switchTo().parentFrame();
	}

	// 33.SELECT OPTION BY TEXT
	public void toSelectOptionByText(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);
	}

	// 34.DESELECT OPTION BY TEXT
	public void toDeselectOptionByText(WebElement element, String data) {
		new Select(element).deselectByVisibleText(data);
	}

	// 35.SELECT OPTIONS BY ATTRIBUTE
	public void toSelectOptionByAttribute(WebElement element, String data) {
		new Select(element).selectByValue(data);
	}

	// 36.DESELECT OPTION BY ATTRIBUTE
	public void toDeselectOptionByAttribute(WebElement element, String data) {
		new Select(element).deselectByValue(data);
	}

	// 37.SELECT OPTION BY INDEX
	public void toSelectOptionByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// 38.DESELECT OPTION BY INDEX
	public void toDeselectOptionByIndex(WebElement element, int data) {
		new Select(element).deselectByIndex(data);
	}

	// 39.firstSelectedOptions
	public void toGetfirstSelectedOptions(WebElement element) {
		new Select(element).getFirstSelectedOption();
	}

	// 40.getAllSelectedOptions
	public void toGetAllSelectedOptions(WebElement element) {
		new Select(element).getAllSelectedOptions();
	}

	// 41.getOptions
	public void ToGetOptions(WebElement element) {
		new Select(element).getOptions();
	}

	// 42.multipe
	public void toMultipe(WebElement element) {
		new Select(element).isMultiple();
	}

	// 43TO DOUBLECLICk
	public void toDoubleclick(WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	// 44.QUIT
	public void closeallwindows() {
		driver.quit();
	}

	// 45.CLOSE()
	public void closewindow() {
		driver.close();
	}

	// 46.NAVIGATION_FORWARD
	public void forward() {
		driver.navigate().forward();
	}

	// 47.BACK
	public void back() {
		driver.navigate().back();
	}

	// 48.REFRESH
	public void refresh() {
		driver.navigate().refresh();
	}

	// 49.FILEFrameworks
	public Sheet fileLaunch(String location, String xlname) throws Exception {
		sheet = new XSSFWorkbook(new FileInputStream(new File(location))).getSheet(xlname);
		return sheet;
	}

	// 50toGetRow
	public Row toGetRow(int rowno, int cellno) {
		sheet.getRow(rowno).getCell(cellno);
		return row;
	}

	// 51.keyPress
	public void keyP(int element) throws Exception {
		new Robot().keyPress(element);
	}

	// 52.KEY RELEASE
	public void keyR(int element) throws Exception {
		new Robot().keyRelease(element);
	}

	// 53.PHYSICAL NO>OF ROWS AND COLUMNS
	public void NoOfCells(String Path, String nam1, int rowNo, int cellNo) throws Exception {
		XSSFCell cell = new XSSFWorkbook(Path).getSheet(nam1).getRow(rowNo).getCell(cellNo);
		int cells = new XSSFWorkbook(Path).getSheet(nam1).getRow(rowNo).getPhysicalNumberOfCells();
		System.out.println(cells);
	}

	// 54.Submit
	public void submit(WebElement element) {
		element.submit();
	}

	// 55.DESELECT ALL
	public void deselectAll(WebElement element) {
		new Select(element).deselectAll();
	}

	// 56.
	public void implict(int num) {
		driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}

	// 57.getCELLTYPE
	public void toWrite() {

	}

}
	