package com.volvic20.Volvic20.models.GoogleAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cost {
    @JsonProperty("model.vehicles.cost_per_kilometer")
    private float modelVehiclesCostPerKilometer;

    public Cost(float modelVehiclesCostPerKilometer) {
        this.modelVehiclesCostPerKilometer = modelVehiclesCostPerKilometer;
    }

    public float getModelVehiclesCostPerKilometer() {
        return modelVehiclesCostPerKilometer;
    }

    public void setModelVehiclesCostPerKilometer(float modelVehiclesCostPerKilometer) {
        this.modelVehiclesCostPerKilometer = modelVehiclesCostPerKilometer;
    }

}