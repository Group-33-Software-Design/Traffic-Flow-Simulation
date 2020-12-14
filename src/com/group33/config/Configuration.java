package com.group33.config;

public class Configuration {
    private static int rightRoadXAxis = 0;
    private static int rightRoadYAxis = 50;
    private static int leftRoadXAxis = 0;
    private static int leftRoadYAxis = 70;
    private static int numberOfLane = 3;
    private static int laneHeight = 76;
    private static int rightTrafficLightXAxis = 100;
    private static int rightTrafficLightYAxis = 0;
    private static int leftTrafficLightXAxis = 50;
    private static int leftTrafficLightYAxis = 20;
    private static int threadSleepTime = 350;
    private static Configuration instance = new Configuration();

    private Configuration(){}

    public static Configuration getInstance(){
        return instance;
    }

    public static int getRightRoadXAxis() {
        return rightRoadXAxis;
    }

    public static int getRightRoadYAxis() {
        return rightRoadYAxis;
    }

    public static int getLeftRoadXAxis() {
        return leftRoadXAxis;
    }

    public static int getLeftRoadYAxis() {
        return leftRoadYAxis;
    }

    public static int getNumberOfLane() {
        return numberOfLane;
    }

    public static int getLaneHeight() {
        return laneHeight;
    }

    public static int getRightTrafficLightXAxis() {
        return rightTrafficLightXAxis;
    }

    public static int getRightTrafficLightYAxis() {
        return rightTrafficLightYAxis;
    }

    public static int getLeftTrafficLightXAxis() {
        return leftTrafficLightXAxis;
    }

    public static int getLeftTrafficLightYAxis() {
        return leftTrafficLightYAxis;
    }

    public static int getThreadSleepTime() {
        return threadSleepTime;
    }
}
