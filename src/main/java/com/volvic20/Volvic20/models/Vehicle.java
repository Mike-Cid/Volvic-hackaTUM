package com.volvic20.Volvic20.models;

public class Vehicle {
    private String id;
    private float coordX;
    private float coordY;
    private boolean isAvailable;
    //private int vehicleSpeed;
    private String customerId;
    //private int remainingTravelTime;
    //private int distanceTravelled;
    //private int activeTime;
    //private int numberOfTrips;


    public Vehicle(String id, float coordX, float coordY, String customerId) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.isAvailable = true;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
