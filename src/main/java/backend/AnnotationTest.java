package backend;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import utils.TestCase;

import java.lang.annotation.Annotation;

/**
 * Created by oliva on 21.06.2017.
 */
public class AnnotationTest {
    public String retrievesId(ITestResult iTestResult){


        ITestNGMethod method = iTestResult.getMethod();

        Class obj = method.getRealClass();
        Annotation annotation = null;

        try {
            annotation = obj.getDeclaredMethod(method.getMethodName()).getAnnotation(TestCase.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        TestCase testerInfo = (TestCase) annotation;
        String testCaseId = testerInfo.id();
        System.out.printf("ANNOTATION: " + testerInfo.id());
        return testCaseId;

    }


}
