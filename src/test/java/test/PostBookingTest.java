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
        JSONObject defaultBooking = BookingDate.getDefultBooking();
        Response postBooking = PostBookingRequest.getPostBookingRequest(defaultBooking);
        JsonPath jsonPath = postBooking.jsonPath();
        assertThat(jsonPath.getString("booking.firstname")).isEqualTo("Rafaela");
    }
}
