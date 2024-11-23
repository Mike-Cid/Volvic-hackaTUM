package com.volvic20.Volvic20.models.GoogleAPI.payload.response;

public class Transition {
    private String travelDuration;
    private String waitDuration;
    private String totalDuration;
    private String startTime;
    private Integer travelDistanceMeters; // Puede ser null si no está presente


    public Transition(String travelDuration, String waitDuration, String totalDuration, String startTime, Integer travelDistanceMeters) {
        this.travelDuration = travelDuration;
        this.waitDuration = waitDuration;
        this.totalDuration = totalDuration;
        this.startTime = startTime;
        this.travelDistanceMeters = travelDistanceMeters;
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

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getTravelDistanceMeters() {
        return travelDistanceMeters;
    }

    public void setTravelDistanceMeters(Integer travelDistanceMeters) {
        this.travelDistanceMeters = travelDistanceMeters;
    }
}
