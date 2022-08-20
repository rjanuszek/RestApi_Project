package request;

import date.AddressUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookingIdsRequest {

    public static Response getBookingIdsRequest() {
        return given()
                .when()
                .get(AddressUrl.BASE_URL + AddressUrl.BOOKING_URL)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
