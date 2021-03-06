package com.group33.view.graphics;

import com.group33.models.trafficlight.Light;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JComponent{

    private Light light;
    private int x=30,y=25,WIDTH=25,HEIGHT=65;
    private final int DIAMETER = 15,X_OFFSET = 5,Y_OFFSET = 5;


    public TrafficLight(int xAxis, int yAxis){
        super();
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(90,110));
        this.x =xAxis;
        this.y=yAxis;
        light = new Light();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x,y,WIDTH,HEIGHT);
        for(int i= 1; i < 4 ; i++){
            setColor(g, i);
        }
        this.repaint();
    }

    public  void setColor (Graphics g, int lightcount){
        switch(lightcount) {
            case 1:
                // show red light
                        if(light.indexOfLightBulb() == 0){
                            g.setColor(Color.RED);
                        }else{
                            g.setColor(Color.DARK_GRAY);

                        }
                      g.fillOval(x+X_OFFSET,y+Y_OFFSET,DIAMETER,DIAMETER);
                break;
            case 2:
                // show green light
                        if(light.indexOfLightBulb() == 1){
                            g.setColor(Color.YELLOW);
                        }else{
                            g.setColor(Color.DARK_GRAY);

                        }
                        g.fillOval(x+X_OFFSET, y+DIAMETER+2*Y_OFFSET,DIAMETER,DIAMETER);
                break;
            default:
                // show default gray light
                        if(light.indexOfLightBulb() == 2){
                            g.setColor(Color.GREEN);
                        }else{
                            g.setColor(Color.DARK_GRAY);

                        }
                        g.fillOval(x+X_OFFSET, y+2*DIAMETER+3*Y_OFFSET,DIAMETER,DIAMETER);
        }
    }

}
