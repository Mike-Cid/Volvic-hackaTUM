package com.volvic20.Volvic20.models.TSystemsAPI;

public class ScenarioInitializer {
    private int numberOfVehicles;
    private int numberOfCustomers;

    public ScenarioInitializer(int numberOfVehicles, int numberOfCustomers) {
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfCustomers = numberOfCustomers;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
