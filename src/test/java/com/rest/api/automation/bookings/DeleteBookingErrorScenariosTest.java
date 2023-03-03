package com.rest.api.automation.bookings;

import com.aventstack.extentreports.Status;
import com.rest.api.automation.base.RestTestBase;
import com.rest.api.automation.utils.ConfigHelper;
import com.rest.api.automation.utils.TestConstants;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteBookingErrorScenariosTest extends RestTestBase {
    List<String[]> data = csv.readData_CSV(TestConstants.BOOKING_CSV);
    String bookingId = csv.getSpecificCSVData(data, 0, 1);
    Response response;

    @Test
    public void verifyDeleteBookingWithInvalidMethod() {
        extentLog.info(customReport(methodName + ": This test verifies delete booking error response with invalid RequestMethod"));
        response = cm.doDELETE(ConfigHelper.returnPropVal("config", "booking")+bookingId);
        extentLog.log(Status.INFO, customReport("Click here to the View the Request", requestWriter.toString()));
        extentLog.log(Status.INFO, customReport("HITS Endpoint to verify delete booking error response with invalid RequestMethod-- click to see the Response ",
                response.asString()));
        checkErrorResponse(response, HttpStatus.SC_FORBIDDEN);
    }
}