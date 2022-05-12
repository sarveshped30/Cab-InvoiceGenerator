package com.bridgelabz.invoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class TestInvoice {

    Invoice invoice = new Invoice();
    @Test
    public void GivenDistanceAndTimeWhenCalculatedShouldReturnTotalFareCost(){
        double kilometers = 2.4;
        int minutes = 15;
        double result = invoice.farePrize(kilometers,minutes);
        Assert.assertEquals(39,result,0.0);
    }

    @Test
    public void GivenMinimumDistanceAndTimeShouldReturnMinimumFare() {
        double kilometers = 0.2;
        int minutes = 1;
        double result = invoice.farePrize(kilometers,minutes);
        Assert.assertEquals(5,result,0.0);
    }

    @Test
    public void GivenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = { new Ride(2.4, 15),
                         new Ride(0.2, 1) };
        double result = invoice.totalFarePrize(rides);
        Assert.assertEquals(44, result,0.0);
    }
}

