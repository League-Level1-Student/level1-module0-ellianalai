package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static PImage background;
    static PImage bird;
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
        
    }

    @Override
    public void setup() {
    	background = loadImage("images/flappyBackground.jpg");
    	background.resize(WIDTH, HEIGHT);
    	image(background, 0,0);
    	
    	bird = loadImage("images/bird.png");
    	bird.resize(50, 50);
    	image(bird, 200,300);
    }

    @Override
    public void draw() {
        
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
