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
		
		// Sabemos que a largura de cada tartaruga é 73 pontos logo
		
		int larguraTartaruga = 73;
		
		
		this.tartarugas.add(new Tartaruga(1, 80));
		this.tartarugas.add(new Tartaruga(larguraTartaruga, 80));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*2), 80));
		
		this.tartarugas.add(new Tartaruga((larguraTartaruga*4), 80));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*5), 80));
		
		this.tartarugas.add(new Tartaruga((larguraTartaruga*7), 80));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*8), 80));
		
		this.tartarugas.add(new Tartaruga(1, 240));
		this.tartarugas.add(new Tartaruga(larguraTartaruga, 240));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*2), 240));
		
		this.tartarugas.add(new Tartaruga((larguraTartaruga*4), 240));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*5), 240));
		
		this.tartarugas.add(new Tartaruga((larguraTartaruga*7), 240));
		this.tartarugas.add(new Tartaruga((larguraTartaruga*8), 240));
		
		
		
		
		//this.tartarugas.add(new Tartaruga(289, 83));
		//this.tartarugas.add(new Tartaruga(361, 83));
		
		// TODO Auto-generated method stub
		
		
		System.out.println(this.tartarugas.get(0).width);
		
	}
	
	
	public ArrayList<Tartaruga> getTartarugas(){
		
		return this.tartarugas;
	}

	
	
}
