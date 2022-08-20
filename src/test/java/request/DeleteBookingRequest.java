package request;

import date.AddressUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    public static Response deleteBookingRequest(String token, String bookingid) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .when()
                .delete(AddressUrl.BASE_URL + AddressUrl.BOOKING_URL + "/" + bookingid)
                .then()
                .extract()
                .response();
    }
}
