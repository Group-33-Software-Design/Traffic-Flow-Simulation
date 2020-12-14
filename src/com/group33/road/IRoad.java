package com.group33.road;

import com.group33.graphics.TrafficLight;
import com.group33.vehicle.Vehicle;

<<<<<<< HEAD
import java.awt.*;
import java.util.ArrayList;

=======
>>>>>>> master
public interface IRoad {

    void reset();
    void addCar(Vehicle v);
    void moveCars();
<<<<<<< HEAD
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
=======
>>>>>>> master

}
