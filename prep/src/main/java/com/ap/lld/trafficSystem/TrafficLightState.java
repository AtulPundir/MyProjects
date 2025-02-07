package com.ap.lld.trafficSystem;

public enum TrafficLightState {

    RED {
        @Override
        void changeLight(TrafficLight light) {
            System.out.println("RED!!!! STOP!!!");
            light.setState(GREEN);
        }
    }, GREEN {
        @Override
        void changeLight(TrafficLight light) {
            System.out.println("Green! GO!!!");
            light.setState(YELLOW);
            
        }
    }, YELLOW {
        @Override
        void changeLight(TrafficLight light) {
            System.out.println("Yellow Light - Slow down!");
            light.setState(RED);
        }
    };


    abstract void changeLight(TrafficLight light);

}
