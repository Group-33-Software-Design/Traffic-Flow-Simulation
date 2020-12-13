package com.group33.road;

public class LeftRoad extends Road {

    protected int roadWidth;
    protected final int roadHeight = 600;
    protected int laneHeight;
    protected int numberOfLane;
    protected int xAxis;
    protected int yAxis;

    public LeftRoad(int newXAxis, int newYAxis, int newRoadWidth,  int newNumberOfLane, int newLaneHeight, RoadDirection newVehicleDirection) {
        super(newXAxis, newYAxis, newRoadWidth,  newNumberOfLane, newLaneHeight, newVehicleDirection);
    }

    public int getRoadWidth() {
        return roadWidth;
    }

    public void setRoadWidth(int roadWidth) {
        this.roadWidth = roadWidth;
    }

    public int getRoadHeight() {
        return roadHeight;
    }

    public int getLaneHeight() {
        return laneHeight;
    }

    public void setLaneHeight(int laneHeight) {
        this.laneHeight = laneHeight;
    }

    public int getNumberOfLane() {
        return numberOfLane;
    }

    public void setNumberOfLane(int numberOfLane) {
        this.numberOfLane = numberOfLane;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

 

}
