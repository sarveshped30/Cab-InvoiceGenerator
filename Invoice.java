package com.bridgelabz.invoicegenerator;

public class Invoice {

    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    public double farePrize(double kilometers, int minutes) {
        double cost = COST_PER_KILOMETER*kilometers + COST_PER_MINUTE*minutes;
        if(cost < 5) {
            return MINIMUM_FARE;
        }
        return cost;
    }
}
