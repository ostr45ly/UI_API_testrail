package backend;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBody;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class SimpleTest {

    String sessionId = "";

    @BeforeTest
    public void login() {
        RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080";

        String body = "{\n" +
                "    \"username\": \"a.a.piluck\",\n" +
                "    \"password\": \"11111111)\"\n" +
                "} ";

        // sessionId =

        ResponseBody response = (ResponseBody) given().
                header("Content-Type", "application/json").
                body(body).
                when().
                post("/rest/auth/1/session").
                then();
        // extract().
        // path("session.value");

        int a = 0;
    }

    @Test(groups = {"functional", "backend"})
    public void subTaskCRUD() throws InterruptedException {


        //Login

        //Create new sub-task

        // Assert

    }

    @Test(groups = {"functional", "backend"})
    public void subTaskCommentCRUD() throws InterruptedException {


    }
}