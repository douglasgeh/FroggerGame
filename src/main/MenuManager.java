package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;

public class MenuManager extends Sprite{

	
	private GameImage menuImg;
	
	private Keyboard keyboard;
	
	final public int NovoJogo = 0;
	final public int Ranking = 1;
	final public int Sair = 2;
	
	private int currentArrowLocation;
	
	private ArrayList<Point> menuOptionLocation;
	
	
	
	public MenuManager(Keyboard keyboard) {
		
		super(URL.sprite("Triangle.png"), 1);
		
		this.menuImg = new GameImage(URL.sprite("menuImg.png"));
		
		this.keyboard = keyboard;
		
		this.currentArrowLocation = this.NovoJogo;
		
		this.initMenuOptionsLocations();
		
		this.setArrowLocation();
		
		
	}
	
	public int parseLocationForMenuArrowAccordingToKeyboard() throws InterruptedException{
		
		
		if(this.keyboard.keyDown(Keyboard.DOWN_KEY)){
			
			if(this.currentArrowLocation!=this.Sair){
				
				this.currentArrowLocation+=1;
				this.setArrowLocation();
				
				
			}
			
		}
		
		if(this.keyboard.keyDown(Keyboard.UP_KEY)){
			
			if(this.currentArrowLocation != this.NovoJogo){
				
				this.currentArrowLocation-=1;
				this.setArrowLocation();
				
			}
			
		}
		
		return this.currentArrowLocation;
		
	}
	
	private void setArrowLocation(){
		
		this.x = this.menuOptionLocation.get(this.currentArrowLocation).getX();
		this.y = this.menuOptionLocation.get(this.currentArrowLocation).getY();
		
	}
	
	
	public void drawMenuAndArrow(){
		
		this.menuImg.draw();
		this.draw();
	}
	
	
	private void initMenuOptionsLocations(){
		
		this.menuOptionLocation = new ArrayList();
		
		this.menuOptionLocation.add(new Point(108,321)); // NOVO JOGO LOCATION
		this.menuOptionLocation.add(new Point(153,405)); // RANKING LOCATION
		this.menuOptionLocation.add(new Point(220,491)); // SAIR LOCATION
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
