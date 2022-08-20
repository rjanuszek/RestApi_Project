package test;

import date.AuthDate;
import date.BookingDate;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.AuthCreateTokenRequest;
import request.PatchBookingRequest;
import request.PostBookingRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class PatchBookingTest {

    private static String token;

    @BeforeAll
    static void setup() {
        JSONObject createToken = AuthDate.getToken();
        token = AuthCreateTokenRequest.getAuthCreateTokenRequest(createToken);
    }

    @Test
    public void patchBookingTest() {
        JSONObject defaultBooking = BookingDate.getDefultBooking();
        Response postBookingRequest = PostBookingRequest.getPostBookingRequest(defaultBooking);
        JsonPath json = postBookingRequest.jsonPath();
        String bookingid = json.getString("bookingid");

        JSONObject patchBooking = new JSONObject();
        patchBooking.put("firstname", "Michał");
        patchBooking.put("lastname", "Nowy");

        Response patchResponse = PatchBookingRequest.patchBookingRequest(patchBooking, token, bookingid);
        JsonPath jsonPath = patchResponse.jsonPath();

        assertThat(jsonPath.getString("firstname")).isEqualTo("Michał");
        assertThat(jsonPath.getString("lastname")).isEqualTo("Nowy");
    }
}