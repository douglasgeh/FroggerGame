package main;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;

public class MenuManager extends Sprite{

	
	private GameImage menuImg;
	
	private Keyboard keyboard;
	
	public MenuManager(int x, int y, Keyboard keyboard) {
		
		super(URL.sprite("Triangle.png"), 1);
		
		this.x = x;
		this.y = y;
		
		this.keyboard = keyboard;
		
		this.menuImg = new GameImage(URL.sprite("menuImg.png"));
		
	}
	
	public void setLocationForMenuArrowAccordingToKeyboard(){
		
		
		if(this.keyboard.keyDown(Keyboard.DOWN_KEY)){
			
			System.out.println("dOWN pressed");
		}
		
	}
	
	public void drawMenuAndArrow(){
		
		this.menuImg.draw();
		this.draw();
	}
	
	
	
	
	
	
}
