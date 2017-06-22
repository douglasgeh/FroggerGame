package main;

import java.util.ArrayList;

import jplay.GameObject;

public class CheckPointsModule extends StaticElement{

	private ArrayList<CheckPoint> checkPoints;
	 
	
	public CheckPointsModule(){
		
		this.initCheckPoints();
	}
	
	
	/** A função abaixo irá checar colisões entre os elementos moveis inofencivos do cenario
	 * com o sapo, e caso encontre algum resultado de colisao devolve o indice do tronco 
	 * com o qual o sapo colidiu.
	 * @return
	 */
	
	@Override
	public boolean checkColisionWithStaticCenarioElement(GameObject player) {
		
		for(int i=0;i<this.checkPoints.size();i++){
			
			if(this.checkPoints.get(i).checkIfTheFrogIsInsideTheCheckPoint(player) && !this.checkPoints.get(i).isChecked()){
				
				this.checkPoints.get(i).drawCheckedPointFrog();
				
				this.checkPoints.get(i).setChecked(true);
				
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public void draw() {
		
		for(int index = 0;index<this.checkPoints.size();index++){
			
			this.checkPoints.get(index).draw();
		}
		
	}

	private void initCheckPoints(){
		
		this.checkPoints = new ArrayList();
		
		this.checkPoints.add(new CheckPoint(80+13, 21));
		this.checkPoints.add(new CheckPoint(240+13, 21));
		this.checkPoints.add(new CheckPoint(400+13, 21));
		this.checkPoints.add(new CheckPoint(560+13, 21));
		
		
	}
	
	
	public void drawCheckedFroggsIfExists(){
		
		for(int i = 0;i<this.checkPoints.size();i++){
			if(this.checkPoints.get(i).isChecked()){
				
				this.checkPoints.get(i).drawCheckedPointFrog();
			}
			
		}
		
	}
	
	public boolean checkWin(){
		
		int checkPointsReached = 0;
		
		for(int i=0;i<this.checkPoints.size();i++){
			
			if(this.checkPoints.get(i).isChecked()){
				
				checkPointsReached++;
			}
			
		}
		
		if(this.checkPoints.size() == checkPointsReached){
			
			return true;
		}else{
			
			return false;
		}
	}
	
}
