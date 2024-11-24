package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class LoadLimit {
    private WeightKg_Vehicle weightKg;

    public LoadLimit(WeightKg_Vehicle weightKg) {
        this.weightKg = weightKg;
    }

    public WeightKg_Vehicle getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(WeightKg_Vehicle weightKg) {
        this.weightKg = weightKg;
    }
}
