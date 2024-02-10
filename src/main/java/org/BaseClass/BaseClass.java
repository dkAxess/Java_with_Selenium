package org.BaseClass;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains common methods for Selenium WebDriver operations.
 */

public class BaseClass {

	public static WebDriver driver;

	 /**
     * Launches a browser based on the specified name.
     *
     * @param name The name of the browser ("chrome" or "edge").
     * @return The WebDriver instance.
     */
	public static WebDriver browser_Launch(String name) {

		if (name.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
		} else if (name.equalsIgnoreCase("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("private");
			driver = new EdgeDriver(option);
		}
		return driver;

	}
	
	 /**
     * Launches the specified URL in the given WebDriver instance.
     *
     * @param driver The WebDriver instance.
     * @param url The URL to navigate to.
     */

	public static void url_Launch(WebDriver driver, String url) {

		driver.get(url);

	}
	
    /**
     * Maximizes the window screen size.
     *
     * @param driver The WebDriver instance.
     */
	public static void maximize_screen(WebDriver driver) {

		driver.manage().window().maximize();

	}
	
	 /**
     * Quits the overall browser.
     *
     * @param driver The WebDriver instance.
     */
	public static void quit_browser(WebDriver driver) {

		driver.quit();

	}
	
	   /**
     * Closes the particular browser window.
     *
     * @param driver The WebDriver instance.
     */

	public static void close_browser(WebDriver driver) {

		driver.close();

	}
	
	 /**
     * Navigates back to the previous page.
     *
     * @param driver The WebDriver instance.
     */

	public static void back_page(WebDriver driver) {

		driver.navigate().back();

	}
	
	  /**
     * Navigates forward to the next page.
     *
     * @param driver The WebDriver instance.
     */
	public static void forward_page(WebDriver driver) {

		driver.navigate().forward();

	}
	

    /**
     * Refreshes the current page.
     *
     * @param driver The WebDriver instance.
     */
	public static void refresh_page(WebDriver driver) {

		driver.navigate().refresh();

	}
	
	  /**
     * Gets the size of the current window.
     *
     * @param driver The WebDriver instance.
     */
	public static void get_window_size(WebDriver driver) {

		driver.manage().window().getSize();

	}
	
	/**
	 * Clicks on the specified WebElement.
	 *
	 * @param element The WebElement to be clicked.
	 */

	public static void element_click(WebElement element) {

		element.click();

	}
	
	/**
	 * Sets the value of the specified WebElement.
	 *
	 * @param element The WebElement to which the value is to be set.
	 * @param value   The value to be set in the WebElement.
	 */

	public static void set_value(WebElement element, String value) {

		element.sendKeys(value);

	}

	/**
	 * Clears the value of the specified WebElement.
	 *
	 * @param element The WebElement whose value is to be cleared.
	 */
	
	public static void clear_value(WebElement element) {

		element.clear();

	}
	
	/**
	 * Retrieves and prints the text value of the specified WebElement.
	 *
	 * @param element The WebElement from which to fetch the text value.
	 */

	public static void fetch_value(WebElement element) {

		String text = element.getText();
		System.out.println(text);

	}

	/**
	 * Checks and prints whether the specified WebElement is visible.
	 *
	 * @param element The WebElement to check for visibility.
	 */
	
	public static void element_visible(WebElement element) {

		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

	}
	
	/**
	 * Checks and prints whether the specified WebElement is enabled.
	 *
	 * @param element The WebElement to check for being enabled.
	 */

	public static void element_enable(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}

	/**
	 * Checks and prints whether the specified WebElement is selected.
	 *
	 * @param element The WebElement to check for being selected.
	 */
	
	public static void element_selected(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}
	
	/**
	 * Takes a screenshot of the current WebDriver instance and saves it to the specified location.
	 *
	 * @param driver   The WebDriver instance from which to capture the screenshot.
	 * @param location The file path where the screenshot should be saved.
	 * @throws IOException If an I/O exception occurs while saving the screenshot.
	 */

	public static void screenshot(WebDriver driver, String location) throws IOException {

		TakesScreenshot pic = (TakesScreenshot) driver;
		File screenshotAs = pic.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		FileUtils.copyFile(screenshotAs, des);

	}

	/**
	 * Selects an option from a dropdown by its index.
	 *
	 * @param element The WebElement representing the dropdown.
	 * @param num     The index of the option to be selected.
	 */
	
	public static void select_option_index(WebElement element, int num) {

		Select s = new Select(element);
		s.selectByIndex(num);

	}

	/**
	 * Selects an option from a dropdown by its value attribute.
	 *
	 * @param element The WebElement representing the dropdown.
	 * @param value   The value attribute of the option to be selected.
	 */
	
	public static void select_option_value(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);

	}
	
	/**
	 * Selects an option from a dropdown by its visible text.
	 *
	 * @param element The WebElement representing the dropdown.
	 * @param value   The visible text of the option to be selected.
	 */

	public static void select_option_text(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByVisibleText(value);

	}
	
	/**
	 * Retrieves and prints all selected options from a multi-select dropdown.
	 *
	 * @param element The WebElement representing the multi-select dropdown.
	 */

	public static void get_dropdown_options(WebElement element) {

		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement options : allSelectedOptions) {
			System.out.println(options);
		}

	}
	
	/**
	 * Deselects an option from a multi-select dropdown by its index.
	 *
	 * @param element The WebElement representing the multi-select dropdown.
	 * @param num     The index of the option to be deselected.
	 */

	public static void deselect_option_index(WebElement element, int num) {

		Select s = new Select(element);
		s.deselectByIndex(num);

	}
	
	/**
	 * Deselects an option from a multi-select dropdown by its value attribute.
	 *
	 * @param element The WebElement representing the multi-select dropdown.
	 * @param value   The value attribute of the option to be deselected.
	 */

	public static void deselect_option_value(WebElement element, String value) {

		Select s = new Select(element);
		s.deselectByValue(value);

	}
	
	/**
	 * Deselects an option from a multi-select dropdown by its visible text.
	 *
	 * @param element The WebElement representing the multi-select dropdown.
	 * @param value   The visible text of the option to be deselected.
	 */

	public static void deselect_option_text(WebElement element, String value) {

		Select s = new Select(element);
		s.deselectByVisibleText(value);

	}
	
	/**
	 * Checks and prints whether a dropdown allows multiple selections.
	 *
	 * @param element The WebElement representing the dropdown.
	 */

	public static void check_option_multiple(WebElement element) {

		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);

	}

	/**
	 * Fetches and prints all options available in a dropdown.
	 *
	 * @param element The WebElement representing the dropdown.
	 */
	
	public static void fetch_all_options(WebElement element) {

		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement value : options) {
			System.out.println(value);
		}
	}
	
	/**
	 * Accepts an alert dialog in the current WebDriver session.
	 *
	 * @param driver The WebDriver instance in which the alert is present.
	 */

	public static void alert_control(WebDriver driver) {

		Alert ok = driver.switchTo().alert();
		ok.accept();

	}

	/**
	 * Dismisses (cancels) an alert dialog in the current WebDriver session.
	 *
	 * @param driver The WebDriver instance in which the alert is present.
	 */
	
	public static void alert_dismiss(WebDriver driver) {

		Alert reject = driver.switchTo().alert();
		reject.dismiss();

	}

	/**
	 * Switches the WebDriver focus to the specified frame.
	 *
	 * @param driver  The WebDriver instance to perform the frame switch.
	 * @param element The WebElement representing the frame to switch to.
	 */
	
	public static void handleFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}
	
	/**
	 * Switches the WebDriver focus back to the default content.
	 *
	 * @param driver The WebDriver instance to perform the switch to default content.
	 */

	public static void frame_default_content(WebDriver driver) {

		driver.switchTo().defaultContent();

	}

	/**
	 * Performs a click operation on a WebElement using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance to execute the JavaScript click.
	 * @param element The WebElement on which to perform the click.
	 */
	
	public static void js_Click(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}
	
	/**
	 * Scrolls the page to bring a WebElement into view using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance to execute the JavaScript scroll.
	 * @param element The WebElement to be scrolled into view.
	 */

	public static void js_ScrollPage(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView()", element);

	}

	/**
	 * Performs a right-click operation on a WebElement using Actions class.
	 *
	 * @param driver  The WebDriver instance to perform the right-click.
	 * @param element The WebElement on which to perform the right-click.
	 */
	
	public static void right_click(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();

	}
	
	/**
	 * Performs a click operation on a WebElement using Actions class.
	 *
	 * @param driver  The WebDriver instance to perform the click.
	 * @param element The WebElement on which to perform the click.
	 */

	public static void action_click(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.click(element).build().perform();

	}
	
	/**
	 * Performs a double-click operation on a WebElement using Actions class.
	 *
	 * @param driver  The WebDriver instance to perform the double-click.
	 * @param element The WebElement on which to perform the double-click.
	 */

	public static void double_click(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();

	}
	
	/**
	 * Moves the mouse to the specified WebElement using Actions class.
	 *
	 * @param driver  The WebDriver instance to perform the mouse move.
	 * @param element The WebElement to which the mouse should be moved.
	 */

	public static void move_the_mouse(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}

	/**
	 * Simulates pressing the down arrow key using the Robot class.
	 *
	 * @throws AWTException If an Abstract Window Toolkit exception occurs.
	 */
	
	public static void key_down() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	/**
	 * Simulates pressing the Enter key using the Robot class.
	 *
	 * @throws AWTException If an Abstract Window Toolkit exception occurs.
	 */
	
	public static void key_enter() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	
	/**
	 * Sets the implicit wait time for the WebDriver instance.
	 *
	 * @param driver The WebDriver instance for which to set the implicit wait.
	 * @param value  The duration to wait implicitly in seconds.
	 */

	public static void implicitWait(WebDriver driver, int value) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}

}
