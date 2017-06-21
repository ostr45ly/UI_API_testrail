package backend;

import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by macbook on 6/15/17.
 */
public class PropertyReader {

    // TODO method which reads all properties from specified file

    public void test(String testId,String statusId) {

        Properties prop = new Properties();
        FileInputStream input = null;
        String testRunId = "";
        String pathTrail = "";
        String userTrail="" ;
        String passwordTrail ="";

        try {

            try {
                input = new FileInputStream("testrun.properties");
                try {
                    prop.load(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            testRunId = prop.getProperty("test_run_id");
            pathTrail = prop.getProperty("path_t");
            userTrail = prop.getProperty("user_trail");
            passwordTrail = prop.getProperty("password_trail");

            // TODO get configuration name if not empty

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        APIClient client = new APIClient(pathTrail);
        client.setUser(userTrail);
        client.setPassword(passwordTrail);

        JSONObject response = null;

        JSONObject body = new JSONObject();
        body.put("status_id", statusId);


        try {
            response = (JSONObject) client.sendPost("add_result_for_case/" + testRunId + "/" + testId, body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }


    }


}
