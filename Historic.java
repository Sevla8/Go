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

	public Historic(Player[][] goban) {
		this(goban, 0, 0);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Historic historic = (Historic) object;
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
		string += "\n";
		return string;
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
