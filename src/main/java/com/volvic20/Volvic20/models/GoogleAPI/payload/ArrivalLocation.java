package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class ArrivalLocation {
    private double latitude;
    private double longitude;

    public ArrivalLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
