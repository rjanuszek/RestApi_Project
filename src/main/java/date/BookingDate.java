package date;

import org.json.JSONObject;

public class BookingDate {

    public static JSONObject getDefultBooking() {

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2022-05-25");
        bookingdates.put("checkout", "2022-06-01");

        JSONObject newBooking = new JSONObject();
        newBooking.put("firstname", "Rafaela");
        newBooking.put("lastname", "Testowa");
        newBooking.put("totalprice", 12345);
        newBooking.put("depositpaid", true);
        newBooking.put("bookingdates", bookingdates);
        newBooking.put("additionalneeds", "Breakfast");

        return newBooking;
    }
}
