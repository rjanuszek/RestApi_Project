package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import request.GetBookingIdsRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingIdsTest {

    @Test
    public void getBookingIdsTest() {
        Response bookingIdsRequest = GetBookingIdsRequest.getBookingIdsRequest();
        JsonPath jsonPath = bookingIdsRequest.jsonPath();
        assertThat(jsonPath.getList("bookingid")).size().isPositive();
    }
}
