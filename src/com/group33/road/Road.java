package com.group33.road;


import com.group33.graphics.TrafficLight;
import com.group33.vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Road extends JComponent implements IRoad {
    protected ArrayList<Vehicle> cars;
    protected int roadWidth;
    protected final int roadHeight = 600;
    protected int laneHeight;
    protected int numberOfLane;
    protected int xAxis;
    protected int yAxis;
    protected RoadDirection vehicleDirection;
    protected TrafficLight trafficLight;
    protected final int ROAD_LINE_DERMACATOR_SPACE = 20;
    protected final int ROAD_LINE_DEMACATOR_BOX_WIDTH = 15;
    protected final int ROAD_LINE_DEMACATOR_BOX_HEIGHT = 3;
    protected Image backgroundImage;
    @Override
    public void reset() {
        cars.clear();
    }

    @Override
    public void addCar(Vehicle v) {
        cars.add(v);
    }

    @Override
    public void moveCars() {

    }
}
