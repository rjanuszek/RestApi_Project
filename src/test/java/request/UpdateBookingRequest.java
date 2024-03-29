package request;

import date.AddressUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class UpdateBookingRequest {

    public static Response updateBookingRequest(JSONObject updateBooking, String token, String bookingId) {
        return given()
                .contentType(ContentType.JSON)
                .body(updateBooking.toString())
                .header("Cookie", "token=" + token)
                .when()
                .put(AddressUrl.BASE_URL + AddressUrl.BOOKING_URL + "/" + bookingId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}