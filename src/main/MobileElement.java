package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

abstract public class MobileElement {

	private boolean offensive;
	
	protected final int invalid = -1;
	
	public MobileElement(boolean offensive){
		
		this.offensive = offensive;
	}
	
	abstract int checkColisionWithMobileCenarioElement(GameObject player);
	abstract void moveAndDrawMobileElements(Window janela);
	abstract void initElements();

}
