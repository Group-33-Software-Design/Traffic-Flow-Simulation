package com.group33.time;

public class timeclass {
    //create an object of SingleObject
    private static timeclass instance = new timeclass();
    private static int counter;
    private static long starttime;
    private static boolean running = false;

    //make the constructor private so that this class cannot be
    //instantiated
    private timeclass(){}

    //Get the only object available
    public static timeclass getInstance(){
        return instance;
    }

    public static void showMessage(){
        counter ++;
        long currenttime = System.nanoTime();
        long timeElapsed = currenttime - starttime;
        System.out.println("The time elapsed!" + timeElapsed);
    }

    public static void changeRunningStatus(){
        running = !running;
    }

    public static boolean getRunning(){
        return running;
    }

    public static void setRunnerFalse(){
        running = false;
    }

    public static void setStartTime(){
        starttime =  System.nanoTime();
    }
}
