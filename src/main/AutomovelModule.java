package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

public class AutomovelModule extends MobileElement{

	
	private ArrayList<Automovel> automoveis;
	
	public AutomovelModule(int value){
		
		super(true);
		
		this.initElements(value);
	}
	
	@Override
	int checkColisionWithMobileCenarioElement(GameObject player) {
		
		for(int i=0;i<this.automoveis.size();i++){
			
			if(this.automoveis.get(i).collided(player)){
				
				return i;
			}
			
		}
		
		return invalid;

	}

	@Override
	void moveAndDrawMobileElements(Window janela) {
		
		for(int index = 0;index<this.automoveis.size();index++){
			
			this.automoveis.get(index).draw();
			this.automoveis.get(index).mover();
			
			if(this.automoveis.get(index).checkEndOfMap(janela.getWidth())){
				
				this.automoveis.get(index).resetPosition();
			}
			
		}
		
	}
	void IncreaseVelocity(int vel){
		for (Automovel auto:this.automoveis) {
			auto.increaseVelocity(vel);
		}
	}
	@Override
	void initElements(int vel) {
		
		this.automoveis = new ArrayList();
		
		
		this.automoveis.add(new Automovel(1,405,"caminhao", 1));
		this.automoveis.add(new Automovel(1, 485, "carroAzul", -1));
		this.automoveis.add(new Automovel(1, 565, "carroAmarelo", 1));
		this.automoveis.add(new Automovel(1, 645, "caminhaoGrande", -1));
		for (Automovel auto:this.automoveis) {
			auto.increaseVelocity(vel);
		}
		
	}

	
	
	
	
}
