package com.rest.api.automation.requestBuilder;

import org.json.JSONObject;

public class Bookings {

    public JSONObject CreateBookingBody(String firstName, String lastName, String totalPrice, String depositPaid,
                                        String additionalNeeds, String checkIn, String checkOut) {

        JSONObject body = new JSONObject();
        body.put("firstname", firstName);
        body.put("lastname", lastName);
        body.put("totalprice", Integer.parseInt(totalPrice));
        body.put("depositpaid", Boolean.parseBoolean(depositPaid));
        body.put("additionalneeds", additionalNeeds);
        body.put("bookingdates", getDates(checkIn, checkOut));
        return body;
    }

    private JSONObject getDates(String checkIn, String checkOut) {
        JSONObject dates = new JSONObject();
        dates.put("checkin", checkIn);
        dates.put("checkout", checkOut);
        return dates;
    }
}