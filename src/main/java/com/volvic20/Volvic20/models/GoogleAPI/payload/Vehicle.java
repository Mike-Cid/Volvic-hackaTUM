package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class Vehicle {
    private ArrivalLocation startLocation;
    private ArrivalLocation endLocation;
    private int costPerKilometer;
    private LoadLimit loadLimits;

    public Vehicle(ArrivalLocation startLocation, ArrivalLocation endLocation, int costPerKilometer, LoadLimit loadLimits) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.costPerKilometer = costPerKilometer;
        this.loadLimits = loadLimits;
    }

    public ArrivalLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(ArrivalLocation startLocation) {
        this.startLocation = startLocation;
    }

    public ArrivalLocation getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(ArrivalLocation endLocation) {
        this.endLocation = endLocation;
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
