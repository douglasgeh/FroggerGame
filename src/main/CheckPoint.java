package main;

import jplay.GameObject;
import jplay.Sprite;
import jplay.URL;


public class CheckPoint extends Sprite{

	private boolean checked;
	
	private Sprite checkedPointFrogg;
	
	public CheckPoint(int x, int y) {
		super(URL.sprite("correctedCheckPoint.png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.checked = false;
		
		this.checkedPointFrogg =  new Sprite(URL.sprite("checkPointFrog.png"), 1);
		
		this.checkedPointFrogg.x = this.x;
		this.checkedPointFrogg.y = this.y;
		
		// TODO Auto-generated constructor stub
	}

	
	public boolean checkIfTheFrogIsInsideTheCheckPoint(GameObject player){
		
		
		if(player.x > (this.x-17) && player.x+player.width < (this.x + this.width + 17)){
			
			if(player.y >= 0 && player.y+player.height-5 <= (this.y + this.height)){
				
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean isChecked(){
		
		return this.checked;
	}
	
	public void setChecked(boolean check){
		
		this.checked = check;
	}
	
	public void drawCheckedPointFrog(){
		
		this.checkedPointFrogg.draw();
		
	}
	

}
