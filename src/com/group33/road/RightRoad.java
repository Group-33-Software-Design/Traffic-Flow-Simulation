package com.group33.road;

public class RightRoad {

    protected int roadWidth;
    protected final int roadHeight = 600;
    protected int laneHeight;
    protected int numberOfLane;
    protected int xAxis;
    protected int yAxis;

    public RightRoad(int roadWidth, int laneHeight, int numberOfLane, int xAxis, int yAxis) {
        this.roadWidth = roadWidth;
        this.laneHeight = laneHeight;
        this.numberOfLane = numberOfLane;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
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
