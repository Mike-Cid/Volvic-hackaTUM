package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class Vehicle {
    private ArrivalLocation startLocation;
    private int costPerKilometer;
    private LoadLimit loadLimits;

    public Vehicle(ArrivalLocation startLocation, int costPerKilometer, LoadLimit loadLimits) {
        this.startLocation = startLocation;
        this.costPerKilometer = costPerKilometer;
        this.loadLimits = loadLimits;
    }

    public ArrivalLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(ArrivalLocation startLocation) {
        this.startLocation = startLocation;
    }

    public double getCostPerKilometer() {
        return costPerKilometer;
    }

    public void setCostPerKilometer(int costPerKilometer) {
        this.costPerKilometer = costPerKilometer;
    }

    public LoadLimit getLoadLimits() {
        return loadLimits;
    }

    public void setLoadLimits(LoadLimit loadLimits) {
        this.loadLimits = loadLimits;
    }
}
