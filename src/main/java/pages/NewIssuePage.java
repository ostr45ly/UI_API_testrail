package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.RemoteDriverManager;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;

    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("Snizhanna test");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");


    public NewIssuePage() {
        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();
    }

    public NewIssuePage openNewSubTask() throws InterruptedException {
        waitToBePresent(newSubtaskButtonLocator);
        driver.findElement(newSubtaskButtonLocator).click();
        return this;
    }

    public NewIssuePage fillSummary(String summary) {
        waitToBePresent(summaryLocator);
        driver.findElement(summaryLocator).sendKeys(summary);
        return this;
    }

    public NewIssuePage clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    public NewIssuePage shouldSeeSuccessPopUp() {

        waitToBePresent(successPopUp);
        return this;
    }

    public NewIssuePage openSubtask() throws InterruptedException {

        waitToBePresent(subtaskLocator);
        WebElement element = driver.findElement(subtaskLocator);
        element.click();

        return this;
    }

    public NewIssuePage clickMoreButton() {

        waitToBePresent(moreButtonLocator);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");

        WebElement element = findElement(moreButtonLocator);
        element.click();
        return this;
    }

    public NewIssuePage clickDeleteListItem() {
        driver.findElement(deleteListItemLocator).click();
        return this;
    }

    public NewIssuePage deleteSubtask() {
        waitToBePresent(deleteButtonLocator);
        driver.findElement(deleteButtonLocator).click();
        return this;
    }

}

