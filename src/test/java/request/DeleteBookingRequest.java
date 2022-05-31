package request;

import date.AdressUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    public static Response deleteBookingRequest(String token, String bookingid) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .when()
                .delete(AdressUrl.BASE_URL + AdressUrl.BOOKING_URL + "/" + bookingid)
                .then()
                .extract()
                .response();
    }
}
