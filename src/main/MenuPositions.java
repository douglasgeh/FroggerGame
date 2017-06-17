package main;

public enum MenuPositions {
	
	NOVO_JOGO(0), RANKING(1), SAIR(2);

    private final int id;
    MenuPositions(int id) { this.id = id; }
    public int getValue() { return id; }
}
