package com.volvic20.Volvic20.models.TSystemsAPI;

import java.util.List;

public class Scenario {
    private String id;
    private String startTime;
    private String endTime;
    private String status;
    private List<Vehicle> vehicles;
    private List<Customer> customers;

    public Scenario(String id, String startTime, String endTime, String status,
                    List<Vehicle> vehicles, List<Customer> customers) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.vehicles = vehicles;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", vehicles=" + vehicles +
                ", customers=" + customers +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
