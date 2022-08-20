package date;

import org.json.JSONObject;

public class AuthDate {

    public static JSONObject getToken() {

        JSONObject createToken = new JSONObject();
        createToken.put("username", "admin");
        createToken.put("password", "password123");

        return createToken;
    }
}