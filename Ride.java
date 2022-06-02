package com.bridgelabz.invoicegenerator;

/* Class ride for storing info of all the rides */
public class Ride {
    public final double kilometers;
    public final int minutes;
    public final String typeOfRide;

    /* Parameterized constructor for initializing variables */
    public Ride(double kilometers, int minutes, String typeOfRide) {
        this.kilometers = kilometers;
        this.minutes = minutes;
        this.typeOfRide = typeOfRide;
    }
}
