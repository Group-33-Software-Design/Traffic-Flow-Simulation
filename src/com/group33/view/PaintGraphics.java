package com.group33.view;

import com.group33.models.collision.Collision;
import com.group33.models.road.RoadDirection;
import com.group33.models.time.timeclass;
import com.group33.config.Observables;
import com.group33.models.vehicle.Vehicle;
import com.group33.models.vehicle.VehicleFactory;
import com.group33.view.graphics.Configuration;
import com.group33.view.graphics.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PaintGraphics extends Stage implements ActionListener, Runnable{

    Observables light = new Observables();

    public PaintGraphics(String title, int newWidth, int newHeight) throws HeadlessException {
        super(title, newWidth, newHeight);
        this.getTopControls().getStart().addActionListener(this);
        this.getTopControls().getStop().addActionListener(this);
        this.getTopControls().getReset().addActionListener(this);
        this.getBottomControls().getExperiencedDriver().addActionListener(this);
        this.getBottomControls().getExperiencedDriver2().addActionListener(this);
        this.getBottomControls().getNormalDriver().addActionListener(this);
        this.getBottomControls().getNormalDriver2().addActionListener(this);
        this.getBottomControls().getRecklessDriver().addActionListener(this);
        this.getBottomControls().getRecklessDriver2().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(this.getTopControls().getStart())) {
            if(timeclass.getRunning() == false) {
                timeclass.changeRunningStatus();
                timeclass.setStartTime();
                Thread t = new Thread(this);
                t.start();
                this.getRoadContainer().getRightRoadTrafficLight().getLight().nextState();
                this.getRoadContainer().getLeftRoadTrafficLight().getLight().nextState();
            }
        }

        if(event.getSource().equals(this.getTopControls().getStop())) {
            light.setTrafficstate(false);
            timeclass.setRunnerFalse();
            this.getRoadContainer().getRightRoadTrafficLight().getLight().reset();
            this.getRoadContainer().getLeftRoadTrafficLight().getLight().reset();
        }

        if(event.getSource().equals(this.getTopControls().getReset())) {
            timeclass.setRunnerFalse();
            this.getRoadContainer().getRightRoadTrafficLight().getLight().reset();
            this.getRoadContainer().getLeftRoadTrafficLight().getLight().reset();
            this.getRoadContainer().getLeftRoad().reset();
            this.getRoadContainer().getRightRoad().reset();

        }

        if(event.getSource().equals(this.getBottomControls().getExperiencedDriver())){
            Vehicle sport = new VehicleFactory(this.getRoadContainer().getRightRoad().getxAxis(),this.getRoadContainer().getRightRoad().getyAxis()+10,new File("resource/image/sportcar.png"), RoadDirection.RIGHT).getVehicle("sport");
            this.getRoadContainer().getRightRoad().addCar(sport);
            light.registerObserver(sport);
            Collision.setVehicles(this.getRoadContainer().getRightRoad().getCars());
            for(int x= 0; x < this.getRoadContainer().getRightRoad().getRoadWidth(); x = x + 20){
                for(int y=this.getRoadContainer().getRightRoad().getyAxis()+10; y < this.getRoadContainer().getRightRoad().getLaneHeight()*this.getRoadContainer().getRightRoad().getNumberOfLane(); y = y + this.getRoadContainer().getRightRoad().getLaneHeight()) {
                    sport.setxAxis(x);
                    sport.setyAxis(y);
                    if(Collision.collision(x,y,sport,RoadDirection.RIGHT) == false){
                        this.repaint();
                        return;
                    }
                }
            }
        }



        if(event.getSource().equals(this.getBottomControls().getExperiencedDriver2())){
            Vehicle sport2 = new VehicleFactory(this.getRoadContainer().getLeftRoad().getWidth()-100,this.getRoadContainer().getLeftRoad().getyAxis()+10,new File("resource/image/sportcarfliped.png"),RoadDirection.LEFT).getVehicle("sport");
            this.getRoadContainer().getLeftRoad().addCar(sport2);
            light.registerObserver(sport2);
            Collision collision2 = new Collision();
            collision2.setVehicles(this.getRoadContainer().getLeftRoad().getCars());

            for(int x = this.getRoadContainer().getLeftRoad().getRoadWidth()-100; x > 0; x = x - 20){
                for(int y=this.getRoadContainer().getLeftRoad().getyAxis(); y < this.getRoadContainer().getLeftRoad().getLaneHeight()*this.getRoadContainer().getLeftRoad().getNumberOfLane(); y = y + this.getRoadContainer().getLeftRoad().getLaneHeight()) {
                    sport2.setxAxis(x);
                    sport2.setyAxis(y);
                    if(collision2.collision(x,y,sport2,RoadDirection.LEFT) == false){
                        this.repaint();
                        return;
                    }
                }
            }
        }



        if(event.getSource().equals(this.getBottomControls().getRecklessDriver())){
            Vehicle suv = new VehicleFactory(this.getRoadContainer().getRightRoad().getxAxis(),this.getRoadContainer().getRightRoad().getyAxis()+10,new File("resource/image/suv.png"),RoadDirection.RIGHT).getVehicle("suv");
            this.getRoadContainer().getRightRoad().addCar(suv);
            light.registerObserver(suv);
            Collision.setVehicles(this.getRoadContainer().getRightRoad().getCars());
            for(int x= 0; x < this.getRoadContainer().getRightRoad().getRoadWidth(); x = x + 20){
                for(int y=this.getRoadContainer().getRightRoad().getyAxis()+10; y < this.getRoadContainer().getRightRoad().getLaneHeight()*this.getRoadContainer().getRightRoad().getNumberOfLane(); y = y + this.getRoadContainer().getRightRoad().getLaneHeight()) {
                    suv.setxAxis(x);
                    suv.setyAxis(y);
                    if(Collision.collision(x,y,suv,RoadDirection.RIGHT) == false){
                        this.repaint();
                        return;
                    }
                }
            }
        }

        if(event.getSource().equals(this.getBottomControls().getRecklessDriver2())){
            Vehicle suv2 = new VehicleFactory(this.getRoadContainer().getLeftRoad().getWidth()-100,this.getRoadContainer().getLeftRoad().getyAxis()+10,new File("resource/image/suvfliped.png"),RoadDirection.LEFT).getVehicle("suv");
            this.getRoadContainer().getLeftRoad().addCar(suv2);
            light.registerObserver(suv2);
            Collision collision2 = new Collision();
            collision2.setVehicles(this.getRoadContainer().getLeftRoad().getCars());

            for(int x = this.getRoadContainer().getLeftRoad().getRoadWidth()-100; x > 0; x = x - 20){
                for(int y=this.getRoadContainer().getLeftRoad().getyAxis(); y < this.getRoadContainer().getLeftRoad().getLaneHeight()*this.getRoadContainer().getLeftRoad().getNumberOfLane(); y = y + this.getRoadContainer().getLeftRoad().getLaneHeight()) {
                    suv2.setxAxis(x);
                    suv2.setyAxis(y);
                    if(collision2.collision(x,y,suv2,RoadDirection.LEFT) == false){
                        this.repaint();
                        return;
                    }
                }
            }
        }




        if(event.getSource().equals(this.getBottomControls().getNormalDriver())){
            Vehicle sedan = new VehicleFactory(this.getRoadContainer().getRightRoad().getxAxis(),this.getRoadContainer().getRightRoad().getyAxis()+10,new File("resource/image/sedan.png"),RoadDirection.RIGHT).getVehicle("sedan");
            this.getRoadContainer().getRightRoad().addCar(sedan);
            light.registerObserver(sedan);
            Collision collision1 = new Collision();
            collision1.setVehicles(this.getRoadContainer().getRightRoad().getCars());
            for(int x= 0; x < this.getRoadContainer().getRightRoad().getRoadWidth(); x = x + 20){

                for(int y=this.getRoadContainer().getRightRoad().getyAxis()+10; y < this.getRoadContainer().getRightRoad().getLaneHeight()*this.getRoadContainer().getRightRoad().getNumberOfLane(); y = y + this.getRoadContainer().getRightRoad().getLaneHeight()) {
                    sedan.setxAxis(x);
                    sedan.setyAxis(y);
                    if(collision1.collision(x,y,sedan,RoadDirection.RIGHT) == false){
                        this.repaint();
                        return;
                    }
                }
            }

        }

        if(event.getSource().equals(this.getBottomControls().getNormalDriver2())){
            Vehicle sedan2 = new VehicleFactory(this.getRoadContainer().getLeftRoad().getWidth()-100,this.getRoadContainer().getLeftRoad().getyAxis()+10,new File("resource/image/sedanfliped.png"),RoadDirection.LEFT).getVehicle("sedan");
            this.getRoadContainer().getLeftRoad().addCar(sedan2);
            light.registerObserver(sedan2);
            Collision collision2 = new Collision();
            collision2.setVehicles(this.getRoadContainer().getLeftRoad().getCars());

            for(int x = this.getRoadContainer().getLeftRoad().getRoadWidth()-100; x > 0; x = x - 20){

                for(int y=this.getRoadContainer().getLeftRoad().getyAxis(); y < this.getRoadContainer().getLeftRoad().getLaneHeight()*this.getRoadContainer().getLeftRoad().getNumberOfLane(); y = y + this.getRoadContainer().getLeftRoad().getLaneHeight()) {
                    sedan2.setxAxis(x);
                    sedan2.setyAxis(y);
                    if(collision2.collision(x,y,sedan2,RoadDirection.LEFT) == false){
                        this.repaint();
                        return;
                    }
                }
            }

        }
    }

    @Override
    public void run() {
        System.out.println(timeclass.getRunning());
        while(timeclass.getRunning() == true) {
            this.getRoadContainer().getRightRoad().moveCars();
            this.getRoadContainer().getLeftRoad().moveCars();
            this.repaint();

            try {
                Thread.sleep(Configuration.getThreadSleepTime());
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
