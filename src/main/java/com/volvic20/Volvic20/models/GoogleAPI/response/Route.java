package com.volvic20.Volvic20.models.GoogleAPI.response;

import java.util.List;

public class Route {
    private int vehicleIndex;
    private String vehicleStartTime;
    private String vehicleEndTime;
    private List<Visit> visits;
    private List<Transition> transitions;
    private RouteMetric metrics;
    //private RouteCost routeCosts;
    private float routeTotalCost;

    public Route(int vehicleIndex, String vehicleStartTime, String vehicleEndTime, List<Visit> visits, List<Transition> transitions, RouteMetric metrics /*RouteCost routeCosts*/, float routeTotalCost) {
        this.vehicleIndex = vehicleIndex;
        this.vehicleStartTime = vehicleStartTime;
        this.vehicleEndTime = vehicleEndTime;
        this.visits = visits;
        this.transitions = transitions;
        this.metrics = metrics;
        //this.routeCosts = routeCosts;
        this.routeTotalCost = routeTotalCost;
    }

    public int getVehicleIndex() {
        return vehicleIndex;
    }

    public void setVehicleIndex(int vehicleIndex) {
        this.vehicleIndex = vehicleIndex;
    }

    public String getVehicleStartTime() {
        return vehicleStartTime;
    }

    public void setVehicleStartTime(String vehicleStartTime) {
        this.vehicleStartTime = vehicleStartTime;
    }

    public String getVehicleEndTime() {
        return vehicleEndTime;
    }

    public void setVehicleEndTime(String vehicleEndTime) {
        this.vehicleEndTime = vehicleEndTime;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public RouteMetric getMetrics() {
        return metrics;
    }

    public void setMetrics(RouteMetric metrics) {
        this.metrics = metrics;
    }

    /*public RouteCost getRouteCosts() {
        return routeCosts;
    }

    public void setRouteCosts(RouteCost routeCosts) {
        this.routeCosts = routeCosts;
    }


     */
    public float getRouteTotalCost() {
        return routeTotalCost;
    }

    public void setRouteTotalCost(float routeTotalCost) {
        this.routeTotalCost = routeTotalCost;
    }
}
