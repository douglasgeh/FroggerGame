package main;

import jplay.Sprite;
import jplay.URL;

public class Automovel extends Sprite{

	
	private double velocidade;
	private int direcao;
	
	public Automovel(int x, int y, String image, int direcao) {
		super(URL.sprite(image+".png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.velocidade = 0.2*direcao;
		this.direcao = direcao;
	}

	
	public void mover(){
		
		this.x+=this.velocidade;
		
	}
	
	public double getVelocity(){
		
		return this.velocidade;
	}
	
	public void increaseVelocity(int tax) {
		this.velocidade *= tax;
	}
	
	public void resetPosition(){
		
		if(this.direcao == 1)this.x = -185;
		else this.x = 640;
		
	}
	
	public boolean checkEndOfMap(int mapFinalPositionX){
		
		if(this.x >= mapFinalPositionX && direcao == 1){
			
			return true;
		}else if(this.x+this.width <= 0 && direcao == -1){
			
			return true;
		}
		else{
			
			return false;
		}
	}	
	
	
	
}

