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
    private static int numberOfGeneratedVehicles = 30;
    private static double recklessDriverFactor = 0.8;
    private static double normalDriverFactor = 0.4;
    private static double experiencedDriverFactor = 0.6;
    private static double learnerDriverFactor = 0.2;
    private static boolean running = false;
    private static String sedan = "sedan";
    private static String suv = "suv";
    private static String sport = "sport";
    private static String sedanImage = "resource/image/sedan.png";
    private static String suvImage = "resource/image/suv.png";
    private static String sportImage = "resource/image/sportcar.png";
    private static String sedanFlipedImage = "resource/image/sedanfliped.png";
    private static String suvFlipedImage = "resource/image/flipedsuv.png";
    private static String sportFlipedImage = "resource/image/sportcarfliped.png";
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

    public static void changeRunningStatus(){
        running = !running;
    }

    public static boolean isRunning(){
        return running;
    }

    public static void setRunnerFalse(){
        running = false;
    }

    public static int getNumberOfGeneratedVehicles() {
        return numberOfGeneratedVehicles;
    }

    public static double getRecklessDriverFactor() {
        return recklessDriverFactor;
    }

    public static double getNormalDriverFactor() {
        return normalDriverFactor;
    }

    public static double getExperiencedDriverFactor() {
        return experiencedDriverFactor;
    }

    public static double getLearnerDriverFactor() {
        return learnerDriverFactor;
    }

    public static String getSedan() {
        return sedan;
    }

    public static String getSuv() {
        return suv;
    }

    public static String getSport() {
        return sport;
    }

    public static String getSedanImage() {
        return sedanImage;
    }

    public static String getSuvImage() {
        return suvImage;
    }

    public static String getSportImage() {
        return sportImage;
    }

    public static String getSedanFlipedImage() {
        return sedanFlipedImage;
    }

    public static String getSuvFlipedImage() {
        return suvFlipedImage;
    }

    public static String getSportFlipedImage() {
        return sportFlipedImage;
    }
}