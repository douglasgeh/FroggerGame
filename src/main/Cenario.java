package main;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import jplay.GameImage;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Cenario {

	private Window janela;
	private Scene cena;
	private Jogador player;
	//private ScoreManager score;
	
	private GameObject agua;
	
	private TroncosModule troncosModule;
	private CheckPointsModule checkPointsModule;
	private AutomovelModule automovelModule;
	private TartarugaModule tartarugaModule;
	private int velocityChange;

	private GameState gameState;
	
	private TimerManager timer;
	
	private UnsafeZonesManager unsafeZones;
	
	private boolean waterColision;
	
	final private int invalid = -1;
	
	public Cenario(Window janela, int velTax){
		
		this.janela = janela;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario.scn"));
		
		this.player = new Jogador(300,750);
		
		//this.score = new ScoreManager();
		this.velocityChange = velTax;
		this.checkPointsModule = new CheckPointsModule();
		this.troncosModule = new TroncosModule(this.velocityChange);
		this.automovelModule = new AutomovelModule(this.velocityChange);
		this.tartarugaModule = new TartarugaModule(this.velocityChange);
		
		this.timer = new TimerManager(50);
		
		this.unsafeZones = new UnsafeZonesManager();
		
		this.agua = new GameObject();
		this.agua.x = 0;
		this.agua.y = 80;
		
		this.agua.width = this.janela.getWidth();
		this.agua.height = 240;
		
		this.waterColision = false;
		
		this.gameState = GameState.RUNING;
	
		run();
	}
	
	
	private void run(){
		
		
		while(this.gameState != GameState.EXIT){

			this.cena.draw();
			
			while(this.gameState == GameState.RUNING){
				
				this.checkAndSolveColisions();
				this.drawCenarioElements();
				//this.janela.drawText(Integer.toString(score.getCurrentScore()), 550, 750, Color.BLUE);
				this.solveTimerMethods();
				
				
				janela.update();
				
				
			}
			
			if(this.gameState == GameState.GAME_OVER){
				
				GameImage gameOverImage = new GameImage(URL.sprite("gameOverImg.png"));
				
				gameOverImage.draw();
				janela.update();
				
				if(this.janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
					
					JOptionPane.showInputDialog("Your score was: "+this.player.getScoreManager().getCurrentScore()+"! Please type your name..");
					
					this.gameState = GameState.EXIT;
					System.out.println(this.player.getScoreManager().getCurrentScore());
					
				}
			}
			else if(this.gameState == GameState.WINNER){
				
				GameImage youWonImg = new GameImage(URL.sprite("youWonImg.png"));
				
				youWonImg.draw();
				janela.update();
				
				if(this.janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
					
					this.gameState = GameState.RUNING;
					//this.player.resetLifes();
					
					this.player.resetSettingsToNewLevel();
					this.checkPointsModule.resetCheckPoints();
					this.troncosModule.IncreaseVelocity(this.velocityChange+1);
					this.tartarugaModule.IncreaseVelocity(this.velocityChange+1);
					this.automovelModule.IncreaseVelocity(this.velocityChange+1);
					
				}
				
				
			}
			
			
		}
		
		
		
		
	}
	

	public void drawCenarioElements(){
		
		this.cena.draw();
		
		this.troncosModule.moveAndDrawMobileElements(this.janela);
		
		this.automovelModule.moveAndDrawMobileElements(this.janela);
		
		this.tartarugaModule.moveAndDrawMobileElements(this.janela);
		
		this.checkPointsModule.drawCheckedFroggsIfExists();
		
		
		
		this.player.draw();
		this.player.moveAccordingToKeyboard(this.janela);
		
	}
	
	private void solveTimerMethods(){
		
		if(this.timer.checkEndGameIfTimeWasReached()){
			
			this.player.decreaseLife();
			if(!this.checkForLifes()){
				
				this.gameState = GameState.GAME_OVER;
			}
			
		}
		else{

			this.timer.printTimeToScreen(this.janela);
			
		}
		
	}
	
	private boolean checkCenarioMobileElementsColision(){
		
		boolean fatalColision = false;
		
		
		
		/** Checando colisao com carros, troncos ou tartarugas **/
		
		int colisionElementIndex = this.troncosModule.checkColisionWithMobileCenarioElement(this.player);
		
		if(colisionElementIndex!=invalid){
	
			player.moveAccordingToCenarioElement(this.troncosModule.getTroncos().get(colisionElementIndex).getVelocity());
			
			this.player.setDepending(true);
			
			System.out.println("Tronco depending: "+this.player.getDepending());
			
			fatalColision = false;
		}
		else{
			
			this.player.setDepending(false);
		}
		
		if(!this.player.getDepending()){
			

			colisionElementIndex = this.tartarugaModule.checkColisionWithMobileCenarioElement(this.player);
			
			if(colisionElementIndex!=invalid){
				
				player.moveAccordingToCenarioElement(this.tartarugaModule.getTartarugas().get(colisionElementIndex).getVelocity());
				
				this.player.setDepending(true);
				
				System.out.println("Tartaruga depending: "+this.player.getDepending());
				
				fatalColision = false;
				
			}else{
				
				this.player.setDepending(false);
			}
			
			
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
		else if(this.agua.collided(this.player)){
			
			System.out.println("Colisao com agua!");
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
			
			this.resetGameStateToBeginning();
			
			return true;
		
		}else{
			
			return false;
		}
	}
	
	private void checkAndSolveColisions(){
		
		
		if(this.unsafeZones.checkColisions(this.player)){
			
			this.gameState = GameState.GAME_OVER;
		}
		
		if(this.checkCenarioMobileElementsColision() || this.checkWaterColision()){
			
			if(!checkForLifes()){
				
				this.gameState = GameState.GAME_OVER;
			}


		}
		
		/** Checando colis�o com checkpoints **/
		
		if(this.checkPointsModule.checkColisionWithStaticCenarioElement(player)){
			
			this.player.resetPosition();
			
			this.timer.resetTimer();
			
			if(this.checkPointsModule.checkWin()){
				
				this.gameState = GameState.WINNER;
			}
			
			System.out.println("Colidiu com checkpoint");
		}
		
		
	}
	
	
	
	
}

