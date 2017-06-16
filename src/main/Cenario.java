package main;


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Cenario {

	private Window janela;
	private Scene cena;
	private Jogador player;
	
	private GameObject agua;
	
	private TroncosModule troncosModule;
	private CheckPointsModule checkPointsModule;
	private AutomovelModule automovelModule;
	private TartarugaModule tartarugaModule;

	private GameState gameState;
	
	final private int invalid = -1;
	
	public Cenario(Window janela){
		
		this.janela = janela;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario.scn"));
		
		this.player = new Jogador(300,750);
		
		this.checkPointsModule = new CheckPointsModule();
		this.troncosModule = new TroncosModule();
		this.automovelModule = new AutomovelModule();
		this.tartarugaModule = new TartarugaModule();
		
		this.agua = new GameObject();
		this.agua.x = 0;
		this.agua.y = 80;
		
		this.agua.width = this.janela.getWidth();
		this.agua.height = 240;
		
		this.gameState = GameState.RUNING;
	
		run();
	}
	
	
	private void run(){
		
		
		while(this.gameState != GameState.EXIT){

			while(this.gameState == GameState.RUNING){
				
				
				this.checkAndSolveColisions();
				this.drawCenarioElements();
				
				
				janela.update();
				
				
			}
			
			if(this.gameState == GameState.GAME_OVER){
				
				
			}
			
			
		}
		
		
		
		
	}
	

	public void drawCenarioElements(){
		
		this.cena.draw();
		
		this.troncosModule.moveAndDrawMobileElements(this.janela);
		
		this.automovelModule.moveAndDrawMobileElements(this.janela);
		
		this.tartarugaModule.moveAndDrawMobileElements(this.janela);
		
		this.player.draw();
		this.player.moveAccordingToKeyboard(this.janela);
		
	}
	
	
	private boolean checkCenarioMobileElementsColision(){
		
		boolean fatalColision = false;
		
		/** Checando colisao com carros, troncos ou tartarugas **/
		
		int colisionElementIndex = this.troncosModule.checkColisionWithMobileCenarioElement(this.player);
		
		if(colisionElementIndex!=invalid){
	
			player.moveAccordingToCenarioElement(this.troncosModule.getTroncos().get(colisionElementIndex).getVelocity());
			
			this.player.setDepending(true);
			
			fatalColision = false;
		}
		else{
			
			this.player.setDepending(false);
		}
		
		colisionElementIndex = this.tartarugaModule.checkColisionWithMobileCenarioElement(this.player);
		
		if(colisionElementIndex!=invalid){
			
			player.moveAccordingToCenarioElement(this.tartarugaModule.getTartarugas().get(colisionElementIndex).getVelocity());
			
			this.player.setDepending(true);
			
			fatalColision = false;
			
		}else{
			
			this.player.setDepending(false);
		}
		
		if(this.automovelModule.checkColisionWithMobileCenarioElement(this.player) != invalid){
			
			fatalColision = true;
		}
		
		
		return fatalColision;
	}
	
	
	private boolean checkWaterColision(){
		
		if(this.player.getDepending()){
			
			return false;
		}
		
		if(this.agua.collided(this.player)){
			
			return true;
		}
		
		return false;
		
	}
	
	
	private void resetGameStateToBeginning(){
	
		
		
		
	   this.player.resetPosition();
		
		
		// RESETAR O TIMER
		
	}
	
	private boolean checkForLifes(){
		
		System.out.println(this.player.getLifes());
		
		if(this.player.getLifes()>0){
			
			this.player.decreaseLife();
			//JOptionPane.showMessageDialog(null, "Perdeu uma vida, voltando ao inicio..");
			
			//this.gameState = GameState.COLIDADE;
			// UPDATE NUMERO DE VIDAS NA TELA
			
			this.resetGameStateToBeginning();
			
			return true;
		
		}else{
			
			return false;
		}
	}
	
	private void checkAndSolveColisions(){
		
		
		
		if(this.checkCenarioMobileElementsColision() || this.checkWaterColision()){
			
			if(!checkForLifes()){
				
				this.gameState = GameState.GAME_OVER;
			}
			
			// check for lifes and set game over case necessary
		}
		
		/** Checando colis�o com checkpoints **/
		
		if(this.checkPointsModule.checkColisionWithStaticCenarioElement(player)){
			
			System.out.println("Colidiu com checkpoint");
		}
		
		
	}
	
	
	
	
}

