package test;

import date.AuthDate;
import date.BookingDate;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.AuthCreateTokenRequest;
import request.DeleteBookingRequest;
import request.PostBookingRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingTest {

    private static String token;

    @BeforeAll
    static void setup() {
        JSONObject createToken = AuthDate.getToken();
        token = AuthCreateTokenRequest.getAuthCreateTokenRequest(createToken);
    }

    @Test
    public void deleteBookingTest() {
        JSONObject defultBooking = BookingDate.getDefultBooking();
        Response postBookingRequest = PostBookingRequest.getPostBookingRequest(defultBooking);

        JsonPath jsonPath = postBookingRequest.jsonPath();
        String bookingid = jsonPath.getString("bookingid");

        Response deleteResponse = DeleteBookingRequest.deleteBookingRequest(token, bookingid);
        assertThat(deleteResponse.getStatusCode()).isEqualTo(201);
    }
}
