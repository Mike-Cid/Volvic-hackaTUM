package com.volvic20.Volvic20.models.GoogleAPI.response;

// Clase RouteMetrics
public class RouteMetric {
    private int performedShipmentCount;
    private String travelDuration;
    private String waitDuration;
    private String delayDuration;
    private String breakDuration;
    private String visitDuration;
    private String totalDuration;
    private int travelDistanceMeters;

    public RouteMetric(int performedShipmentCount, String travelDuration, String waitDuration, String delayDuration, String breakDuration, String visitDuration, String totalDuration, int travelDistanceMeters) {
        this.performedShipmentCount = performedShipmentCount;
        this.travelDuration = travelDuration;
        this.waitDuration = waitDuration;
        this.delayDuration = delayDuration;
        this.breakDuration = breakDuration;
        this.visitDuration = visitDuration;
        this.totalDuration = totalDuration;
        this.travelDistanceMeters = travelDistanceMeters;
    }

    public int getPerformedShipmentCount() {
        return performedShipmentCount;
    }

    public void setPerformedShipmentCount(int performedShipmentCount) {
        this.performedShipmentCount = performedShipmentCount;
    }

    public String getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(String travelDuration) {
        this.travelDuration = travelDuration;
    }

    public String getWaitDuration() {
        return waitDuration;
    }

    public void setWaitDuration(String waitDuration) {
        this.waitDuration = waitDuration;
    }

    public String getDelayDuration() {
        return delayDuration;
    }

    public void setDelayDuration(String delayDuration) {
        this.delayDuration = delayDuration;
    }

    public String getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(String breakDuration) {
        this.breakDuration = breakDuration;
    }

    public String getVisitDuration() {
        return visitDuration;
    }

    public void setVisitDuration(String visitDuration) {
        this.visitDuration = visitDuration;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getTravelDistanceMeters() {
        return travelDistanceMeters;
    }

    public void setTravelDistanceMeters(int travelDistanceMeters) {
        this.travelDistanceMeters = travelDistanceMeters;
    }

}
