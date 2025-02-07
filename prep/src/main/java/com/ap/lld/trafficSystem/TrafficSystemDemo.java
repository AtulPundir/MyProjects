package com.ap.lld.trafficSystem;

public class TrafficSystemDemo {

    public static void main(String[] args) {
        TrafficLight light1 = new TrafficLight("Signal 1", TrafficLightState.RED, 5);
        TrafficLight light2 = new TrafficLight("Signal 2", TrafficLightState.GREEN, 3);

        Intersection intersection = new Intersection("Main Street");
        intersection.addSignal(light1);
        intersection.addSignal(light2);

        TrafficSignalController controller = new TrafficSignalController(intersection.getSignals());

        // Running traffic signal system in a separate thread
        new Thread(controller::start).start();
    }
        
    }

