package com.group33.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class Traffic implements Runnable {
	
	int width;
	int height;
	String title;
	

	
	JFrame frame;
	

	boolean running;

	public Traffic(String title,int width,int height)  {
		
		frame = new JFrame(); 
		
		frame.setTitle(title);
		frame.setSize(width,height);
		frame.setPreferredSize(new Dimension(width,height));


		frame.setLayout(new BorderLayout());
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		
		
		frame.setVisible(true);

	
	}
	


	

	@Override
	public void run() {
		
	}
	
	
	
}
