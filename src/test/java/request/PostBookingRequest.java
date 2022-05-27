package request;

import date.AdressUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    public static Response getPostBookingRequest(JSONObject newBooking) {
        return given()
                .contentType(ContentType.JSON)
                .body(newBooking.toString())
                .when()
                .post(AdressUrl.BASE_URL + AdressUrl.BOOKING_URL)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
