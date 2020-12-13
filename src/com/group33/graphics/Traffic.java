package com.group33.graphics;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;

public class Traffic implements Runnable {

	private int width;
	private int height;
	private String title;

	private JFrame frame;
	private TrafficLight trafficLight;
	private Image backgroundImage;

	private boolean running;

	public Traffic(String title,int width,int height)  {
		
		frame = new JFrame();
		trafficLight = new TrafficLight(width-100,0);
		frame.setTitle(title);
		frame.setSize(width,height);
		frame.setPreferredSize(new Dimension(width,height));
        try {
            this.backgroundImage = ImageIO.read(new File("resource/image/NewRoad.png"));
            this.backgroundImage = this.backgroundImage.getScaledInstance(width, height, this.backgroundImage.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		frame.setLayout(new BorderLayout());
		frame.setSize(width, height);
		frame.add(new JLabel(new ImageIcon(this.backgroundImage)),BorderLayout.SOUTH);
		frame.add(trafficLight,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


	

	@Override
	public void run() {
		
	}
	
	
	
}
