package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RemoteDriverManager;

public class BasePage {

    protected String baseURL = "http://soft.it-hillel.com.ua:8080";
    protected WebDriver driver;
    private int timeOutInSeconds = 10;

    protected BasePage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    protected void waitToBePresent(By locator) {
        (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @param locator
     * @param timeOutInSeconds
     */
    protected void waitToBePresentIn(By locator, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @param locator
     */

    protected void waitToBePresentAndClick(By locator) {

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        }

    }

    protected void waitToBePresentAndSendKeys(By locator, String keys) {

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        }

    }

    protected void waitToBePresentAndSendSubmit(By locator) {

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.submit();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, timeOutInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.submit();
        }

    }


    protected void scrollDown() {

    }

    protected void scrollUp() {

    }

    protected void scrollUpOn(int x) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-" + x + ")", "");
    }

    protected void scrollDownOn(int x) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + x + ")", "");
    }

//    protected WebElement findElement(By locator) {
//        return driver.findElement(locator);
//    }


    protected boolean isOnThePage(String expectedURL) {

        String currentURL = driver.getCurrentUrl();
        return expectedURL.equals(currentURL);

    }

}
