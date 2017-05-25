import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.NewIssuePage;

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

        loginPage.open();
        loginPage.isOnThePage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        dashBoardPage.isOnThePage();

        //Create new sub-task

        headerPage.search(parentIssue);
        newIssuePage.openNewSubTask();
        newIssuePage.fillSummary(subTaskSummary);
        newIssuePage.clickSubmitButton();

        //Delete new sub-task
        newIssuePage.openSubtask();
        newIssuePage.shouldSeeSuccessPopUp();
        newIssuePage.clickMoreButton();
        newIssuePage.clickDeleteListItem();
        newIssuePage.deleteSubTask();
    }
}