package main;

public class ScoreManager {
	private int scoreUnit;
	private int currentScore;
	private int scoreMultiplier;
	
	public ScoreManager(){
		this.scoreUnit = 1;
		this.currentScore = 0;
		this.scoreMultiplier = 1;
	}
	
	public void UpdateScoreUnit(){
		this.scoreUnit *= this.scoreMultiplier;
	}
	
	public void IncreaseScoreMultiplier(){
		this.scoreMultiplier += 1;
	}
	
	public void IncreaseCurrentScore(){
		this.currentScore += this.scoreUnit;
	}
	
	public void DecreaseCurrentScore(){
		this.currentScore -= this.scoreUnit;
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
}
