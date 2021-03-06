package com.bridgelabz.invoicegenerator;

/* Class for creating invoice summary */
public class InvoiceSummary {
    /* Declaring variables and making private using private access specifier */
    private final int numberOfRides;
    private final double totalFarePrize;
    private final double averageFare;

    /* Parameterized constructor for initializing variables */
    public InvoiceSummary(int numberOfRides, double totalFarePrize) {
        this.numberOfRides = numberOfRides;
        this.totalFarePrize = totalFarePrize;
        this.averageFare = this.totalFarePrize/this.numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return numberOfRides == summary.numberOfRides && Double.compare(summary.totalFarePrize, totalFarePrize) == 0 && Double.compare(summary.averageFare, averageFare) == 0;
    }
}
