package com.group33.controller;

import com.group33.config.Configuration;
import com.group33.models.collision.Collision;
import com.group33.models.drivers.*;
import com.group33.models.road.Road;
import com.group33.models.road.RoadDirection;
import com.group33.models.vehicle.IVehicle;
import com.group33.models.vehicle.Vehicle;
import com.group33.models.vehicle.VehicleFactory;

import javax.swing.*;
import java.io.File;
import java.util.Random;

public class Generator {

    private Road rightRoad;
    private Road leftRoad;

    public Generator(Road newrightRoad,Road newleftRoad){
        rightRoad =newrightRoad;
        leftRoad =newleftRoad;

    }



    public void generateVehicles(JFrame frame){
        Random random = new Random();
        IDriver[] drivers = {
                new ExperiencedDriver(),
                new LearnerDriver(),
                new RecklessDriver()
        };
        for (int i = 0; i < Configuration.getNumberOfGeneratedVehicles(); i++) {
            String[][] cars = {
                    {Configuration.getSedan(), Configuration.getSuv(), Configuration.getSport()},
                    {Configuration.getSedanImage(), Configuration.getSuvImage(), Configuration.getSportImage()},
            };
            int randNumber = random.nextInt(3);
            Vehicle vehicle = new VehicleFactory(rightRoad.getxAxis(), rightRoad.getyAxis() + 10, new File(cars[1][randNumber]), RoadDirection.RIGHT,drivers[randNumber]).getVehicle(cars[0][randNumber]);
            rightRoad.addCar(vehicle);
            //subject.addSubscriber();
            Collision.setVehicles(rightRoad.getCars());
            for (int x = 0; x < rightRoad.getRoadWidth(); x = x + 20) {
                for (int y = rightRoad.getyAxis() + 10; y < rightRoad.getLaneHeight() * rightRoad.getNumberOfLane(); y = y + rightRoad.getLaneHeight()) {
                    vehicle.setxAxis(x);
                    vehicle.setyAxis(y);
                    frame.repaint();
                    if (Collision.collision(x, y, vehicle, RoadDirection.RIGHT) == false) {
                        frame.repaint();
                        break;
                    }
                }
                break;
            }
        }

        for(int i =0; i < Configuration.getNumberOfGeneratedVehicles();i++ ){
            String[][] carsRoad = {
                    {Configuration.getSedan(), Configuration.getSuv(), Configuration.getSport()},
                    {Configuration.getSedanImage(), Configuration.getSuvImage(), Configuration.getSportImage()},
            };
            int randNumber = random.nextInt(3);
            Vehicle vehicle2 = new VehicleFactory(leftRoad.getWidth()-100,leftRoad.getyAxis()+10,new File(carsRoad[1][randNumber]),RoadDirection.LEFT,drivers[randNumber]).getVehicle(carsRoad[0][randNumber]);
            leftRoad.addCar(vehicle2);
            Collision collision2 = new Collision();
            collision2.setVehicles(leftRoad.getCars());

            for(int x = leftRoad.getRoadWidth()-100; x > 0; x = x - 20){
                for(int y=leftRoad.getyAxis(); y < leftRoad.getLaneHeight()*leftRoad.getNumberOfLane(); y = y + leftRoad.getLaneHeight()) {
                    vehicle2.setxAxis(x);
                    vehicle2.setyAxis(y);
                    if(collision2.collision(x,y,vehicle2,RoadDirection.LEFT) == false){
                        frame.repaint();
                        break;
                    }
                }
                break;
            }
        }
    }

}
