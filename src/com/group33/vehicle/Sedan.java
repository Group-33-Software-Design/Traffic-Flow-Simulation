package com.group33.vehicle;

import com.group33.road.RoadDirection;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Sedan extends Vehicle{
    public Sedan(int newXAxis, int newYAxis, File newVehicleImageFilePath, RoadDirection newVehicleDirection) {
        super(newXAxis, newYAxis, newVehicleImageFilePath, newVehicleDirection);
        this.setVehicleSpeed(40);
        this.setVehicleHeight(50);
        this.setVehicleWidth(90);
        try {
            this.vehicleImage = ImageIO.read(this.vehicleImageFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.vehicleImage = vehicleImage.getScaledInstance(this.vehicleWidth, this.getVehicleHeight(), vehicleImage.SCALE_DEFAULT);
    }
}
