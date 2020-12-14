package com.group33.road;


import com.group33.graphics.TrafficLight;
import com.group33.vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    public Road (int newXAxis, int newYAxis, int newRoadWidth, int newNumberOfLane, int newLaneHeight, RoadDirection newVehicleDirection) {
        super();

        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
        this.roadWidth = newRoadWidth;
        this.vehicleDirection = newVehicleDirection;
        this.numberOfLane = newNumberOfLane;
        this.laneHeight = newLaneHeight;
        this.cars = new ArrayList<Vehicle>();

        try {
            this.backgroundImage = ImageIO.read(new File("resource/image/NewRoad.png"));
            System.out.println("Afdd background image" );
            this.backgroundImage = this.backgroundImage.getScaledInstance(this.roadWidth, this.roadHeight, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setLayout( new OverlayLayout(this) );
    }

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage,0,0,null);
        g.setColor(Color.BLACK);
        g.fillRect(this.xAxis, this.yAxis, this.roadWidth, this.laneHeight * this.numberOfLane);
        g.setColor(Color.WHITE);
        for(int a=this.laneHeight; a < this.laneHeight*this.numberOfLane;  a = a+this.laneHeight) { //Which lane am drawing
            for(int b = 0+this.xAxis; b < this.roadWidth; b = b+this.ROAD_LINE_DERMACATOR_SPACE) { //which line am drawing
                g.fillRect(b, a+this.yAxis, this.ROAD_LINE_DEMACATOR_BOX_WIDTH, this.ROAD_LINE_DEMACATOR_BOX_HEIGHT);
            }
        }
        for(int a=0; a < cars.size(); a++) {
            cars.get(a).drawCar(g);
        }
        this.repaint();
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Vehicle> cars) {
        this.cars = cars;
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

    public RoadDirection getVehicleDirection() {
        return vehicleDirection;
    }

    public void setVehicleDirection(RoadDirection vehicleDirection) {
        this.vehicleDirection = vehicleDirection;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public int getROAD_LINE_DERMACATOR_SPACE() {
        return ROAD_LINE_DERMACATOR_SPACE;
    }

    public int getROAD_LINE_DEMACATOR_BOX_WIDTH() {
        return ROAD_LINE_DEMACATOR_BOX_WIDTH;
    }

    public int getROAD_LINE_DEMACATOR_BOX_HEIGHT() {
        return ROAD_LINE_DEMACATOR_BOX_HEIGHT;
    }
}


