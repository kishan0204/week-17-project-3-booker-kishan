package com.restful.booker.crudtest;

import com.restful.booker.model.UpdateBookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutTest extends TestBase {


    @Test
    public void updateCurrentBooking() {

        UpdateBookingPojo.BookingDates date = new UpdateBookingPojo.BookingDates();
        date.setCheckin("2023-02-01");
        date.setCheckout("2023-02-11");

        UpdateBookingPojo updateBookingPojobookingPojo = new UpdateBookingPojo();

        updateBookingPojobookingPojo.setFirstname("kishan");
        updateBookingPojobookingPojo.setLastname("malaviya");
        updateBookingPojobookingPojo.setTotalprice(150);
        updateBookingPojobookingPojo.setDepositpaid(true);
        updateBookingPojobookingPojo.setBookingdates(date);
        updateBookingPojobookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=fd32b17c81c8fc1")
                .pathParam("id", 3843)
                .body(updateBookingPojobookingPojo)
                .when().put("{id}");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
