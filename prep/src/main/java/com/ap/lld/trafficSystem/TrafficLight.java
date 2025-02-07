package com.ap.lld.trafficSystem;

class TrafficLight {
    private String id;
    private TrafficLightState currentState;
    private int duration; // Time in seconds

    public TrafficLight(String id, TrafficLightState initialState, int duration) {
        this.id = id;
        this.currentState = initialState;
        this.duration = duration;
    }

    public void setState(TrafficLightState newState) {
        this.currentState = newState;
    }

    public void changeState() {
        currentState.changeLight(this);
    }

    public String getId() {
        return id;
    }

    public TrafficLightState getState() {
        return currentState;
    }

    public int getDuration() {
        return duration;
    }
}

