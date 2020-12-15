package com.group33.view;

import com.group33.controller.Generator;
import com.group33.models.collision.Collision;
import com.group33.models.road.Road;
import com.group33.models.road.RoadDirection;
import com.group33.config.time.timeclass;
import com.group33.config.Observables;
import com.group33.models.vehicle.Vehicle;
import com.group33.models.vehicle.VehicleFactory;
import com.group33.config.Configuration;
import com.group33.view.graphics.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PaintGraphics extends Stage implements  Runnable{

    Observables light = new Observables();
    Generator vehicleGenerator = new Generator(this.getRoadContainer().getRightRoad(),
            this.getRoadContainer().getLeftRoad());

    public PaintGraphics(String title, int newWidth, int newHeight) throws HeadlessException {
        super(title, newWidth, newHeight);
        Configuration.changeRunningStatus();
        timeclass.setStartTime();
        Thread t = new Thread(this);
        t.start();
        this.getRoadContainer().getRightRoadTrafficLight().getLight().nextState();
        this.getRoadContainer().getLeftRoadTrafficLight().getLight().nextState();
        vehicleGenerator.generateVehicles(this);
    }

    @Override
    public void run() {
        while(Configuration.getRunning() == true) {
            this.getRoadContainer().getRightRoad().moveCars();
            this.getRoadContainer().getLeftRoad().moveCars();
            this.repaint();

            try {
                Thread.sleep(Configuration.getThreadSleepTime());
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
