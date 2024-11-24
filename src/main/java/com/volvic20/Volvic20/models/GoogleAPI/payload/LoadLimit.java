package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class LoadLimit {
    private WeightKg weightKg;

    public LoadLimit(WeightKg weightKg) {
        this.weightKg = weightKg;
    }

    public WeightKg getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(WeightKg equipmentRackStorage) {
        this.weightKg = equipmentRackStorage;
    }
}
