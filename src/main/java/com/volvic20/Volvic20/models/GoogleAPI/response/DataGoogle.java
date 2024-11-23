package com.volvic20.Volvic20.models.GoogleAPI.response;

import java.util.List;

public class DataGoogle {
    private List<Route> routes;
    private Metric metrics;

    public DataGoogle(List<Route> routes, Metric metrics) {
        this.routes = routes;
        this.metrics = metrics;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Metric getMetrics() {
        return metrics;
    }

    public void setMetrics(Metric metrics) {
        this.metrics = metrics;
    }
}

