package com.volvic20.Volvic20.models.GoogleAPI.payload;

public class Location {

    private ArrivalLocation arrivalLocation;

    public Location(ArrivalLocation arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public ArrivalLocation getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(ArrivalLocation arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }
}
