package com.ap.lld.trafficSystem;

import java.util.List;

public class TrafficSignalController {
    private List<TrafficLight> trafficLights;

    public TrafficSignalController(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }

    public void start() {
        while (true) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeState();
                try {
                    Thread.sleep(trafficLight.getDuration() * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void handleEmergency() {
        System.out.println("Emergency Mode Activated! Switching all lights to RED.");
        for (TrafficLight light : trafficLights) {
            light.setState(TrafficLightState.RED);
        }
    }
}

