package com.group33.road;

import static com.group33.road.RoadDirection.*;

public class RoadFactory {

    private int xAxis, yAxis, roadWidth, numberOfLane, laneHeight;
    private RoadDirection newVehicleDirection;

    public RoadFactory(int xAxis, int yAxis, int roadWidth,  int numberOfLane, int laneHeight, RoadDirection newVehicleDirection) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.roadWidth = roadWidth;
        this.numberOfLane = numberOfLane;
        this.laneHeight = laneHeight;
        this.newVehicleDirection = newVehicleDirection;
    }

    public Road getRoad(){
        switch(this.newVehicleDirection){
            case RIGHT:
                return new RightRoad(xAxis, yAxis, roadWidth, numberOfLane, laneHeight, RIGHT);
            case LEFT:
                return new LeftRoad(xAxis, yAxis, roadWidth, numberOfLane, laneHeight, LEFT);
        }
        return null;
    }
}
