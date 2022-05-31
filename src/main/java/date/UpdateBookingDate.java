package date;

import org.json.JSONObject;

public class UpdateBookingDate {

    public static JSONObject updateBookingDate() {

        JSONObject newBookingDates = new JSONObject();
        newBookingDates.put("checkin", "2018-01-01");
        newBookingDates.put("checkout", "2019-01-01");

        JSONObject updateBooking = new JSONObject();
        updateBooking.put("firstname", "Michał");
        updateBooking.put("lastname", "Kowalski");
        updateBooking.put("totalprice", 54321);
        updateBooking.put("depositpaid", true);
        updateBooking.put("bookingdates", newBookingDates);
        updateBooking.put("additionalneeds", "Roomservie");

        return updateBooking;
    }
}
