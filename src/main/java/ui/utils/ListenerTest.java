package ui.utils;

import backend.APIClient;
import backend.APIException;
import backend.AnnotationTest;
import backend.PropertyReader;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import ui.pages.BasePage;
import utils.TestCase;

import java.io.*;
import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ListenerTest implements ITestListener {

    final static Logger logger = Logger.getLogger(ListenerTest.class);

    public void onTestStart(ITestResult iTestResult) {
        String[] groups = iTestResult.getMethod().getGroups();

        for (String group : groups) {
            if (group.contains("ui")) {
                String testCaseName = iTestResult.getName();
                String browserName = iTestResult.getTestContext().getCurrentXmlTest().getParameter("browserName");
                String implicitWaitInSeconds = iTestResult.getTestContext().getCurrentXmlTest().getParameter("implicitWaitInSeconds");
                WebDriver driver = RemoteWebDriverFactory.createInstance(browserName);

                RemoteDriverManager.setWebDriver(driver);
                logger.info("TEST: " + testCaseName + " STARTED on browserName=" + browserName);

                changeImplicitWaitValue(driver, Integer.parseInt(implicitWaitInSeconds));

                // For slow internet and slow test suite, slower than rest of the tests

                if (group.contains("slow")) {
                    changeImplicitWaitValue(driver, Integer.parseInt(implicitWaitInSeconds) + 50);
                }
            }
        }
    }

    public void onTestSuccess(ITestResult iTestResult) {

        String testCaseName = iTestResult.getName();
        String annotactestCaseId = "";
        logger.info("TEST: " + testCaseName + " PASSED");

        AnnotationTest aAnnotationTest=new AnnotationTest();
        annotactestCaseId =aAnnotationTest.retrievesId(iTestResult);
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.test(annotactestCaseId ,"1");

    }

    public void onTestFailure(ITestResult iTestResult) {

        String annotactestCaseId = "";
        logger.error("TEST: " + iTestResult.getName() + " FAILED");
        logger.error(iTestResult.getThrowable().fillInStackTrace());

        AnnotationTest aAnnotationTest=new AnnotationTest();
        annotactestCaseId =aAnnotationTest.retrievesId(iTestResult);
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.test(annotactestCaseId ,"5");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("TEST: " + iTestResult.getName() + " SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        // Invoked after the test class is instantiated and before any configuration method is called.
    }

    public void onFinish(ITestContext iTestContext) {
        // Invoked after all the tests have run and all their Configuration methods have been called.
        WebDriver driver = RemoteDriverManager.getDriver();

        if (driver != null) {
            changeImplicitWaitValue(driver, Integer.parseInt(BasePage.defaultImplicitWaitInSeconds));
            logger.info("Closing browser window");
//            RemoteDriverManager.closeDriver();
        }
    }

    private void changeImplicitWaitValue(WebDriver driver, int implicitWaitValueInSeconds) {
        driver.manage().timeouts().implicitlyWait(implicitWaitValueInSeconds, TimeUnit.SECONDS);
        logger.info("IMPLICIT WAIT WAS CHANGED TO: " + implicitWaitValueInSeconds);
    }


}
