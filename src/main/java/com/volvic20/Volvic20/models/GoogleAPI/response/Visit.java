package com.volvic20.Volvic20.models.GoogleAPI.response;

public class Visit {
    private boolean isPickup;
    private String startTime;
    private String detour;
    private int shipmentIndex;

    public Visit(boolean isPickup, String startTime, String detour, int shipmentIndex) {
        this.isPickup = isPickup;
        this.startTime = startTime;
        this.detour = detour;
        this.shipmentIndex = shipmentIndex;
    }

    public boolean isPickup() {
        return isPickup;
    }

    public void setPickup(boolean pickup) {
        isPickup = pickup;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDetour() {
        return detour;
    }

    public void setDetour(String detour) {
        this.detour = detour;
    }

    public int getShipmentIndex() {
        return shipmentIndex;
    }

    public void setShipmentIndex(int shipmentIndex) {
        this.shipmentIndex = shipmentIndex;
    }
}
