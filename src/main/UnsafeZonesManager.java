package main;

import java.util.ArrayList;

import jplay.GameObject;

public class UnsafeZonesManager {

	private ArrayList<GameObject> canteiroSuperior;
	
	public UnsafeZonesManager(){
		
		this.initCanteiroSuperior();		
		
		
	}
	
	private void initCanteiroSuperior(){
		
			this.canteiroSuperior = new ArrayList<>();

			GameObject canteiro1 = new GameObject();
			GameObject canteiro2 = new GameObject();
			GameObject canteiro3 = new GameObject();
			GameObject canteiro4 = new GameObject();
			
			canteiro1.x = 0;
			canteiro1.y = 0;
			
			canteiro2.x = 160;
			canteiro2.y = 0;
			
			canteiro3.x = 320;
			canteiro3.y = 0;
			
			canteiro4.x = 480;
			canteiro4.y = 0;
			
			canteiro1.width = 80;
			canteiro1.height = 80;
			
			canteiro2.width = 80;
			canteiro2.height = 80;
			
			canteiro3.width = 80;
			canteiro3.height = 80;
			
			canteiro4.width = 80;
			canteiro4.height = 80;
		
			
			
			this.canteiroSuperior.add(canteiro1);
			this.canteiroSuperior.add(canteiro2);
			this.canteiroSuperior.add(canteiro3);
			this.canteiroSuperior.add(canteiro4);
		
	}
	
	public boolean checkColisions(GameObject player){
		
		for(GameObject canteiro:this.canteiroSuperior){
			
			if(player.x>=canteiro.x && player.x+player.width <= canteiro.x+canteiro.width && player.y <= 50){
				
				return true;
			}
			
			
		}
		
		
		return false;
		
	}
	
	
}
