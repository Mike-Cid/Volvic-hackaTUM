package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class WeightKg_Vehicle {
    private int maxLoad;

    public WeightKg_Vehicle(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}
