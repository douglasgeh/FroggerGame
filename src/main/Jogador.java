package main;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Jogador extends Sprite{

	private double velocidade = 0.2;
	private double direcao = 3;
	private Keyboard teclado;
	private boolean movendo = false;
	private int lifes;
	private boolean depending;
	
	public Jogador(int x, int y) {
		
		super(URL.sprite("singleFrog.png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.depending = false;
		
		this.lifes = 3;
		
		// TODO Auto-generated constructor stub
	}
	



	
	public void setDepending(boolean depending){
		
		this.depending = depending;
	}

	public boolean getDepending(){
		
		return this.depending;
	}
	
	public void moveAccordingToKeyboard(Window janela){
		
		if(this.teclado == null){
			
			this.teclado = janela.getKeyboard();
		}
		
		
		if(this.teclado.keyDown(Keyboard.LEFT_KEY)){
			
			if(this.x>0){
				
				this.x -= this.velocidade;
				
			}

		}else if(this.teclado.keyDown(Keyboard.RIGHT_KEY)){
			
			if(this.x < janela.getWidth()-50){
				
				this.x+=this.velocidade;
			
			}
			
			
		}else if(this.teclado.keyDown(Keyboard.DOWN_KEY)){
			
			if(this.y<janela.getHeight()-50){
				
				this.y+=this.velocidade;
				
			}
			
			
		}else if(this.teclado.keyDown(Keyboard.UP_KEY)){
			
			if(this.y > 0){
				
				this.y-=this.velocidade;
				
			}
			
			
		}
		
		
		
		
		
	}
	
	public void moveAccordingToCenarioElement(double elementSpeed){
		
		this.x+=elementSpeed;
		
	}
	
	public int getLifes(){
		
		return this.lifes;
	}
	
	public void decreaseLife(){
		
		this.lifes -= 1;
	}
	
	public void resetPosition(){
		
		this.x = 350;
		this.y = 750;
	}
	
	
}
