package com.group33.models.road;

import com.group33.models.vehicle.Vehicle;


public class LeftRoad extends Road{

    public LeftRoad(int newXAxis, int newYAxis, int newRoadWidth,  int newNumberOfLane, int newLaneHeight, RoadDirection newVehicleDirection) {
        super(newXAxis, newYAxis, newRoadWidth,  newNumberOfLane, newLaneHeight, newVehicleDirection);
    }

    public void switchVehicleLane(Vehicle v){
        if(v.getyAxis() < this.getyAxis()+10 && (collision.collision(v.getxAxis() ,v.getyAxis() - this.laneHeight ,v,RoadDirection.LEFT)) == false){ // not in leftmost lane
            v.setyAxis(v.getyAxis() + this.laneHeight);
        }
        else if(v.getyAxis() > this.getyAxis()+10 * this.laneHeight && (collision.collision(v.getxAxis() ,v.getyAxis() + this.laneHeight ,v,RoadDirection.LEFT)) == false){
            v.setyAxis(v.getyAxis() + this.laneHeight);
        }
    }

    public void ensureVehicleIsNotColliding(Vehicle v){
        v.setxAxis(v.getxAxis() - v.getVehicleSpeed());
        if(v.getxAxis() < 0)
        {
            v.setxAxis(this.roadWidth-100);
            if(collision.collision(v.getxAxis() - v.getVehicleSpeed() ,v.getyAxis() ,v,RoadDirection.LEFT) == false) {
                v.setxAxis(v.getxAxis() - v.getVehicleSpeed());
            }
        }
    }

    public void moveCars() {
        //loop through all the cars in the array list
        //Get the only object available
        for(int a = 0; a < cars.size(); a++) {
            //Get a vehicle from the c
            Vehicle v = cars.get(a);
            if(collision.collision(v.getxAxis() - v.getVehicleSpeed() ,v.getyAxis() ,v,RoadDirection.LEFT) == false){  ///there is no collision
                this.ensureVehicleIsNotColliding(v);
            }
            else{ //switching lane
                this.switchVehicleLane(v);
            }
            v.accelerate();
        }
    }

}
