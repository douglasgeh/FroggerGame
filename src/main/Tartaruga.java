package main;

import jplay.Sprite;
import jplay.URL;

public class Tartaruga extends Sprite{

	private double velocity;
	private int frameControl;
	private int frameMultiplierControl;
	
	public Tartaruga(int x, int y) {
		super(URL.sprite("tartarugasFrames.png"), 4);
		
		this.x = x;
		this.y = y;
		
		this.velocity = 0.1;
		
		this.frameControl = 0;
		this.frameMultiplierControl = 0;
		
		// TODO Auto-generated constructor stub
	}

	public void mover(){
		
		if(this.frameControl == 3 && this.frameMultiplierControl%200 == 0){
			
			this.frameControl = 0;
			this.setSequence(3, 0);
		}
		else if(this.frameControl == 0 && this.frameMultiplierControl%200 == 0){
			
			this.frameControl = 1;
			this.setSequence(0, 1);
		}
		else if(this.frameControl == 1 && this.frameMultiplierControl%200 == 0){
			
			this.frameControl = 2;
			this.setSequence(1, 2);
		}
		else if(this.frameControl == 2 && this.frameMultiplierControl%200 == 0){
			
			this.frameControl = 3;
			this.setSequence(2,3);
		}
		
		
		this.update();
		
		 this.x+=this.velocity;
		
		this.frameMultiplierControl++;
		
	}
	
	
  public double getVelocity(){
		
		return this.velocity;
	}
	
	public void resetPosition(){
		
		this.x = -185;
	}
	
	public boolean checkEndOfMap(int mapFinalPositionX){
		
		if(this.x >= mapFinalPositionX){
			
			return true;
		}else{
			
			return false;
		}
	}
	
	
	
	
	
}
