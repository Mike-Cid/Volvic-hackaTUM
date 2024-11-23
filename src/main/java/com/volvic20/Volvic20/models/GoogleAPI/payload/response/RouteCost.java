package com.volvic20.Volvic20.models.GoogleAPI.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouteCost {
    @JsonProperty("model.vehicles.cost_per_kilometer")
    private float modelVehiclesCostPerKilometer;

    public float getModelVehiclesCostPerKilometer() {
        return modelVehiclesCostPerKilometer;
    }

    public void setModelVehiclesCostPerKilometer(float modelVehiclesCostPerKilometer) {
        this.modelVehiclesCostPerKilometer = modelVehiclesCostPerKilometer;
    }

    public RouteCost(float modelVehiclesCostPerKilometer) {
        this.modelVehiclesCostPerKilometer = modelVehiclesCostPerKilometer;
    }
}
