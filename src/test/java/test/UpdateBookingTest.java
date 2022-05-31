package test;

import date.AuthDate;
import date.BookingDate;
import date.UpdateBookingDate;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.AuthCreateTokenRequest;
import request.PostBookingRequest;
import request.UpdateBookingRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateBookingTest {

    private static String token;

    @BeforeAll
    static void setup() {
        JSONObject createToken = AuthDate.getToken();
        token = AuthCreateTokenRequest.getAuthCreateTokenRequest(createToken);
    }

    @Test
    public void updateBookingTest() {
        JSONObject defultBooking = BookingDate.getDefultBooking();
        Response postBookingRequest = PostBookingRequest.getPostBookingRequest(defultBooking);
        JsonPath json = postBookingRequest.jsonPath();
        String bookingId = json.getString("bookingid");

        JSONObject updateBooking = UpdateBookingDate.updateBookingDate();
        Response updateResponse = UpdateBookingRequest.updateBookingRequest(updateBooking, token, bookingId);

        JsonPath jsonPath = updateResponse.jsonPath();
        assertThat(jsonPath.getString("firstname")).isEqualTo("Michał");
        assertThat(jsonPath.getString("additionalneeds")).isEqualTo("Roomservie");
    }
}
