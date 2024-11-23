package com.volvic20.Volvic20.models.GoogleAPI.response;

public class Metric {
    private AggregatedRouteMetric aggregatedRouteMetrics;
    private int usedVehicleCount;
    private String earliestVehicleStartTime;
    private String latestVehicleEndTime;
    private float totalCost;
    //private Cost costs;


    public Metric(AggregatedRouteMetric aggregatedRouteMetrics, int usedVehicleCount, String earliestVehicleStartTime, String latestVehicleEndTime, float totalCost) {
        this.aggregatedRouteMetrics = aggregatedRouteMetrics;
        this.usedVehicleCount = usedVehicleCount;
        this.earliestVehicleStartTime = earliestVehicleStartTime;
        this.latestVehicleEndTime = latestVehicleEndTime;
        this.totalCost = totalCost;
    }

    public AggregatedRouteMetric getAggregatedRouteMetrics() {
        return aggregatedRouteMetrics;
    }

    public void setAggregatedRouteMetrics(AggregatedRouteMetric aggregatedRouteMetrics) {
        this.aggregatedRouteMetrics = aggregatedRouteMetrics;
    }

    public int getUsedVehicleCount() {
        return usedVehicleCount;
    }

    public void setUsedVehicleCount(int usedVehicleCount) {
        this.usedVehicleCount = usedVehicleCount;
    }

    public String getEarliestVehicleStartTime() {
        return earliestVehicleStartTime;
    }

    public void setEarliestVehicleStartTime(String earliestVehicleStartTime) {
        this.earliestVehicleStartTime = earliestVehicleStartTime;
    }

    public String getLatestVehicleEndTime() {
        return latestVehicleEndTime;
    }

    public void setLatestVehicleEndTime(String latestVehicleEndTime) {
        this.latestVehicleEndTime = latestVehicleEndTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /*public Cost getCosts() {
        return costs;
    }

    public void setCosts(Cost costs) {
        this.costs = costs;
    }*/

}