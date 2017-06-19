package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

public class TroncosModule extends MobileElement{

	private ArrayList<Tronco> troncos;
	
	public TroncosModule(){
		
		super(false);
		this.initElements();
		
	}
	
	@Override 
	 void initElements(){
		
		this.troncos = new ArrayList();
		
		
		/* É preciso cuidado na hora de iniciar os elementos para que os mesmos nao ultrapassem suas zonas,
		 * ou seja, os troncos por exemplo devem permanecer ao intervalo de y:[81 - 260] levando 
		 * em consideração sua altura e largura.
		 */
		
		//this.troncos.add(new Tronco(1,81, 1));
		//this.troncos.add(new Tronco(10,200, 1));
		//this.troncos.add(new Tronco(15,255, 1));
		
		
	}


	@Override
	public int checkColisionWithMobileCenarioElement(GameObject player) {
		
		for(int i=0;i<this.troncos.size();i++){
			
			if(this.troncos.get(i).collided(player)){
				
				return i;
			}
			
		}
		
		return invalid;
		
	}
	
	
	@Override
	public void moveAndDrawMobileElements(Window janela){
		
		for(int index = 0;index<this.troncos.size();index++){
			
			this.troncos.get(index).draw();
			this.troncos.get(index).mover();
			
			if(this.troncos.get(index).checkEndOfMap(janela.getWidth())){
				
				this.troncos.get(index).resetPosition();
			}
			
		}
		
	}

	
	public ArrayList<Tronco> getTroncos(){
		
		return this.troncos;
	}
	
	
	
	
	
}
