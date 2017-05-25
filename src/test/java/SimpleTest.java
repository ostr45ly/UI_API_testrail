import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.NewIssuePage;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

//    @Parameters({"myParam"})
//    @Test(groups = {"functest"})
//    public void testMethod1(String myParam) {
//        // System.out.println("I got a parameter: " + myParam);
//        Assert.assertTrue(false);
//    }

    @Test(groups = {"functional"})
    public void subTaskCRUD() throws InterruptedException {

        //Login

        LoginPage loginPage = new LoginPage();
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();

        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        //Create new sub-task

        headerPage.search("QAAUT-224");
        newIssuePage.openNewSubTask();
        newIssuePage.fillSummary("Snizhanna test");
        newIssuePage.clickSubmitButton();

        //Delete new sub-task
        newIssuePage.openSubtask();
        newIssuePage.shouldSeeSuccessPopUp();
        newIssuePage.clickMoreButton();
        newIssuePage.clickDeleteListItem();
        newIssuePage.deleteSubtask();
    }
}