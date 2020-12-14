package com.group33.models.trafficlight;

import java.awt.*;

public class Bulb {
    private boolean on;
    private Color color;
    private String colorName;

    public Bulb(boolean on, Color color, String colorName){
        this.on = on;
        this.color = color;
        this.colorName = colorName;
    }

    public boolean isOn(){
        return on;
    }

    public boolean isOff(){
        return !on;
    }

    public void turnOn(){
        on = true;
    }

    public void turnOff(){
        on = false;
    }

}
