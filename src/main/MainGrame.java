package main;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;



public class MainGrame {

	
	public static void main(String [] args){
		
		Window janela = new Window(640,800);
		GameImage plano = new GameImage(URL.sprite("teste.png"));
		
		Keyboard teclado = janela.getKeyboard();
		
		
		while(true){
			
			plano.draw();
			
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)){
				
				new Cenario(janela);
			}
			
			
		}
		
	}
	
}
