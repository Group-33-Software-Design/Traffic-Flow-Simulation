package com.group33.vehicle;


public class SUV {

    protected int xAxis;
    protected int  yAxis;
    protected int vehicleWidth;
    protected int vehicleHeight;
    protected int vehicleSpeed;

    public SUV(int xAxis, int yAxis, int vehicleWidth, int vehicleHeight, int vehicleSpeed) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.vehicleWidth = vehicleWidth;
        this.vehicleHeight = vehicleHeight;
        this.vehicleSpeed = vehicleSpeed;
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
}
