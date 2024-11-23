package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class LoadLimit {
    private EquipmentRackStorage equipmentRackStorage;

    public LoadLimit(EquipmentRackStorage equipmentRackStorage) {
        this.equipmentRackStorage = equipmentRackStorage;
    }

    public EquipmentRackStorage getEquipmentRackStorage() {
        return equipmentRackStorage;
    }

    public void setEquipmentRackStorage(EquipmentRackStorage equipmentRackStorage) {
        this.equipmentRackStorage = equipmentRackStorage;
    }
}
