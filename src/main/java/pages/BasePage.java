package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RemoteDriverManager;

public class BasePage {

    protected WebDriver driver;

    BasePage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public void waitToBePresent(By locator) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @param locator
     */

    public void waitToBePresentAndClick(By locator) {
        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    /**
     * @param locator
     * @param timeOutInSeconds
     */
    public void waitToBePresentAfter(By locator, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement findDynamicElement(By locator) {
        try {
            driver.findElement(locator);
        } catch (StaleElementReferenceException ignored) {
            driver.findElement(locator);
        }

        return driver.findElement(locator);
    }

}
