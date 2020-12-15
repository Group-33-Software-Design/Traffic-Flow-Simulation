package com.group33.models.vehicle;

import com.group33.models.drivers.IDriver;
import com.group33.models.road.RoadDirection;

import java.io.File;

public class VehicleFactory {

    private int xAxis,yAxis;
    private File vehicleImageFilePath;
    private RoadDirection vehicleDirection;
    private IDriver driver;

    public VehicleFactory(int newXAxis, int newYAxis, File newVehicleImageFilePath, RoadDirection newVehicleDirection,IDriver driver){
        this.xAxis = newXAxis;
        this.yAxis = newYAxis;
        this.vehicleImageFilePath = newVehicleImageFilePath;
        this.vehicleDirection = newVehicleDirection;
        this.driver = driver;
    }

    public Vehicle getVehicle(String car){
        switch (car) {
            case "sport":
                return new Sport(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection,this.driver);
            case "suv":
                return new SUV(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection,this.driver);
            case "sedan":
                return new Sedan(this.xAxis,this.yAxis,this.vehicleImageFilePath,this.vehicleDirection,this.driver);

        }
        return null;
    }
}
