package com.volvic20.Volvic20.models.TSystemsAPI;

import java.util.List;

public class Matchings {
    private List<Matching> vehicles;

    public Matchings(List<Matching> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Matching> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Matching> vehicles) {
        this.vehicles = vehicles;
    }
}
