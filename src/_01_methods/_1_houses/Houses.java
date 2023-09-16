package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot r = new Robot("mini");
	Random ran = new Random();
	String [] sizes = {"small", "medium", "large"};
	public void run() {
		// Check the recipe to find out what code to put here
		r.setWindowColor(Color.black);
		r.setSpeed(100);
		r.penDown();
		r.moveTo(30, 500);
		for(int i =0; i<10;i++) {
				draw_house(sizes[ran.nextInt(3)]);
			
	
			
		}
	}
	
	public void pointy_roof () {
				r.turn(45);
				r.move(15);
				r.turn(90);
				r.move(15);
				r.turn(45);	
			}
		
	public void flat_roof () {
		r.turn(90);
		r.move(20);
		r.turn(90);
		
	
	}
	public void draw_house (String message) {
		int num = 0;
		if(message.equals("small")) {
			num = 60;
		}
		if(message.equals("medium")) {
			num = 120;
		}
		if(message.equals("large")) {
			num = 250;
		}
		
		r.setRandomPenColor();
		r.move(num);
		int roof = ran.nextInt(2);
		if (roof==0 || num == 250) {
			flat_roof();
		}
		else if (roof==1) {
			pointy_roof();
		}
		r.move(num);
		r.turn(270);
		r.setPenColor(Color.green);
		r.move(20);
		r.turn(270);
		
	}
	
}
