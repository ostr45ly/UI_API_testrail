import backend.APIClient;
import backend.APIException;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
//        RestAssured.baseURI = "https://hilleltest3.testrail.net";
//        String body = "{\n" +
//                "    \"username\": \"test\",\n" +
//                "    \"password\": \"test)\"\n" +
//                "} ";
//
//        String coockie = given().
//                header("Content-Type", "application/json").
//                body(body).
//                when().
//                post("/rest/auth/1/session").
//                then().
//                extract().
//                path("session.value");


        APIClient client = new APIClient("https://hilleltest3.testrail.net");
        client.setUser("a.a.piluck@gmail.com");
        client.setPassword("dr8wJd15aqcI2FOFjpj6");
        JSONObject c = null;
        try {
            c = (JSONObject) client.sendGet("get_case/1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        System.out.println(c.get("title"));
    }

}
