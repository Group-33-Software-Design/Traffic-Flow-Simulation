package com.group33.collision;

import com.group33.road.RoadDirection;
import com.group33.vehicle.Vehicle;

import java.util.ArrayList;

public class Collision {

    public static ArrayList<Vehicle> vehicles;

    /**
     * implement collision 
     * @return
     */
    public static boolean collision(int x, int y, Vehicle vehicle, RoadDirection vehicleDirection){
        boolean collide = false;
        //loop through all the vehicles
        for(int a = 0; a < vehicles.size(); a++){
            Vehicle u = vehicles.get(a);
            if(y == u.getyAxis()){ // If I'm in the same lane
                if(u.equals(vehicle) == false)// if i'm not checking myself
                {
                    if(RoadDirection.RIGHT == vehicleDirection) {
                        if (x < u.getxAxis() + u.getVehicleWidth() && // my left side is left of his right
                                x + vehicle.getVehicleWidth() > u.getxAxis()) {//my right side is right of his left
                            return true;
                        }
                    }
                    else{
                        if (x < u.getxAxis() + u.getVehicleWidth() && // my left side is left of his right
                                x + vehicle.getVehicleWidth() > u.getxAxis()) {//my right side is right of his left
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }





    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void setVehicles(ArrayList<Vehicle> vehicles) {
        Collision.vehicles = vehicles;
    }
}
