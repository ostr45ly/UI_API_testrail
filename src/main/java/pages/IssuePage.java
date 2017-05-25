package pages;

import org.openqa.selenium.By;
import utils.RemoteDriverManager;

public class IssuePage extends BasePage {

    private HeaderPage headerPage;

    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("Snizhanna test");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");


    private String subTaskSummary = "//*[contains(text(),'%s')]";
//    private By subTaskText = By.xpath("//*[contains(text(),'%s')]");


    public IssuePage() {

        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();

    }

    public IssuePage openNewSubTask() throws InterruptedException {

        waitToBePresent(newSubtaskButtonLocator);
        driver.findElement(newSubtaskButtonLocator).click();

        return this;
    }

    public IssuePage shouldSeeSuccessPopUp() {

        waitToBePresent(successPopUp);

        return this;
    }

    public IssuePage openSubtask() throws InterruptedException {

        waitToBePresentAndClick(subtaskLocator);

        return this;
    }

    public IssuePage clickMoreButton() {

        waitToBePresentAndClick(moreButtonLocator);

        return this;
    }

    public IssuePage clickDeleteListItem() {

        waitToBePresentAndClick(deleteListItemLocator);

        return this;
    }

    public IssuePage deleteSubTask() {

        waitToBePresentAndClick(deleteButtonLocator);

        return this;
    }

    public boolean isSubTaskSummaryPresent(String title) {

        String subTaskSummaryXPath = String.format(subTaskSummary, title);
        return waitToBePresentAndContainsText(By.xpath(subTaskSummaryXPath), title);

    }

}

