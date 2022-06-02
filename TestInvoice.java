package com.bridgelabz.invoicegenerator;

import org.junit.Assert;
import org.junit.Test;

/* Class for creating test methods */
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
    public void GivenMultipleRidesShouldReturnTotalFarePrize() {
        Ride[] rides = { new Ride(2.4, 15, "Normal"),
                         new Ride(0.2, 1, "Premium") };
        double result = invoice.totalFarePrize(rides);
        Assert.assertEquals(44, result,0.0);
    }

    @Test
    public void GivenMultipleRidesShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(2.4, 15, "Normal"),
                        new Ride(0.2, 1, "Normal") };
        InvoiceSummary summary = invoice.invoiceSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 44);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void GivenUserIdShouldReturnInvoiceSummary() {
        Ride[] user1 = { new Ride(2.4, 15, "Normal"),
                        new Ride(0.2, 1, "Normal") };
        Ride[] user2 = { new Ride(3.4, 15, "premium"),
                        new Ride(0.2, 1, "Normal") };
        InvoiceSummary summary = invoice.invoiceSummary(user2);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 54);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void GivenUserId_ShouldReturnInvoiceSummary_BasedOnTypeOfRide() {
        Ride[] user1 = { new Ride(2.4, 15, "Premium"),
                        new Ride(0.2, 1, "Normal") };
        Ride[] user2 = { new Ride(3.4, 15, "Premium"),
                        new Ride(0.2, 1, "Premium") };
        InvoiceSummary summary = invoice.newInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,71);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}

