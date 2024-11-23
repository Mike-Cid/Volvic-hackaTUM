package com.volvic20.Volvic20.models;

public class Customer {
    private String id;
    private float coordX;
    private float coordY;
    //private float destinationX;
    //private float destinationY;
    private boolean awaitingService;


    public Customer(String id, float coordX, float coordY) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.awaitingService = true;
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

    public boolean isAwaitingService() {
        return awaitingService;
    }

    public void setAwaitingService(boolean awaitingService) {
        this.awaitingService = awaitingService;
    }

}
