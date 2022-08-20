package request;

import date.AddressUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class PatchBookingRequest {

    public static Response patchBookingRequest(JSONObject newObject, String token, String bookingId) {
        return given()
                .contentType(ContentType.JSON)
                .body(newObject.toString())
                .header("Cookie", "token=" + token)
                .when()
                .patch(AddressUrl.BASE_URL + AddressUrl.BOOKING_URL + "/" + bookingId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}