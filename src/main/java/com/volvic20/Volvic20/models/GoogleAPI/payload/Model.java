package com.volvic20.Volvic20.models.GoogleAPI.payload;

import java.util.List;

public class Model {
    private List<Shipment> shipments;
    private List<Vehicle> vehicles;
    private String globalStartTime;
    private String globalEndTime;

    public Model(List<Shipment> shipments, List<Vehicle> vehicles, String globalStartTime, String globalEndTime) {
        this.shipments = shipments;
        this.vehicles = vehicles;
        this.globalStartTime = globalStartTime;
        this.globalEndTime = globalEndTime;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getGlobalStartTime() {
        return globalStartTime;
    }

    public void setGlobalStartTime(String globalStartTime) {
        this.globalStartTime = globalStartTime;
    }

    public String getGlobalEndTime() {
        return globalEndTime;
    }

    public void setGlobalEndTime(String globalEndTime) {
        this.globalEndTime = globalEndTime;
    }
}

