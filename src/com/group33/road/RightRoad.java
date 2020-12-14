package com.group33.road;

import com.group33.collision.Collision;
import com.group33.vehicle.Vehicle;

public class RightRoad extends Road{
    public RightRoad(int newXAxis, int newYAxis, int newRoadWidth, int newNumberOfLane, int newLaneHeight, RoadDirection newVehicleDirection) {
        super(newXAxis, newYAxis, newRoadWidth, newNumberOfLane, newLaneHeight, newVehicleDirection);
    }

    public void moveCars() {
        for(int a = 0; a < cars.size(); a++) {
            Vehicle v = cars.get(a);
            Collision collision = new Collision();
            if(collision.collision(v.getxAxis()+ v.getVehicleSpeed() ,v.getyAxis() ,v,RoadDirection.RIGHT) == false){  ///there is no collision
                v.setxAxis(v.getxAxis() + v.getVehicleSpeed());
                if(v.getxAxis() > this.roadWidth)
                {
                    v.setxAxis(0);
                    if(collision.collision(v.getxAxis()+ v.getVehicleSpeed() ,v.getyAxis() ,v,RoadDirection.RIGHT) == false) {
                        v.setxAxis(v.getxAxis() + v.getVehicleSpeed());
                    }
                }
            }
            else{ //switching lane
                if(v.getyAxis() >this.getyAxis()+10 && (collision.collision(v.getxAxis() ,v.getyAxis() -this.laneHeight ,v,RoadDirection.RIGHT)) == false){ // not in leftmost lane

                    v.setyAxis(v.getyAxis() - this.laneHeight);
                }
                else if(v.getyAxis() < this.getyAxis()+10 * this.laneHeight && (collision.collision(v.getxAxis() ,v.getyAxis() + this.laneHeight ,v,RoadDirection.RIGHT)) == false){
                    v.setyAxis(v.getyAxis() + this.laneHeight);
                }
            }
            v.accelerate();
        }
    }
}
