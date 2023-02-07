package com.techelevator.model;

public class Service {

    private int serviceId;
    private String oil;
    private String brakes;
    private String tires;
    private String body;
    private String carbonAirFilter;
    private String battery;
    private String scheduledMaintenance;
    private String misc;

    public Service() {}

    public Service(int serviceId, String oil, String brakes, String tires, String body, String carbon_air_filter, String battery, String scheduledMaintenance, String misc) {
        this.serviceId = serviceId;
        this.oil = oil;
        this.brakes = brakes;
        this.tires = tires;
        this.body = body;
        this.carbonAirFilter = carbon_air_filter;
        this.battery = battery;
        this.scheduledMaintenance = scheduledMaintenance;
        this.misc = misc;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCarbonAirFilter() {
        return carbonAirFilter;
    }

    public void setCarbonAirFilter(String carbonAirFilter) {
        this.carbonAirFilter = carbonAirFilter;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getScheduledMaintenance() {
        return scheduledMaintenance;
    }

    public void setScheduledMaintenance(String scheduledMaintenance) {
        this.scheduledMaintenance = scheduledMaintenance;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }


    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", oil='" + oil + '\'' +
                ", brakes='" + brakes + '\'' +
                ", tires='" + tires + '\'' +
                ", body='" + body + '\'' +
                ", carbonAirFilter='" + carbonAirFilter + '\'' +
                ", battery='" + battery + '\'' +
                ", scheduledMaintenance='" + scheduledMaintenance + '\'' +
                ", misc='" + misc + '\'' +
                '}';
    }
}
