package pages;

import org.openqa.selenium.By;
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
        waitToBePresentAndClick(subtaskLocator);

        return this;
    }

    public NewIssuePage clickMoreButton() {

        waitToBePresentAndClick(moreButtonLocator);

        return this;
    }

    public NewIssuePage clickDeleteListItem() {

        waitToBePresentAndClick(deleteListItemLocator);

        return this;
    }

    public NewIssuePage deleteSubTask() {

        waitToBePresentAndClick(deleteButtonLocator);

        return this;
    }

}

