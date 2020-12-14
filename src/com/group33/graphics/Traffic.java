package com.group33.graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;


import com.group33.collision.Collision;
import com.group33.road.IRoad;
import com.group33.road.Road;
import com.group33.road.RoadDirection;
import com.group33.road.RoadFactory;
import com.group33.time.timeclass;
import com.group33.trafficlight.LightClass;
import com.group33.trafficlight.Observer;
import com.group33.vehicle.*;

public class Traffic implements ActionListener, Runnable {
	
	int width;
	int height;
	String title;
	Road rightRoad;
	Road leftRoad;

	
	JFrame frame;
	JButton start = new JButton("Show Green Light");
	JButton stop= new JButton("Show Red Light");
	JButton reset= new JButton("Restart Simulation");
	JButton experiencedDriver = new JButton("Add Experienced Driver");
	JButton recklessDriver = new JButton("Add Reckless Driver");
	JButton normalDriver = new JButton("Add Normal Driver");
	JButton experiencedDriver2 = new JButton("Add Experienced Driver");
	JButton recklessDriver2 = new JButton("Add Reckless Driver");
	JButton normalDriver2= new JButton("Add Normal Driver");
	Container topContainer = new Container();
	Container bottomContainer = new Container();
	Container vehicleContainer = new Container();
	TrafficLight trafficLight;
	TrafficLight trafficLight2;
	LightClass light = new LightClass();

	boolean running;

	public Traffic(String title,int width,int height) throws HeadlessException {
		
		frame = new JFrame(); 
		JButton jbutton = new JButton("test");
		frame.setTitle(title);
		frame.setSize(width,height);
		frame.setPreferredSize(new Dimension(width,height));


		frame.setLayout(new BorderLayout());
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		vehicleContainer.setLayout(new GridLayout(2,0));

		rightRoad = new RoadFactory(0,50,width,3,76,RoadDirection.RIGHT).getRoad();

		trafficLight = new TrafficLight(width-100,0);

		rightRoad.add(trafficLight);


		leftRoad = new RoadFactory(0,70,width,3,76,RoadDirection.LEFT).getRoad();

		trafficLight2 = new TrafficLight(50,20);

		leftRoad.add(trafficLight2);
		
		vehicleContainer.add((Road)rightRoad);
		
		vehicleContainer.add((Road)leftRoad);
		
	
		
		frame.add(vehicleContainer,BorderLayout.CENTER);
		
		

		bottomContainer.setLayout(new GridLayout(1,3));
		bottomContainer.add(start);
		start.addActionListener(this);
		bottomContainer.add(stop);
		stop.addActionListener(this);
		bottomContainer.add(reset);
		reset.addActionListener(this);


		frame.add(bottomContainer, BorderLayout.NORTH);


		topContainer.setLayout(new GridLayout(2,3));
		topContainer.add(experiencedDriver);
		experiencedDriver.addActionListener(this);
		topContainer.add(recklessDriver);
		recklessDriver.addActionListener(this);
		topContainer.add(normalDriver);
		normalDriver.addActionListener(this);
		topContainer.add(experiencedDriver2);
		experiencedDriver2.addActionListener(this);
		topContainer.add(recklessDriver2);
		recklessDriver2.addActionListener(this);
		topContainer.add(normalDriver2);
		normalDriver2.addActionListener(this);

		frame.add(topContainer, BorderLayout.SOUTH);
		
		
		
		frame.setVisible(true);

		frame.repaint();
		frame.pack();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(start)) {
			if(running == false) {
				//call the time class
				timeclass.setStartTime();
				timeclass.getInstance().changeRunningStatus();
				running = timeclass.getInstance().getRunning();
				Thread t = new Thread(this);
				t.start();
				this.trafficLight.getLight().nextState();
				this.trafficLight2.getLight().nextState();
			}
		}
		
		if(event.getSource().equals(stop)) {
//			running = false;
//			this.trafficLight.getLight().nextState();
//			this.trafficLight2.getLight().nextState();
			light.setTrafficstate(false);
		}

		if(event.getSource().equals(reset)) {
			running = false;
			this.trafficLight.getLight().reset();
			this.trafficLight2.getLight().reset();
			leftRoad.reset();
			rightRoad.reset();

		}

		if(event.getSource().equals(experiencedDriver)){
			Vehicle sport = new VehicleFactory(rightRoad.getxAxis(),rightRoad.getyAxis()+10,new File("resource/image/sportcar.png"),RoadDirection.RIGHT).getVehicle("sport");
			rightRoad.addCar(sport);
			light.registerObserver(sport);
			Collision.setVehicles(rightRoad.getCars());
			for(int x= 0; x < rightRoad.getRoadWidth(); x = x + 20){
				for(int y=rightRoad.getyAxis()+10; y < rightRoad.getLaneHeight()*rightRoad.getNumberOfLane(); y = y + rightRoad.getLaneHeight()) {
					sport.setxAxis(x);
					sport.setyAxis(y);
					if(Collision.collision(x,y,sport,RoadDirection.RIGHT) == false){
						frame.repaint();
						return;
					}
				}
			}
		}



		if(event.getSource().equals(experiencedDriver2)){
			Vehicle sport2 = new VehicleFactory(leftRoad.getWidth()-100,leftRoad.getyAxis()+10,new File("resource/image/sportcarfliped.png"),RoadDirection.LEFT).getVehicle("sport");
			leftRoad.addCar(sport2);
<<<<<<< HEAD
			light.registerObserver(sport2);
=======
>>>>>>> master
			Collision collision2 = new Collision();
			collision2.setVehicles(leftRoad.getCars());

			for(int x = leftRoad.getRoadWidth()-100; x > 0; x = x - 20){
				for(int y=leftRoad.getyAxis(); y < leftRoad.getLaneHeight()*leftRoad.getNumberOfLane(); y = y + leftRoad.getLaneHeight()) {
					sport2.setxAxis(x);
					sport2.setyAxis(y);
					if(collision2.collision(x,y,sport2,RoadDirection.LEFT) == false){
						frame.repaint();
						return;
					}
				}
			}
		}



		if(event.getSource().equals(recklessDriver)){
			Vehicle suv = new VehicleFactory(rightRoad.getxAxis(),rightRoad.getyAxis()+10,new File("resource/image/suv.png"),RoadDirection.RIGHT).getVehicle("suv");
			rightRoad.addCar(suv);
			light.registerObserver(suv);
			Collision.setVehicles(rightRoad.getCars());
			for(int x= 0; x < rightRoad.getRoadWidth(); x = x + 20){
				for(int y=rightRoad.getyAxis()+10; y < rightRoad.getLaneHeight()*rightRoad.getNumberOfLane(); y = y + rightRoad.getLaneHeight()) {
					suv.setxAxis(x);
					suv.setyAxis(y);
					if(Collision.collision(x,y,suv,RoadDirection.RIGHT) == false){
						frame.repaint();
						return;
					}
				}
			}
		}

		if(event.getSource().equals(recklessDriver2)){
			Vehicle suv2 = new VehicleFactory(leftRoad.getWidth()-100,leftRoad.getyAxis()+10,new File("resource/image/suvfliped.png"),RoadDirection.LEFT).getVehicle("suv");
			leftRoad.addCar(suv2);
			light.registerObserver(suv2);
			Collision collision2 = new Collision();
			collision2.setVehicles(leftRoad.getCars());

			for(int x = leftRoad.getRoadWidth()-100; x > 0; x = x - 20){
				for(int y=leftRoad.getyAxis(); y < leftRoad.getLaneHeight()*leftRoad.getNumberOfLane(); y = y + leftRoad.getLaneHeight()) {
					suv2.setxAxis(x);
					suv2.setyAxis(y);
					if(collision2.collision(x,y,suv2,RoadDirection.LEFT) == false){
						frame.repaint();
						return;
					}
				}
			}
		}




		if(event.getSource().equals(normalDriver)){
			Vehicle sedan = new VehicleFactory(rightRoad.getxAxis(),rightRoad.getyAxis()+10,new File("resource/image/sedan.png"),RoadDirection.RIGHT).getVehicle("sedan");
			rightRoad.addCar(sedan);
			light.registerObserver(sedan);
			Collision collision1 = new Collision();
			collision1.setVehicles(rightRoad.getCars());
			for(int x= 0; x < rightRoad.getRoadWidth(); x = x + 20){

				for(int y=rightRoad.getyAxis()+10; y < rightRoad.getLaneHeight()*rightRoad.getNumberOfLane(); y = y + rightRoad.getLaneHeight()) {
					System.out.println("here1 "+y);
					sedan.setxAxis(x);
					sedan.setyAxis(y);
					if(collision1.collision(x,y,sedan,RoadDirection.RIGHT) == false){
						frame.repaint();
						return;
					}
				}
			}

		}

		if(event.getSource().equals(normalDriver2)){
			Vehicle sedan2 = new VehicleFactory(leftRoad.getWidth()-100,leftRoad.getyAxis()+10,new File("resource/image/sedanfliped.png"),RoadDirection.LEFT).getVehicle("sedan");
			leftRoad.addCar(sedan2);
<<<<<<< HEAD
			light.registerObserver(sedan2);
=======
>>>>>>> master
			Collision collision2 = new Collision();
			collision2.setVehicles(leftRoad.getCars());

			for(int x = leftRoad.getRoadWidth()-100; x > 0; x = x - 20){

				for(int y=leftRoad.getyAxis(); y < leftRoad.getLaneHeight()*leftRoad.getNumberOfLane(); y = y + leftRoad.getLaneHeight()) {
					sedan2.setxAxis(x);
					sedan2.setyAxis(y);
					if(collision2.collision(x,y,sedan2,RoadDirection.LEFT) == false){
						frame.repaint();
						return;
					}
				}
			}
<<<<<<< HEAD
=======

		}
>>>>>>> master

		}

		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(timeclass.getInstance().getRunning() == true) {
			rightRoad.moveCars();
			leftRoad.moveCars();
			frame.repaint();

			try {
				Thread.sleep(350);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}


	/*@Override
	public void update(Object args) {
		String light = (String) args;
		System.out.println("The traffic light changed here is!");
		running = false;
		this.trafficLight.getLight().nextState();
		this.trafficLight2.getLight().nextState();
	}*/
}
