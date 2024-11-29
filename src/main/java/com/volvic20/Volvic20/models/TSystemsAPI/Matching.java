package com.volvic20.Volvic20.models.TSystemsAPI;

import com.volvic20.Volvic20.models.GoogleAPI.payload.ArrivalLocation;

public class Matching {
    private String id;
    private String customerId;

    private ArrivalLocation carStart;
    private ArrivalLocation customerStart;
    private ArrivalLocation customerEnd;

    public Matching(String id, String customerId, ArrivalLocation carStart, ArrivalLocation customerStart, ArrivalLocation customerEnd) {
        this.id = id;
        this.customerId = customerId;
        this.carStart = carStart;
        this.customerStart = customerStart;
        this.customerEnd = customerEnd;
    }

    public ArrivalLocation getCarStart() {
        return carStart;
    }

    public void setCarStart(ArrivalLocation carStart) {
        this.carStart = carStart;
    }

    public ArrivalLocation getCustomerStart() {
        return customerStart;
    }

    public void setCustomerStart(ArrivalLocation customerStart) {
        this.customerStart = customerStart;
    }

    public ArrivalLocation getCustomerEnd() {
        return customerEnd;
    }

    public void setCustomerEnd(ArrivalLocation customerEnd) {
        this.customerEnd = customerEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
