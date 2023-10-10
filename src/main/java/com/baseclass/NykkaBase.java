package com.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class NykkaBase {
	public static WebDriver driver;
	static Actions action;
	static Select select;
	static Alert alert; 
	static Robot robot;
	static JavascriptExecutor java;
	//browser launch
	public static WebDriver browserLaunch(Enum browser, String privacy) {
		if(browser==BrowserName.Chrome) {
			WebDriverManager.chromedriver().setup();
			if(privacy.equalsIgnoreCase("private")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				driver = new ChromeDriver(options);
			}else if(privacy.equalsIgnoreCase("public")) {
				driver = new ChromeDriver();
			}
		}else if(browser==BrowserName.Firefox) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser==BrowserName.Edge) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	//get webpage
	public static WebDriver getWebPage(String url, String method) {
		if(method.equalsIgnoreCase("driver")) {
			driver.get(url);	
		}else if(method.equalsIgnoreCase("navigate")) {
			driver.navigate().to(url);
		}
		
		return driver;
	}
	//mouse action-move to element
	public static void moveToTargetElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	//mouse action-click element
	public static void clickElement(WebElement element) {
		action = new Actions(driver);
		action.click(element).perform();
	}
	//mouse action-Right Click element
	public static void rightClick(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).contextClick(element).build().perform();
	}
	//mouse action-Drag & Drop Element
	public static void dragAndDrop(WebElement source, WebElement destination) {
		action = new Actions(driver);
		action.dragAndDrop(source, destination);
	}
	//send keys to element
	public static void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	//Take screenshot
	public static void screenShot(String name) {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\JAVA Selinium\\Nykka\\screenshots\\"+name+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get page title
	public static void getPageTitle() {
		driver.getTitle();
	}
	// get text 
	public static void getTheText(WebElement element) {
		element.getText();
	}
	// Drop down Selection
	public static void dropDown(WebElement element, String method, String input) {
		select = new Select(element);
		if(method.equalsIgnoreCase("index")) {
			int inputindex = Integer.parseInt(input);
			select.selectByIndex(inputindex);
		}else if(method.equalsIgnoreCase("value")) {
			select.selectByValue(input);
		}else if(method.equalsIgnoreCase("text")) {
			select.selectByVisibleText(input);
		}
	}
	// alert
	public static void alert(String method, String input) {
		alert = driver.switchTo().alert();
		if(method.equalsIgnoreCase("accept")) {
			alert.accept();
		}else if(method.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}else if(method.equalsIgnoreCase("input")) {
			alert.sendKeys(input);
		}
	}
	//KeyPress
	public static void keyPressNow(String keyname) {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(keyname) {
		case "enter":
			robot.keyPress(KeyEvent.VK_ENTER);
			break;
		
		case "ctrl":
			robot.keyPress(KeyEvent.VK_CONTROL);
			break;
		case "v":
			robot.keyPress(KeyEvent.VK_V);
			break;
		case "down":
			robot.keyPress(KeyEvent.VK_DOWN);
			break;
		}
	}
	//KeyRelease
	public static void keyReleaseNow(String keyname) {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(keyname) {
		case "enter":
			robot.keyRelease(KeyEvent.VK_ENTER);
			break;
		
		case "ctrl":
			robot.keyRelease(KeyEvent.VK_CONTROL);
			break;
		case "v":
			robot.keyRelease(KeyEvent.VK_V);
			break;
		case "down":
			robot.keyRelease(KeyEvent.VK_DOWN);
			break;
		}
	}
	
	
	//Switch Frame by index & value
	public static void switchFrame(String method,String value) {
		if(method.equals("id")) {
			driver.switchTo().frame(value);	
		}else if(method.equalsIgnoreCase("index")) {
			int x = Integer.parseInt(value);
			driver.switchTo().frame(x);
		}else if(method.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		}
	}
	//Switch Frame by WebElement
	public static void switchFrame(String method, WebElement frame) {
		if(method.equalsIgnoreCase("element")) {
			driver.switchTo().frame(frame);	
		}
	}
		
	//Switch Window
	public static void switchTab(String trageturl) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String currenttab = driver.getCurrentUrl();
			if(currenttab.equals(trageturl)) {
				break;
			}
		}
	}
	//Implicit Wait
	public static void implicitWait(int timeinseconds) {
		driver.manage().timeouts().implicitlyWait(timeinseconds,TimeUnit.SECONDS);
	}
	//Explicit Wait
	public static void explicitWait(int waittime, String condition, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waittime);
		if(condition.equalsIgnoreCase("visible")) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}else if(condition.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}
	//JavaScriptExecutor Click
	public static void javaScriptClick(WebElement element) {
		java = (JavascriptExecutor) driver;
		java.executeScript("arguements[0].click();", element);
	}
	
	//JavaScriptExecutor scroll
	public static void javaScriptScroll() {
		java = (JavascriptExecutor) driver;
		java.executeScript("window.scrollBy(0, $$.scroll(this,event))");
	}
	
	//javaScript scroll into view
	public static void javaTargetScroll(WebElement element) {
		java = (JavascriptExecutor) driver;
		java.executeScript("arguements[0].scrollIntoView();", element);
	}
	// Scanner Class
	public static String scannerMethod() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the OTP Here:");
		Integer otp = scan.nextInt();
		String otp1 = otp.toString();
		return otp1;
	}
	
	//close tab
	public static void closeTab() {
		driver.close();
	}
	
	public static void quitWindow() {
		driver.quit();
	}

}
