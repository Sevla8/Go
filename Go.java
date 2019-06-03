import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class Go {
	private int index;
	private Player turn;
	private Player winner;
	private int blackSkip;
	private int whiteSkip;
	private boolean gameOver;
	private Player[][] goban;
	private double blackScore;
	private double whiteScore;
	private int blackPrisoner;
	private int whitePrisoner;
	private Parameter parameter;
	private LinkedList<Historic> historic;

	public Go(Parameter parameter) {
		this.parameter = parameter;
		this.goban = new Player[parameter.getSize()][parameter.getSize()];
		for (int i = 0; i < parameter.getSize(); i += 1) {
			for (int j = 0; j < parameter.getSize(); j += 1)
				this.goban[i][j] = null;
		}
		if (this.parameter.getSize() == 19) {
			if (this.parameter.getKomi() == 2) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 3) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 4) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 5) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 6) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[15][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 7) {
				this.goban[15][3] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[15][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 8) {
				this.goban[3][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[9][3] = Player.BLACK;
				this.goban[9][15] = Player.BLACK;
				this.goban[15][3] = Player.BLACK;
				this.goban[15][9] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 9) {
				this.goban[3][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[3][15] = Player.BLACK;
				this.goban[9][3] = Player.BLACK;
				this.goban[9][15] = Player.BLACK;
				this.goban[15][3] = Player.BLACK;
				this.goban[15][9] = Player.BLACK;
				this.goban[15][15] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
			}
		}
		else if (this.parameter.getSize() == 13) {
			if (this.parameter.getKomi() == 2) {
				this.goban[9][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 3) {
				this.goban[9][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[6][6] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 4) {
				this.goban[9][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 5) {
				this.goban[9][3] = Player.BLACK;
				this.goban[3][9] = Player.BLACK;
				this.goban[3][3] = Player.BLACK;
				this.goban[9][9] = Player.BLACK;
				this.goban[6][6] = Player.BLACK;
			}
		}
		else {
			if (this.parameter.getKomi() == 2) {
				this.goban[6][2] = Player.BLACK;
				this.goban[2][6] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 3) {
				this.goban[6][2] = Player.BLACK;
				this.goban[2][6] = Player.BLACK;
				this.goban[4][4] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 4) {
				this.goban[6][2] = Player.BLACK;
				this.goban[2][6] = Player.BLACK;
				this.goban[2][2] = Player.BLACK;
				this.goban[6][6] = Player.BLACK;
			}
			else if (this.parameter.getKomi() == 5) {
				this.goban[6][2] = Player.BLACK;
				this.goban[2][6] = Player.BLACK;
				this.goban[2][2] = Player.BLACK;
				this.goban[6][6] = Player.BLACK;
				this.goban[4][4] = Player.BLACK;
			}
		}
		if (this.parameter.getKomi() == 0 || this.parameter.getKomi() == 1)
			this.turn = Player.BLACK;
		else 
			this.turn = Player.WHITE;
		this.blackPrisoner = 0;
		this.whitePrisoner = 0;
		this.whiteSkip = 0;
		this.blackSkip = 0;
		this.winner = null;
		this.blackScore = 0.;
		if (this.parameter.getKomi() == 0)
			this.whiteScore = 7.5;
		else 
			this.whiteScore = 0.;
		Historic historic = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner);
		this.historic = new LinkedList<Historic>();
		this.historic.add(historic);
		this.index = 0;
		this.gameOver = false;
	}

	public void play(int x, int y) {
		if (this.correctMove(x, y) && !this.gameOver) {
			this.cutHistoric();
			this.setStone(x, y);
			this.makePrisoners();
			this.turnOver();
			if (this.turn == Player.BLACK)
				this.blackSkip = 0;
			else 
				this.whiteSkip = 0;
			this.addHistoric();
		}
	}

	public void skip() {
		if (this.turn == Player.BLACK) {
			this.blackSkip = 1;
			if (this.whiteSkip == 1)
				this.gameOver = true;
		}
		else {
			this.whiteSkip = 1;
			if (this.blackSkip == 1)
				this.gameOver = true;
		}
		this.turnOver();
	}

	public void giveUp() {
		this.winner = this.turn.other();
		this.gameOver = true;
	}

	public void undo() {
		if (this.index > 0) {
			this.index -= 1;

			this.goban = new Player[this.parameter.getSize()][this.parameter.getSize()];
			for (int i = 0; i < this.parameter.getSize(); i += 1) {
				for (int j = 0; j < this.parameter.getSize(); j += 1) {
					if (this.historic.get(this.index).getGoban()[i][j] == Player.BLACK) 
						this.goban[i][j] = Player.BLACK;
					else if (this.historic.get(this.index).getGoban()[i][j] == Player.WHITE) 
						this.goban[i][j] = Player.WHITE;
					else 
						this.goban[i][j] = null;
				}
			}
			this.blackPrisoner = this.historic.get(this.index).getBlackPrisoner();
			this.whitePrisoner = this.historic.get(this.index).getWhitePrisoner();
			this.turnOver();
		}
	}

	public void redo() {
		if (this.index < this.historic.size()-1) {
			this.index += 1;
			
			this.goban = new Player[this.parameter.getSize()][this.parameter.getSize()];
			for (int i = 0; i < this.parameter.getSize(); i += 1) {
				for (int j = 0; j < this.parameter.getSize(); j += 1) {
					if (this.historic.get(this.index).getGoban()[i][j] == Player.BLACK) 
						this.goban[i][j] = Player.BLACK;
					else if (this.historic.get(this.index).getGoban()[i][j] == Player.WHITE) 
						this.goban[i][j] = Player.WHITE;
					else 
						this.goban[i][j] = null;
				}
			}
			this.blackPrisoner = this.historic.get(this.index).getBlackPrisoner();
			this.whitePrisoner = this.historic.get(this.index).getWhitePrisoner();
			this.turnOver();
		}
	}

	private boolean correctMove(int x, int y) {
		if (!inGoban(x, y))
			return false;
		if (this.goban[y][x] != null)
			return false;
		if (this.ko(x, y))
			return false;
		if (this.suicide(new Stone(this.turn, x, y)))
			return false;
		if (this.time3())
			return false; 
		return true;
	}

	private boolean ko(int x, int y) {
		if (this.index > 3) {
			Player[][] tmpGoban = this.cloneGoban();
			int tmpBlackPrisoner = this.blackPrisoner;
			int tmpWhitePrisoner = this.whitePrisoner;
			this.setStone(x, y);
			this.makePrisoners();
			Historic historic = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner);
			if (this.historic.get(this.index-1).equals(historic)) {
				this.goban = tmpGoban;
				this.blackPrisoner = tmpBlackPrisoner;
				this.whitePrisoner = tmpWhitePrisoner;
				return true;
			}
			this.goban = tmpGoban;
			this.blackPrisoner = tmpBlackPrisoner;
			this.whitePrisoner = tmpWhitePrisoner;
			return false;
		}
		return false;
	}

	private boolean time3() {
		if (this.index > 3) {
			Historic current = new Historic(this.goban);
			int time = 0;
			for (Historic historic : this.historic) {
				if (historic.equals(current))
					time += 1;
			}
			if (time == 3) {
				this.gameOver = true;
				return true;
			}
		}
		return false;
	}

	private boolean inGoban(int x, int y) {
		if (x >= 0 && x < this.parameter.getSize() && y >= 0 && y < this.parameter.getSize())
			return true;
		return false;
	}

	private void turnOver() {
		this.turn = this.turn.other();
	}

	private boolean suicide(Stone stone) {
		Player[][] tmpGoban = this.cloneGoban();
		int tmpBlackPrisoner = this.blackPrisoner;
		int tmpWhitePrisoner = this.whitePrisoner;
		this.setStone(stone.getX(), stone.getY());
		if (this.makePrisoners()) {
			this.goban = tmpGoban;
			this.blackPrisoner = tmpBlackPrisoner;
			this.whitePrisoner = tmpWhitePrisoner;
			return false;
		}
		ArrayList<Stone> group = this.getGroup(stone);
		int liberty = this.getGroupLiberty(group);
		this.removeStone(stone.getX(), stone.getY());
		return liberty == 0 ? true : false;
	}

	private Player getStatus(int x, int y) {
		if (this.goban[y][x] == null)
			return null;
		if (this.goban[y][x] == Player.WHITE)
			return Player.WHITE;
		return Player.BLACK;
	}

	private void setStone(int x, int y) {
		this.goban[y][x] = this.turn;
	}

	private void removeStone(int x, int y) {
		this.goban[y][x] = null;
	}

	private int getLiberty(int x, int y) {
		int liberty = 0;
		if (inGoban(x-1, y))
			liberty += this.goban[y][x-1] == null ? 1 : 0;
		if (inGoban(x+1, y))
			liberty += this.goban[y][x+1] == null ? 1 : 0;
		if (inGoban(x, y-1))
			liberty += this.goban[y-1][x] == null ? 1 : 0;
		if (inGoban(x, y+1))
			liberty += this.goban[y+1][x] == null ? 1 : 0;
		return liberty;
	}

	private boolean groupExists(Stone stone) {
		int x = stone.getX();
		int y = stone.getY();
		boolean bool = false;
		if (inGoban(x, y+1))
			bool |= this.goban[y+1][x] == stone.getPlayer() ? true : false;
		if (inGoban(x, y-1))
			bool |= this.goban[y-1][x] == stone.getPlayer() ? true : false;
		if (inGoban(x+1, y))
			bool |= this.goban[y][x+1] == stone.getPlayer() ? true : false;
		if (inGoban(x-1, y))
			bool |= this.goban[y][x-1] == stone.getPlayer() ? true : false;
		return bool;
	}

	private ArrayList<Stone> getGroup(Stone stone) {
		ArrayList<Stone> group = new ArrayList<Stone>();
		group.add(stone);
		this.getGroupRec(group);
		return group;
	}

	private void getGroupRec(ArrayList<Stone> group) {
		Player player = group.get(0).getPlayer();
		int x = group.get(group.size()-1).getX();
		int y = group.get(group.size()-1).getY();
		if (inGoban(x-1, y)) {
			if (this.goban[y][x-1] == player && !group.contains(new Stone(player, x-1, y))) {
				group.add(new Stone(player, x-1, y));
				this.getGroupRec(group);
			}
		}
		if (inGoban(x+1, y)) {
			if (this.goban[y][x+1] == player && !group.contains(new Stone(player, x+1, y))) {
				group.add(new Stone(player, x+1, y));
				this.getGroupRec(group);
			}
		}
		if (inGoban(x, y+1)) {
			if (this.goban[y+1][x] == player && !group.contains(new Stone(player, x, y+1))) {
				group.add(new Stone(player, x, y+1));
				this.getGroupRec(group);
			}
		}
		if (inGoban(x, y-1)) {
			if (this.goban[y-1][x] == player && !group.contains(new Stone(player, x, y-1))) {
				group.add(new Stone(player, x, y-1));
				this.getGroupRec(group);
			}
		}
	}

	private int getGroupLiberty(ArrayList<Stone> group) {
		ArrayList<Stone> groupLiberty = new ArrayList<Stone>();
		for (Stone stone : group) {
			int x = stone.getX();
			int y = stone.getY();
			if (inGoban(x-1, y)) {
				if (this.goban[y][x-1] == null && !groupLiberty.contains(new Stone(null, x-1, y)))
					groupLiberty.add(new Stone(null, x-1, y));
			}
			if (inGoban(x+1, y)) {
				if (this.goban[y][x+1] == null && !groupLiberty.contains(new Stone(null, x+1, y)))
					groupLiberty.add(new Stone(null, x+1, y));
			}
			if (inGoban(x, y-1)) {
				if (this.goban[y-1][x] == null && !groupLiberty.contains(new Stone(null, x, y-1)))
					groupLiberty.add(new Stone(null, x, y-1));
			}
			if (inGoban(x, y+1)) {
				if (this.goban[y+1][x] == null && !groupLiberty.contains(new Stone(null, x, y+1)))
					groupLiberty.add(new Stone(null, x, y+1));
			}
		}
		return groupLiberty.size();
	}

	private boolean makePrisoners() {
		boolean bool = false;
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == this.turn.other()) {
					ArrayList<Stone> group = this.getGroup(new Stone(this.goban[i][j], j, i));
					if (this.getGroupLiberty(group) == 0) {
						bool = true;
						this.updatePrisoners(group);
					}
				}	
			}
		}
		return bool;
	}

	private void updatePrisoners(ArrayList<Stone> group) {
		for (Stone stone : group) {
			if (stone.getPlayer() == Player.BLACK)
				this.blackPrisoner += 1;
			else 
				this.whitePrisoner += 1;
			this.goban[stone.getY()][stone.getX()] = null;
		}
	}

	private void addHistoric() {
		Historic historic = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner);
		this.historic.add(historic);
		this.index += 1;
	}

	private void cutHistoric() {
		while (this.index != this.historic.size()-1) {
			this.historic.removeLast();
		}
	}

	private Player[][] cloneGoban() {
		Player[][] goban = new Player[this.parameter.getSize()][this.parameter.getSize()];
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == Player.BLACK) 
					goban[i][j] = Player.BLACK;
				else if (this.goban[i][j] == Player.WHITE) 
					goban[i][j] = Player.WHITE;
				else 
					goban[i][j] = null;
			}
		}
		return goban;
	}

	@Override
	public String toString() {
		String string = new String();
		string = "goban : \n\t";
		for (Player son[] : this.goban) {
			for (Player cell : son) {
				if (cell == null)
					string += ". ";
				else if (cell == Player.WHITE)
					string += "0 ";
				else if (cell == Player.BLACK)
					string += "1 ";
			}
			string += "\n\t";
		}
		string += "\nturn : \n\t" + this.getTurn().toString();
		string += "\n\nparameter : \n\t" + this.parameter.toString();
		string += "\nprisoner : \n\t";
		string += "black : "+this.blackPrisoner+"\n\t";
		string += "white : "+this.whitePrisoner+"\n";
		string += "historic : \n";
		for (Historic historic : this.historic) {
			string += historic.toString();
		}
		return string;
	}

	public int getIndex() {
		return this.index;
	}

	public Player getTurn() {
		return this.turn;
	}
	public Player getWinner() {
		return this.winner;
	}
	public int getBlackSkip() {
		return this.blackSkip;
	}
	public int getWhiteSkip() {
		return this.whiteSkip;
	}
	public boolean getGameOver() {
		return this.gameOver;
	}
	public Player[][] getGoban() {
		return this.goban;
	}
	public double getBlackScore() {
		return this.blackScore;
	}
	public double getWhiteScore() {
		return this.whiteScore;
	}
	public int getBlackPrisoner() {
		return this.blackPrisoner;
	}
	public int getWhitePrisoner() {
		return this.whitePrisoner;
	}
	public Parameter getParameter() {
		return this.parameter;
	}
	public LinkedList<Historic> getHistoric() {
		return this.historic;
	}
}