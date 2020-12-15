package com.group33.models.vehicle;

import com.group33.config.Configuration;
import com.group33.models.drivers.IDriver;
import com.group33.models.road.RoadDirection;
import com.group33.config.Observer;

import java.awt.*;
import java.io.File;

public class Vehicle implements IVehicle, Observer {

    protected int xAxis,yAxis,vehicleWidth,vehicleHeight,vehicleSpeed;
    protected RoadDirection vehicleDirection;
    protected File vehicleImageFilePath;
    protected Image vehicleImage;
    protected IDriver driver;

    public Vehicle(int newXAxis, int newYAxis, File newVehicleImageFilePath, RoadDirection newVehicleDirection,IDriver driver) {
        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
        this.driver = driver;
        this.vehicleImageFilePath = newVehicleImageFilePath;
        this.vehicleDirection = newVehicleDirection;

    }

    @Override
    public void drawCar(Graphics g) {
        g.drawImage(this.vehicleImage, this.xAxis, this.yAxis, null);
    }

    @Override
    public void accelerate() {
        if(RoadDirection.LEFT == this.vehicleDirection){
            this.xAxis = (int) ((this.xAxis) - (this.vehicleSpeed * driver.getRISKFACTOR())) ;

        }else{
            this.xAxis = (int) (this.xAxis + this.vehicleSpeed * driver.getRISKFACTOR()) ;
        }
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

    public int getVehicleWidth() {
        return vehicleWidth;
    }

    public void setVehicleWidth(int vehicleWidth) {
        this.vehicleWidth = vehicleWidth;
    }

    public int getVehicleHeight() {
        return vehicleHeight;
    }

    public void setVehicleHeight(int vehicleHeight) {
        this.vehicleHeight = vehicleHeight;
    }

    public int getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(int vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    @Override
    public void update(Object args) {
        System.out.println("The traffic light changed here is!");
        Configuration.setRunnerFalse();
        System.out.println(Configuration.getRunning());

    }
}
