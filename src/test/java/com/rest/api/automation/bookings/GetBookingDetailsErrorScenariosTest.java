package com.rest.api.automation.bookings;

import com.aventstack.extentreports.Status;
import com.rest.api.automation.base.RestTestBase;
import com.rest.api.automation.utils.ConfigHelper;
import com.rest.api.automation.utils.TestConstants;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingDetailsErrorScenariosTest extends RestTestBase {
    List<String[]> data = csv.readData_CSV(TestConstants.BOOKING_CSV);
    Response response;
    String bookingId = csv.getSpecificCSVData(data, 0, 1);

    @Test
    public void verifyGetBookingDetailsWithInvalidMethod() {
        extentLog.info(customReport(methodName + ": This test verifies Get Booking Details Error Response With Invalid Method "));
        response = cm.doDELETE(ConfigHelper.returnPropVal("config", "booking") + bookingId);
        extentLog.log(Status.INFO, customReport("Click here to the View the Request", requestWriter.toString()));
        extentLog.log(Status.INFO, customReport("HITS Endpoint to verify Booking Details Error Response With Invalid Method -- click to see the Response ",
                response.asString()));
        checkErrorResponse(response, HttpStatus.SC_FORBIDDEN);
    }
}
