import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }


    @Test(groups = {"functional"})
    public void subTaskCRUD() throws InterruptedException {

        String parentIssue = "QAAUT-224";
        String subTaskSummary = "Snizhanna test";

        //Login

        LoginPage loginPage = new LoginPage();
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        assertEquals(dashBoardPage.isOnThePage(), true);

        //Create new sub-task

        headerPage.search(parentIssue);

        issuePage.openNewSubTask();
        newIssuePage.fillSummary(subTaskSummary);
        newIssuePage.clickSubmitButton();

        // TODO assert for sub-task title
        issuePage.isSubTaskSummaryPresent(subTaskSummary);

        // TODO assert for sub-task number
        // TODO assert for sub-task assignee
        // TODO assert for sub-task status

        //Delete new sub-task
        issuePage.openSubtask();
        issuePage.shouldSeeSuccessPopUp();
        issuePage.clickMoreButton();
        issuePage.clickDeleteListItem();
        issuePage.deleteSubTask();

        // TODO assert that sub-task title doesn't exist

    }

    @Test(groups = {"functional"})
    public void subTaskCommentCRUD() throws InterruptedException {


    }
}