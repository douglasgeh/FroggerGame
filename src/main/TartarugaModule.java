package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

public class TartarugaModule extends MobileElement{

	private ArrayList<Tartaruga> tartarugas;
	
	public TartarugaModule(){
		super(false);
		
		this.initElements();
		
		
	}
	
	@Override
	int checkColisionWithMobileCenarioElement(GameObject player) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.tartarugas.size();i++){
			
			if(this.tartarugas.get(i).collided(player)){
				
				return i;
			}
			
		}
		
		return invalid;
	}

	@Override
	void moveAndDrawMobileElements(Window janela) {
		// TODO Auto-generated method stub
		
		for(int index=0;index<this.tartarugas.size();index++){
			
			this.tartarugas.get(index).draw();
			this.tartarugas.get(index).mover();
			
			if(this.tartarugas.get(index).checkEndOfMap(janela.getWidth())){
				
				this.tartarugas.get(index).resetPosition();
			}
		}
		
		
		
	}

	@Override
	void initElements() {
		
		this.tartarugas = new ArrayList();
		
		
		this.tartarugas.add(new Tartaruga(1, 40));
		this.tartarugas.add(new Tartaruga(50, 40));
		this.tartarugas.add(new Tartaruga(70, 60));
		
		// TODO Auto-generated method stub
		
	}
	
	
	public ArrayList<Tartaruga> getTartarugas(){
		
		return this.tartarugas;
	}

	
	
}
