package com.group33.trafficlight;

import java.awt.*;

public class Light {

    private Bulb[] lights;

    public Light(){
        lights = new Bulb[3];
        lights[0] = new Bulb(true, Color.RED, "red");
        lights[1] = new Bulb(false, Color.YELLOW, "yellow");
        lights[2] = new Bulb(false, Color.GREEN, "green");
    }

    public Bulb[] getLights(){
        return lights;
    }

    public void setLights(Bulb[] lights) {
        this.lights = lights;
    }

    public int indexOfLightBulb(){
        int i = 0;
        while(i < lights.length && lights[i].isOff()){
            i++;
        }
        return i;
    }

    public void reset(){
        lights[0].turnOn();
        lights[1].turnOff();
        lights[2].turnOff();
    }

    public void nextState(){
        if(lights[0].isOn()){
            lights[0].turnOff();
            lights[2].turnOn();
        }else if(lights[2].isOn()){
            lights[2].turnOff();
            lights[0].turnOn();
        }else if(lights[1].isOn()){
            lights[1].turnOff();
            lights[0].turnOn();
        }
    }
}
