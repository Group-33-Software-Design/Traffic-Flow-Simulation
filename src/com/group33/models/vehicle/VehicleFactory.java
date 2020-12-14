package com.group33.models.vehicle;

import com.group33.models.road.RoadDirection;

import java.io.File;

public class VehicleFactory {

    private int xAxis,yAxis;
    private File vehicleImageFilePath;
    private RoadDirection vehicleDirection;

    public VehicleFactory(int newXAxis, int newYAxis, File newVehicleImageFilePath, RoadDirection newVehicleDirection){
        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
        this.vehicleImageFilePath = newVehicleImageFilePath;
        this.vehicleDirection = newVehicleDirection;
    }

    public Vehicle getVehicle(String car){
        switch (car) {
            case "sport":
                return new Sport(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection);
            case "suv":
                return new SUV(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection);
            case "sedan":
                return new Sedan(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection);

        }
        return null;
    }
}
