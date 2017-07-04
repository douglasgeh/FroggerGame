package main;

import java.awt.Color;
import java.awt.Font;

import jplay.Window;

public class TimerManager {

	
	private long currentSystemTimeMS;
	private long initialSystemTimeMS;
    private long timeToPlay;
	
	
	public TimerManager(long timeToPlay){
		
		this.timeToPlay = timeToPlay;
		this.currentSystemTimeMS = System.currentTimeMillis();
		this.initialSystemTimeMS = System.currentTimeMillis();
		
	}
	
    
	
	public boolean checkEndGameIfTimeWasReached(){
		
		if(this.currentSystemTimeMS/1000 == this.timeToPlay){
			
			return true;
			
		}else{
			
			return false;
		}
		
		
	}
	
	public void printTimeToScreen(Window screen){
		
		
		this.currentSystemTimeMS =  (System.currentTimeMillis() - this.initialSystemTimeMS);
		
		screen.drawText("Timer "+Long.toString(this.currentSystemTimeMS/1000)+" / "+this.timeToPlay, 550, 760, Color.blue);
		
		
	}
	
	public void resetTimer(){
		
		this.initialSystemTimeMS = System.currentTimeMillis();
	}
	
	public long getCurrentSystemTimeMS(){
		
		return this.currentSystemTimeMS/1000;
	}
	
	
	
	
}
