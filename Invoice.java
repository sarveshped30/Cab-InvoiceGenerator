/* Cab invoice generator assignment using TDD approach
 * RFP assignment
 * Author: sarvesh pednekar*/
package com.bridgelabz.invoicegenerator;

/* Invoice class contains methods calculating fare prizes for given condition and generate invoice */
public class Invoice {
    /* Initializing constant variables */
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    private static final double PREMIUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_MINUTES = 2;
    private static final double MINIMUM_PREMIUM_FARE = 20;

    /* Method for calculating fare prize for one ride */
    public double farePrize(double kilometers, int minutes) {
        // Calculating cost of ride
        double cost = COST_PER_KILOMETER*kilometers + COST_PER_MINUTE*minutes;

        // If cost_of_ride is less than 5 rs than returning minimum_fare_prize
        if(cost < 5) {
            return MINIMUM_FARE;
        }
        return cost;
    }

    /* Method returns fare prize of for premium rides */
    public double premiumFarePrize(double kilometers, int minutes) {
        // Calculating cost of ride
        double cost = PREMIUM_COST_PER_KILOMETER * kilometers + PREMIUM_COST_PER_MINUTES * minutes;

        // If cost_of_ride is less than 20 rs than returning minimum_fare_prize
        if(cost < 20) {
            return MINIMUM_PREMIUM_FARE;
        }
        return cost;
    }

    /* Method for calculating fare prize for multiple rides */
    public double totalFarePrize(Ride[] rides) {
        // initializing total_fare_prize to zero
        double totalFarePrize = 0;

        // Iteration rides to calculate total_fare_prize
        for(Ride ride : rides) {
            totalFarePrize += this.farePrize(ride.kilometers, ride.minutes);
        }
        return totalFarePrize;
    }

    /* Method for returning invoice summary for given userID */
    public InvoiceSummary invoiceSummary(Ride[] userID) {
        // initializing total_fare_prize to zero
        double totalFarePrize = 0;

        // Iteration rides to calculate total_fare_prize
        for(Ride ride : userID) {
            totalFarePrize += this.farePrize(ride.kilometers, ride.minutes);
        }
        return new InvoiceSummary(userID.length, totalFarePrize);
    }

    /* Method returns invoice summary considering type of rides */
    public InvoiceSummary newInvoiceSummary(Ride[] userId) {
        // initializing total_fare_prize to zero
        double totalFarePrize = 0;

        //iterating the rides
        for(Ride rides : userId) {
            // Evaluating total_fare_prize on the basis of type_of_rides
            if(rides.typeOfRide.equals("Premium")) {
                totalFarePrize += premiumFarePrize(rides.kilometers, rides.minutes);
            } else {
                totalFarePrize += farePrize(rides.kilometers, rides.minutes);
            }
        }
        return new InvoiceSummary(userId.length, totalFarePrize);
    }
}
