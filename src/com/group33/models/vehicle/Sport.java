package com.group33.models.vehicle;

import com.group33.models.road.RoadDirection;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Sport extends Vehicle{
    public Sport(int newXAxis, int newYAxis, File newVehicleImageFilePath, RoadDirection newVehicleDirection) {
        super(newXAxis, newYAxis, newVehicleImageFilePath, newVehicleDirection);
        this.setVehicleSpeed(60);
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
