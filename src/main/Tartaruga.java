package main;

import jplay.Sprite;
import jplay.URL;

public class Tartaruga extends Sprite{

	private double velocity;
	
	public Tartaruga(int x, int y) {
		super(URL.sprite("tartaruga.png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.velocity = 0.3;
		
		// TODO Auto-generated constructor stub
	}

	public void mover(){
		
		this.x+=this.velocity;
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
