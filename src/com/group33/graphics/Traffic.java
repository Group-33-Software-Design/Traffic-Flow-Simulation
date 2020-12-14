package com.group33.graphics;

import com.group33.road.Road;
import com.group33.road.RoadFactory;
import com.group33.road.RoadDirection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Traffic implements Runnable, ActionListener {

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
	Image backgroundImage;

	private boolean running;

	public Traffic(String title,int width,int height)  {
		
		frame = new JFrame();
		trafficLight = new TrafficLight(width-100,0);
		frame.setTitle(title);
		frame.setSize(width,height);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setLayout(new BorderLayout());
		frame.setSize(width, height);
		frame.add(trafficLight,BorderLayout.NORTH);

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

		vehicleContainer.setLayout(new GridLayout(2,0));

		rightRoad = new RoadFactory(0,50,width,3,76,RoadDirection.RIGHT).getRoad();

		trafficLight = new TrafficLight(width-100,0);

		rightRoad.add(trafficLight);


		leftRoad = new RoadFactory(0,70,width,3,76,RoadDirection.LEFT).getRoad();

		trafficLight2 = new TrafficLight(50,20);

		leftRoad.add(trafficLight2);

		vehicleContainer.add(rightRoad);

		vehicleContainer.add(leftRoad);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running == true) {
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


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(start)) {
			if(running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
				this.trafficLight.getLight().nextState();
				this.trafficLight2.getLight().nextState();
			}
		}

		if(event.getSource().equals(stop)) {
			running = false;
			this.trafficLight.getLight().nextState();
			this.trafficLight2.getLight().nextState();
		}

		if(event.getSource().equals(reset)) {
			running = false;
			this.trafficLight.getLight().reset();
			this.trafficLight2.getLight().reset();
			leftRoad.reset();
			rightRoad.reset();

		}
	}
}
