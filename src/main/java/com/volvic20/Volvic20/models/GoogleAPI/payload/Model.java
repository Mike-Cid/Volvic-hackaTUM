package com.volvic20.Volvic20.models.GoogleAPI.payload;

import java.util.List;

public class Model {
    private List<Shipment> shipments;
    private List<Vehicle> vehicles;

    public Model(List<Shipment> shipments, List<Vehicle> vehicles) {
        this.shipments = shipments;
        this.vehicles = vehicles;
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
}

