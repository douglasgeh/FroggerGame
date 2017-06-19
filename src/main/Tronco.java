package main;

import jplay.Sprite;
import jplay.URL;

public class Tronco extends Sprite{

	private double velocidade;
	
	
	public Tronco(int x, int y, int size) {
		
		
		//String imagePath = this.definePathForImageSize(size);
		
		super(URL.sprite("troncoComBordas.png"), 1);
		
		
		this.x = x;
		this.y = y;
		
		this.velocidade =0.1;
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void mover(){
		
		this.x+=this.velocidade;
		
	}

	private String definePathForImageSize(int size){
		
		String pathToReturn;
		
		switch(size){
			
		case 1: pathToReturn =  "troncoPequeno.png";
		break;
		
		case 2: pathToReturn = "troncoMedio.png";
		break;
		
		case 3: pathToReturn = "troncoGrande.png";
		break;
		
		default: pathToReturn = "invalido";
		break;
		
		}
		
		return pathToReturn;
		
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
