package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

public class TroncosModule extends MobileElement{

	private ArrayList<Tronco> troncos;
	
	public TroncosModule(int velTax){
		
		super(false);
		this.initElements(velTax);
		
	}
	void IncreaseVelocity(int vel){
		for(Tronco tronc : troncos) {
			tronc.increaseVelocity(vel);
		}
	}
	@Override 
	 void initElements(int velTax){
		
		this.troncos = new ArrayList();
		
		
		/* � preciso cuidado na hora de iniciar os elementos para que os mesmos nao ultrapassem suas zonas,
		 * ou seja, os troncos por exemplo devem permanecer ao intervalo de y:[81 - 260] levando 
		 * em considera��o sua altura e largura.
		 */
		
		this.troncos.add(new Tronco(1,160, 1));
		//this.troncos.add(new Tronco(185,160, 1));
		this.troncos.add(new Tronco(370,160, 1));
		for(Tronco tronc : troncos) {
			tronc.increaseVelocity(velTax);
		}
		
	}


	@Override
	public int checkColisionWithMobileCenarioElement(GameObject player) {
		
		for(int i=0;i<this.troncos.size();i++){
			
			if( this.troncos.get(i).isContainedFor(player)){
				
				System.out.println("Entrou para troncos");
				
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
