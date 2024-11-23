package com.volvic20.Volvic20.models.TSystemsAPI;

public class Vehicle {
    private String id;
    private float coordX;
    private float coordY;
    private float vehicleSpeed;
    private String customerId;
    private float remainingTravelTime;
    private float distanceTravelled;
    private float activeTime;
    private int numberOfTrips;

    public Vehicle(String id, float coordX, float coordY, float vehicleSpeed, String customerId, float remainingTravelTime, float distanceTravelled, float activeTime, int numberOfTrips) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.vehicleSpeed = vehicleSpeed;
        this.customerId = customerId;
        this.remainingTravelTime = remainingTravelTime;
        this.distanceTravelled = distanceTravelled;
        this.activeTime = activeTime;
        this.numberOfTrips = numberOfTrips;
    }

    public Vehicle(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Vehicle(){}

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


    public float getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(float vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public float getRemainingTravelTime() {
        return remainingTravelTime;
    }

    public void setRemainingTravelTime(float remainingTravelTime) {
        this.remainingTravelTime = remainingTravelTime;
    }

    public float getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(float distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public float getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(float activeTime) {
        this.activeTime = activeTime;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }
}
