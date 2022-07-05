package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.PageInitializer;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {
    private static Logger LOG = Logger.getLogger(CommonMethods.class);

    /**
     * Method return object of Java Script Executor type
     *
     * @return js object
     */
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;

    }

    /**
     * Method scrolls up using JavaScript executor
     *
     * @param pixel
     */
    public static void scrollUp(int pixel) {
        getJSExecutor().executeScript("window.scrollBy(0,-" + pixel + ")");

    }

    /**
     * Method scrolls down using JavaScript executor
     *
     * @param pixel
     */
    public static void scrollDown(int pixel) {
        getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");

    }

    /**
     * Method performs Explicit wait
     *
     * @return new object of WebDriverWait
     */
    public static WebDriverWait getWaitObject() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    /**
     * Method wait for element to be clickable.
     *
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Method performs click
     *
     * @param element
     */
    public static void click(WebElement element) {
        LOG.info("Waiting if clickable");
        waitForClickability(element);
        LOG.debug("Element is clickable");
        element.click();
    }

    /**
     * Use this method to select a drop down value from a ServiceNow drop down menu
     * when Select class will not work NOTE: Before using, first you must click on
     * the drop down, then store elements in a list
     */
    public static void selectValueFromDropDown(List<WebElement> values, String value) {
        LOG.info("Selecting value from DD");
        for (WebElement dropDownValue : values) {
            if (dropDownValue.getText().contentEquals(value)) {
                LOG.info("Selected value is: " + value);
                dropDownValue.click();
                break;
            }
        }

    }

    public static void selectSecondLargestValue(List<WebElement> list) {
        LOG.info("Clicking on the element: " + list.get(2));
        list.get(2).click();
    }

    /**
     * Use this method to switch to the next another open window
     */
    public static void switchToAnotherWindow() {
        Set<String> handlingAllOpenWindows = driver.getWindowHandles();
        for (String nextWindow : handlingAllOpenWindows) {
            driver.switchTo().window(nextWindow);
            LOG.debug("Switching to another window");
        }
    }

    public static void extractTextFromItemDescription(List<WebElement> textLinks) {
        for (int i = 1; i < textLinks.size(); i++) {
            LOG.info(textLinks.get(i).getText());
        }
    }

}

