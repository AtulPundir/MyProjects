package com.ap.lld.trafficSystem;

import java.util.ArrayList;
import java.util.List;

class Intersection {
    private String location;
    private List<TrafficLight> signals;

    public Intersection(String location) {
        this.location = location;
        this.signals = new ArrayList<>();
    }

    public void addSignal(TrafficLight light) {
        signals.add(light);
    }

    public void removeSignal(TrafficLight light) {
        signals.remove(light);
    }

    public List<TrafficLight> getSignals() {
        return signals;
    }

    public String getLocation() {
        return location;
    }
}

