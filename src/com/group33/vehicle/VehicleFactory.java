package com.group33.vehicle;

import com.group33.road.RoadDirection;

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
                return null;
            case "suv":
                return null;
            case "sedan":
                return null;

        }
        return null;
    }
}
