package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static PImage background;
    static PImage bird;
    static PImage top_pipe;
    static PImage bottom_pipe;
    static int pipe_x = 800;
    static int bird_y = 100;;
    static int bird_velocity = -10;
    static int gravity = 1;
    int upperPipeHeight = (int) random(100, 400);
    int pipeGap = 150;
    int lowerY = upperPipeHeight + pipeGap;
    int bottom_pipe_height = HEIGHT - lowerY;
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
    	if (bird_y < 600) {
    		bird_y+=bird_velocity;
    		bird_velocity += gravity;
    		image(top_pipe, pipe_x,0);
        	pipe_x-=5;
    		image(bird, 100,bird_y);
    		image(bottom_pipe, pipe_x,lowerY);
    		pipes();
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
    	if (bird_y > upperPipeHeight ) {
    		
    	}
    	return true;
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
