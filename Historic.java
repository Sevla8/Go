import java.util.LinkedList;

public class Historic {
	private Player[][] goban;
	private int blackPrisoner;
	private int whitePrisoner;

	public Historic(Player[][] goban, int blackPrisoner, int whitePrisoner) {
		this.goban = new Player[goban.length][goban.length];
		for (int i = 0; i < goban.length; i += 1) {
			for (int j = 0; j < goban.length; j += 1) {
				if (goban[i][j] == Player.BLACK)
					this.goban[i][j] = Player.BLACK;
				else if (goban[i][j] == Player.WHITE)
					this.goban[i][j] = Player.WHITE;
				else 
					this.goban[i][j] = null;
			}
		}
		this.blackPrisoner = blackPrisoner;
		this.whitePrisoner = whitePrisoner;
	}

	public Player[][] getGoban() {
		return this.goban;
	}
	public int getBlackPrisoner() {
		return this.blackPrisoner;
	}
	public int getWhitePrisoner() {
		return this.whitePrisoner;
	}
}
