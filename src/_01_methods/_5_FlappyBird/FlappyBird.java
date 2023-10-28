package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    PImage background;
    PImage bird;
    PImage top_pipe;
    PImage bottom_pipe;
    int pipe_x = 800;
    int bird_x = 100;
    int bird_y = 100;;
    int bird_velocity = -10;
    int gravity = 1;
    int upperPipeHeight = (int) random(100, 400);
    int pipeGap = 150;
    int lowerY = upperPipeHeight + pipeGap;
    int bottom_pipe_height = HEIGHT - lowerY;
    int score = 0;
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
        
    }

    @Override
    public void setup() {
    	background = loadImage("images/flappyBackground.jpg");
    	background.resize(WIDTH, HEIGHT);
    	
    	bird = loadImage("images/bird.png");
    	bird.resize(50, 50);
    	
    	top_pipe = loadImage("images/topPipe.png");
    	top_pipe.resize(50, 250);
    	
    	bottom_pipe = loadImage("images/bottomPipe.png");
    	bottom_pipe.resize(50, bottom_pipe_height);
    	
    	
    }

    @Override
    public void draw() {
    	image(background, 0,0);
    	if (bird_y < 600 && intersect() == false) {
    		textSize(16);
			text("Score: " + score, 20, 20);
			fill(0,0,255);
    		bird_y+=bird_velocity;
    		bird_velocity += gravity;
    		image(top_pipe, pipe_x,0);
        	pipe_x-=5;
    		image(bird, bird_x,bird_y);
    		image(bottom_pipe, pipe_x,lowerY);
    		pipes();
    		if (pipe_x == bird_x) {
    			score +=1;
    			textSize(16);
    			text("Score: " + score, 20, 20);
    			fill(0,0,255);
    		}
    	}
    	else {
    		textSize(25);
			text("Your final score is: " + score, 275, 300);
			fill(0,0,255);
    	
    	}
    	
    }
    
    public void mousePressed() {
    	bird_velocity = -10;
    
 
    }
    
    public void pipes() {
    	if (pipe_x==-50) {
    		pipe_x=800;
    		upperPipeHeight = (int) random(100, 400);
    		lowerY = upperPipeHeight + pipeGap;
    		top_pipe.resize(50, upperPipeHeight);
    		bottom_pipe_height = HEIGHT - lowerY;
    		bottom_pipe.resize(50, bottom_pipe_height);
    	}
    }
     public boolean intersect() {
    	if (bird_y < upperPipeHeight && bird_x > pipe_x ) {
    		return true;
    	}
    	else if (bird_y > lowerY && bird_x > pipe_x) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
