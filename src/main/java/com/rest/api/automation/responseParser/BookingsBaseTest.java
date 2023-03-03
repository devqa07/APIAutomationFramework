package com.rest.api.automation.responseParser;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class BookingsBaseTest {
    JSONObject json;

    // Validate Create Booking Response
    public void validateCreateBookingResponse(Response response, String firstName, String lastName, String totalPrice, String depositPaid,
                                              String additionalNeeds, String checkIn, String checkOut) {
        json = new JSONObject(response.asString());
        JSONObject booking = json.getJSONObject("booking");
        Assert.assertNotNull(json.getInt("bookingid"));
        Assert.assertEquals(booking.getString("firstname"), firstName);
        Assert.assertEquals(booking.getString("lastname"), lastName);
        Assert.assertEquals(booking.getInt("totalprice"), Integer.parseInt(totalPrice));
        Assert.assertEquals(booking.getBoolean("depositpaid"), Boolean.parseBoolean(depositPaid));
        Assert.assertEquals(booking.getJSONObject("bookingdates").getString("checkin"), checkIn);
        Assert.assertEquals(booking.getJSONObject("bookingdates").getString("checkout"), checkOut);
        Assert.assertEquals(booking.getString("additionalneeds"), additionalNeeds);
    }

    // Validate Get Booking Response
    public void validateGetBookingResponse(Response response) {
        json = new JSONObject(response.asString());
        Assert.assertNotNull(json.getString("firstname"));
        Assert.assertNotNull(json.getString("lastname"));
        Assert.assertNotNull(json.getInt("totalprice"));
        Assert.assertNotNull(json.getBoolean("depositpaid"));
        Assert.assertNotNull(json.getJSONObject("bookingdates").getString("checkin"));
        Assert.assertNotNull(json.getJSONObject("bookingdates").getString("checkout"));
    }
}