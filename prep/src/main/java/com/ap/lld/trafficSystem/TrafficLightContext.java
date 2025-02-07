package com.ap.lld.trafficSystem;

public class TrafficLightContext {
    private TrafficLightsEnum state; 

    TrafficLightContext(){
        this.state = TrafficLightsEnum.RED;
    }

    public void setState(TrafficLightsEnum red) {
        this.state = state;
    }


    void changeLight(){
        state.changeLight(this);
    }

}
