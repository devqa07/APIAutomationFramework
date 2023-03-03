package com.rest.api.automation.bookings;

import com.aventstack.extentreports.Status;
import com.rest.api.automation.responseParser.BookingsBaseTest;
import com.rest.api.automation.base.RestTestBase;
import com.rest.api.automation.requestBuilder.Bookings;
import com.rest.api.automation.utils.ConfigHelper;
import com.rest.api.automation.utils.TestConstants;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

public class CreateBookingSuccessScenariosTest extends RestTestBase {
    BookingsBaseTest bs = new BookingsBaseTest();
    Bookings bookingReq = new Bookings();
    List<String[]> data = csv.readData_CSV(TestConstants.BOOKING_CSV);
    String body, firstName = csv.getSpecificCSVData(data, 1, 1), lastName = csv.getSpecificCSVData(data, 2, 1),
            totalPrice = csv.getSpecificCSVData(data, 3, 1), depositPaid = csv.getSpecificCSVData(data, 4, 1),
            additionalNeeds = csv.getSpecificCSVData(data, 5, 1), checkIn = csv.getSpecificCSVData(data, 6, 1),
            checkOut = csv.getSpecificCSVData(data, 7, 1);
    Response response;

    @Test
    public void verifyCreateBooking() {
        extentLog.info(customReport(methodName + ": This test Creates a new booking"));
        body = bookingReq.CreateBookingBody(firstName, lastName, totalPrice, depositPaid, additionalNeeds, checkIn, checkOut).toString();
        response = cm.doPOST(ConfigHelper.returnPropVal("config", "booking"), body);
        extentLog.log(Status.INFO, customReport("Click here to the View the Request", requestWriter.toString()));
        extentLog.log(Status.INFO, customReport("HITS Endpoint to verify create a new booking-- click to see the Response ",
                response.asString()));
        checkSuccessResponse(response, HttpStatus.SC_OK);
        bs.validateCreateBookingResponse(response, firstName, lastName, totalPrice, depositPaid, additionalNeeds, checkIn, checkOut);
    }
}
