package request;

import date.AdressUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookingIdsRequest {

    public static Response getBookingIdsRequest() {
        return given()
                .when()
                .get(AdressUrl.BASE_URL + AdressUrl.BOOKING_URL)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
