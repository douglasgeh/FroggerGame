package main;

import java.util.concurrent.TimeUnit;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;



public class MainGrame {

	
	final static int NovoJogo = 0;
	final static int Ranking = 1;
	final static int Sair = 2;
	final static int WindowHeight = 800;
	final static int WindowWidth = 640;
	
	public static void main(String [] args) throws InterruptedException{
		
		Window janela = new Window(WindowWidth,WindowHeight);
		MenuManager menu = new MenuManager(janela.getKeyboard());
		Keyboard teclado = janela.getKeyboard();
		GameState gameMenuState = GameState.RUNING;
		
		int selectedOption = NovoJogo;
		
		while(gameMenuState == GameState.RUNING){
			
			selectedOption = menu.parseLocationForMenuArrowAccordingToKeyboard();
			menu.drawMenuAndArrow();
			janela.update();
			TimeUnit.MILLISECONDS.sleep(300);
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)){
				
				setNextScreenAccordingToSelectedOption(selectedOption, janela);
			}
			
			
		}
		
	}
	
	public static void setNextScreenAccordingToSelectedOption(int selectedOption, Window janela){
		
		switch(selectedOption){
			
		case NovoJogo: new Cenario(janela);
		
						
			break;
			
		case Sair: System.exit(0);
			break;
		}
		
		
	}
	
}
