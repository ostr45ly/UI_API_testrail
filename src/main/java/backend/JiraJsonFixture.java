package backend;

import org.json.simple.JSONObject;

public class JiraJsonFixture {

    public String generateJSONForLogin() {
        JSONObject credentials = new JSONObject();
        credentials.put("username", "a.a.piluck");
        credentials.put("password", "11111111)");

        return credentials.toJSONString();
    }
}
