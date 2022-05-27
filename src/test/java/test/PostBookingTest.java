package test;

import date.BookingDate;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import request.PostBookingRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class PostBookingTest {

    @Test
    public void postBookingTest() {
        JSONObject defultBooking = BookingDate.getDefultBooking();
        Response postBooking = PostBookingRequest.postBookingRequest(defultBooking);
        JsonPath jsonPath = postBooking.jsonPath();
        assertThat(jsonPath.getString("booking.firstname")).isEqualTo("Rafaela");
    }
}
