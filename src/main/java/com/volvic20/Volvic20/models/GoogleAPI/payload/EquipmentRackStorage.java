package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class EquipmentRackStorage {
    public int maxLoad;

    public EquipmentRackStorage(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}
