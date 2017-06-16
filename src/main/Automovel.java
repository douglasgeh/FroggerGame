package main;

import jplay.Sprite;
import jplay.URL;

public class Automovel extends Sprite{

	
	private double velocidade;
	
	public Automovel(int x, int y, String image) {
		super(URL.sprite(image+".png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.velocidade = 0.1;
	}

	
	public void mover(){
		
		this.x+=this.velocidade;
		
	}
	
	public double getVelocity(){
		
		return this.velocidade;
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

