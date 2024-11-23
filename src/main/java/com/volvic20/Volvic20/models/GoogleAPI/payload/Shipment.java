package com.volvic20.Volvic20.models.GoogleAPI.payload;

import java.util.List;

public class Shipment {
    private List<Location> pickups;
    private List<Location> deliveries;
    private LoadDemand loadDemands;

    public Shipment(List<Location> pickups, List<Location> deliveries, LoadDemand loadDemands) {
        this.pickups = pickups;
        this.deliveries = deliveries;
        this.loadDemands = loadDemands;
    }

    public List<Location> getPickups() {
        return pickups;
    }

    public void setPickups(List<Location> pickups) {
        this.pickups = pickups;
    }

    public List<Location> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Location> deliveries) {
        this.deliveries = deliveries;
    }

    public LoadDemand getLoadDemands() {
        return loadDemands;
    }

    public void setLoadDemands(LoadDemand loadDemands) {
        this.loadDemands = loadDemands;
    }
}


