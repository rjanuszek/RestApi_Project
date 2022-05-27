package date;

import org.json.JSONObject;

public class UpdateBookingDate {

    public static JSONObject updateBookingDate(){

        JSONObject newBookingDates = new JSONObject();
        newBookingDates.put("checkin", "2022-05-25");
        newBookingDates.put("checkout", "2022-06-01");

        JSONObject updateBooking = new JSONObject();
        updateBooking.put("firstname", "Agnieszka");
        updateBooking.put("lastname", "Nowak");
        updateBooking.put("totalprice", 54321);
        updateBooking.put("depositpaid", true);
        updateBooking.put("bookingdates", newBookingDates);
        updateBooking.put("additionalneeds", "Roomservice");

        return updateBooking;
    }

}
