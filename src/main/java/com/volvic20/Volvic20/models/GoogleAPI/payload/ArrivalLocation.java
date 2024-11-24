package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class ArrivalLocation {
    private float latitude;
    private float longitude;

    public ArrivalLocation(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
