package com.group33.lane;

import com.group33.vehicle.Vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Lane extends JComponent{
	
	public int LANE_HEIGHT;
	public int NUMBER_OF_LANE;
	public final int ROAD_LINE_DERMACATOR_SPACE = 40;
	public final int ROAD_LINE_DEMACATOR_BOX_WIDTH = 30;
	public final int ROAD_LINE_DEMACATOR_BOX_HEIGHT = 5;
	public int laneWidth;
	public int xAxis;
	public int yAxis;
	
	ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
	
	
	public Lane(int laneWidth, int numberOfLane, int laneHeight, int xposition, int yposistion) {
		this.laneWidth = laneWidth;
		this.NUMBER_OF_LANE = numberOfLane;
		this.LANE_HEIGHT = laneHeight;
		this.xAxis = xposition;
		this.yAxis =  yposistion;
	}
	
	
	public void addCar(Vehicle v) {
		cars.add(v);
	}
	 
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		System.out.println("laneHeight "+this.LANE_HEIGHT);
		System.out.println("Number of lane "+this.NUMBER_OF_LANE);
		System.out.println("lane width "+this.laneWidth);
		for(int a=this.LANE_HEIGHT; a < this.LANE_HEIGHT*this.NUMBER_OF_LANE;  a = a+this.LANE_HEIGHT) { //Which lane am drawing
			for(int b = 0+this.xAxis; b < this.laneWidth; b = b+this.ROAD_LINE_DERMACATOR_SPACE) { //which line am drawing
				
				g.fillRect(b, a+this.yAxis, this.ROAD_LINE_DEMACATOR_BOX_WIDTH, this.ROAD_LINE_DEMACATOR_BOX_HEIGHT);
			}
		}
		
		//Draw Cars
		for(int a=0; a < cars.size(); a++) {
			cars.get(a).drawCar(g);
		}
	 }


	public ArrayList<Vehicle> getCars() {
		return cars;
	}
	
	
	
}


	
	
	
	