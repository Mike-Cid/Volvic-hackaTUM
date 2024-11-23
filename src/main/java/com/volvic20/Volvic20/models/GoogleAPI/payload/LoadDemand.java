package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class LoadDemand {
    private WeightKg weightKg;

    public LoadDemand(WeightKg weightKg) {
        this.weightKg = weightKg;
    }

    public WeightKg getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(WeightKg weightKg) {
        this.weightKg = weightKg;
    }
}
