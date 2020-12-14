package com.group33.models.road;

import com.group33.view.graphics.TrafficLight;
import com.group33.models.vehicle.Vehicle;

import java.awt.*;
import java.util.ArrayList;

public interface IRoad {

    void reset();
    void addCar(Vehicle v);
    void moveCars();
    void applyBackgroundImage();
    void paintStageBackground(Graphics g);
    void drawRoadLane(Graphics g);
    void paintVehicleOnStage(Graphics g);
    ArrayList<Vehicle> getCars();
    int getRoadWidth();
    void setRoadWidth(int roadWidth);
    int getRoadHeight();
    int getLaneHeight();
    void setLaneHeight(int laneHeight);
    int getNumberOfLane();
    void setNumberOfLane(int numberOfLane);
    int getxAxis();
    void setxAxis(int xAxis);
    int getyAxis();
    void setyAxis(int yAxis);
    RoadDirection getVehicleDirection();
    void setVehicleDirection(RoadDirection vehicleDirection);
    TrafficLight getTrafficLight();
    void setTrafficLight(TrafficLight trafficLight);
    int getROAD_LINE_DERMACATOR_SPACE();
    int getROAD_LINE_DEMACATOR_BOX_WIDTH();
    int getROAD_LINE_DEMACATOR_BOX_HEIGHT();
    int getWidth();

}
