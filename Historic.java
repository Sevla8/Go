import java.util.LinkedList;

public class Historic {
	private Player[][] goban;
	private boolean gameOver;
	private int blackPrisoner;
	private int whitePrisoner;
	private boolean blackSkip;
	private boolean whiteSkip;

	public Historic(Player[][] goban, int blackPrisoner, int whitePrisoner, boolean gameOver, boolean blackSkip, boolean whiteSkip) {
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
		this.gameOver = gameOver;
		this.blackSkip = blackSkip;
		this.whiteSkip = whiteSkip;
	}

	public Historic(Player[][] goban) {
		this(goban, 0, 0, false, false, false);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Historic historic = (Historic) object;
		if (this.gameOver || historic.getGameOver() || 
			this.blackSkip || historic.getBlackSkip() ||
			this.whiteSkip || historic.getWhiteSkip())
			return false;
		for (int i = 0; i < this.goban.length; i += 1) {
			for (int j = 0; j < this.goban.length; j += 1) {
				if (this.goban[i][j] != historic.getGoban()[i][j])
					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String string = new String("");
		string += "goban : \n";
		for (int i = 0; i < this.goban.length; i += 1) {
			for (int j = 0; j < this.goban.length; j += 1) {
				string += this.goban[i][j]+" ";
			}
			string += "\n";
		}
		string += "black prisoner : "+this.blackPrisoner+"\n";
		string += "white prisoner : "+this.whitePrisoner+"\n";
		string += "game over : "+this.gameOver+"\n";
		string += "\n";
		return string;
	}

	public Player[][] getGoban() {
		return this.goban;
	}
	public boolean getGameOver() {
		return this.gameOver;
	}
	public int getBlackPrisoner() {
		return this.blackPrisoner;
	}
	public int getWhitePrisoner() {
		return this.whitePrisoner;
	}
	public boolean getBlackSkip() {
		return this.blackSkip;
	}
	public boolean getWhiteSkip() {
		return this.whiteSkip;
	}
}
