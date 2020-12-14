package com.group33.graphics;

import com.group33.road.Road;
import com.group33.road.RoadDirection;
import com.group33.road.RoadFactory;

import java.awt.*;

public class RoadContainer extends Container {

    private TrafficLight rightRoadTrafficLight;
    private TrafficLight leftRoadTrafficLight;
    private Road rightRoad;
    private Road leftRoad;
    private Dimension dimension;

    /**
     *
     * @param newDimension
     */
    public RoadContainer(Dimension newDimension) {
        this.dimension = newDimension;
        this.setLayout(new GridLayout(2,0));
        this.init();
    }

    public void init(){
        this.initialiseLeftRoad();
        this.initialiseRightRoad();
        this.add(rightRoad);
        this.add(leftRoad);
    }


    public void initialiseLeftRoad(){
        leftRoad = new RoadFactory(
                Configuration.getLeftRoadXAxis(),
                Configuration.getLeftRoadYAxis(),
                (int)dimension.getWidth(),
                Configuration.getNumberOfLane(),
                Configuration.getLaneHeight(),
                RoadDirection.LEFT
        ).getRoad();
        this.initialiseLeftTrafficLight();
        this.leftRoad.add(leftRoadTrafficLight);

    }

    public void initialiseRightRoad(){
        rightRoad = new RoadFactory(
                Configuration.getRightRoadXAxis(),
                Configuration.getRightRoadYAxis(),
                (int) dimension.getWidth(),
                Configuration.getNumberOfLane(),
                Configuration.getLaneHeight(),
                RoadDirection.RIGHT
        ).getRoad();
        this.initialiseRightTrafficLight();
        this.rightRoad.add(rightRoadTrafficLight);
    }

    public void initialiseLeftTrafficLight(){
        leftRoadTrafficLight = new TrafficLight(
                Configuration.getLeftTrafficLightXAxis(),
                Configuration.getLeftTrafficLightYAxis()
        );
    }

    public void initialiseRightTrafficLight() {
        rightRoadTrafficLight = new TrafficLight(
                (int)dimension.getWidth()-Configuration.getRightTrafficLightXAxis(),
                Configuration.getRightTrafficLightYAxis()
        );
    }

    public TrafficLight getRightRoadTrafficLight() {
        return rightRoadTrafficLight;
    }

    public TrafficLight getLeftRoadTrafficLight() {
        return leftRoadTrafficLight;
    }

    public Road getRightRoad() {
        return rightRoad;
    }

    public Road getLeftRoad() {
        return leftRoad;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
