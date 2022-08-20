package request;

import date.AddressUrl;
import date.AddressUrl;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthCreateTokenRequest {

    @Test
    public static String getAuthCreateTokenRequest(JSONObject createToken) {
        return given()
                .contentType(ContentType.JSON)
                .body(createToken.toString())
                .when()
                .post(AddressUrl.BASE_URL + AddressUrl.AUTH_URL)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("token");
    }
}
