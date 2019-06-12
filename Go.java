import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class Go {
	private int lastX = 0;
	private int lastY = 0;
	private int index = -1;
	private Player turn;
	private Player winner = null;
	private boolean gameOver = false;
	private Player[][] goban;
	private boolean blackSkip = false;
	private boolean whiteSkip = false;
	private double blackScore;
	private double whiteScore;
	private int blackPrisoner = 0;
	private int whitePrisoner = 0;
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
		this.blackScore = 0.;
		if (this.parameter.getKomi() == 0)
			this.whiteScore = 7.5;
		else 
			this.whiteScore = 0.;
		this.historic = new LinkedList<Historic>();
		this.addHistoric();
	}

	public void indication(int x, int y) {
		if (this.goban[this.lastY][this.lastX] == Player.BLACK_TMP || this.goban[this.lastY][this.lastX] == Player.WHITE_TMP) {
			if (this.gameOver) {
				if (this.goban[this.lastY][this.lastX] == Player.BLACK_TMP) {
					for (Stone stone : this.getGroup(new Stone(Player.BLACK_TMP, this.lastX, this.lastY)))
						this.goban[stone.getY()][stone.getX()] = Player.BLACK;
				}
				else if (this.goban[this.lastY][this.lastX] == Player.WHITE_TMP) {
					for (Stone stone : this.getGroup(new Stone(Player.WHITE_TMP, this.lastX, this.lastY)))
						this.goban[stone.getY()][stone.getX()] = Player.WHITE;
				}
			}
			else
				this.goban[this.lastY][this.lastX] = null;
		}
		if (correctMove(x, y) && !this.gameOver) {
			if (this.turn == Player.BLACK)
				this.goban[y][x] = Player.BLACK_TMP;
			else 
				this.goban[y][x] = Player.WHITE_TMP;
			this.lastX = x;
			this.lastY = y;
		}
		else if (inGoban(x, y) && (this.goban[y][x] == Player.BLACK || this.goban[y][x] == Player.WHITE) && this.gameOver) {
			if (this.goban[y][x] == Player.BLACK) {
				for (Stone stone : this.getGroup(new Stone(Player.BLACK, x, y))) {
					this.goban[stone.getY()][stone.getX()] = Player.BLACK_TMP;				
				}
			}
			else if (this.goban[y][x] == Player.WHITE) {
				for (Stone stone : this.getGroup(new Stone(Player.WHITE, x, y))) {
					this.goban[stone.getY()][stone.getX()] = Player.WHITE_TMP;
				}
			}
			this.lastX = x;
			this.lastY = y;
		}
	}

	public boolean control(int x, int y) {
		if (!this.gameOver)
			return this.play(x, y);
		else 
			return this.deadStone(x, y);
	}

	public void makeWinner() {
		this.makeScore();
		this.winner = this.blackScore > this.whiteScore ? Player.BLACK : (this.blackScore < this.whiteScore ? Player.WHITE : Player.GRAY);
	}

	public void skip() {
		this.cutHistoric();
		if (this.turn == Player.BLACK) {
			this.blackSkip = true;
			if (this.whiteSkip == true)
				this.makeGameOver();
		}
		else {
			this.whiteSkip = true;
			if (this.blackSkip == true)
				this.makeGameOver();
		}
		this.turnOver();
		this.addHistoric();
	}

	public void giveUp() {
		this.winner = this.turn.other();
		this.makeGameOver();
	}

	public void makeGameOver() {
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == Player.BLACK_TMP || this.goban[i][j] == Player.WHITE_TMP) 
					this.goban[i][j] = null;
			}
		}
		this.gameOver = true;
	}

	public void undo() {
		if (this.index > 0) {
			this.index -= 1;
			this.getHistoric(this.index);
			this.turnOver();
		}
	}

	public void redo() {
		if (this.index < this.historic.size()-1) {
			this.index += 1;
			this.getHistoric(this.index);
			this.turnOver();
		}
	}

	private void makeScore() {
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == Player.BLACK)
					this.blackScore += 1;
				else if (this.goban[i][j] == Player.WHITE)
					this.whiteScore += 1;
			}
		}
		ArrayList<Stone> chekedStone = new ArrayList<Stone>();
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == null && !chekedStone.contains(new Stone(null, j, i))) {
					ArrayList<Stone> group = this.getGroup(new Stone(this.goban[i][j], j, i));
					chekedStone.addAll(group);
					if (this.isTerritoryOf(group) == Player.BLACK)
						this.blackScore += group.size();
					else if (this.isTerritoryOf(group) == Player.WHITE)
						this.whiteScore += group.size();
				}
			}
		}
	}

	private boolean play(int x, int y) {
		if (this.correctMove(x, y) && !this.gameOver) {
			this.cutHistoric();
			this.setStone(x, y);
			this.makePrisoners();
			this.turnOver();
			if (this.turn == Player.BLACK)
				this.blackSkip = false;
			else 
				this.whiteSkip = false;
			this.addHistoric();
			return true;
		}
		return false;
	}

	private boolean deadStone(int x, int y) {
		if (inGoban(x, y) && (this.goban[y][x] == Player.BLACK || this.goban[y][x] == Player.WHITE || this.goban[y][x] == Player.BLACK_TMP || this.goban[y][x] == Player.WHITE_TMP)) {
			if (this.goban[y][x] == Player.BLACK || this.goban[y][x] == Player.BLACK_TMP)
				this.blackPrisoner += this.removeGroup(this.getGroup(new Stone(Player.BLACK_TMP, x, y)));
			else
				this.whitePrisoner += this.removeGroup(this.getGroup(new Stone(Player.WHITE_TMP, x, y)));
			this.addHistoric();
			return true;
		}
		return false;
	}

	private boolean correctMove(int x, int y) {
		if (!inGoban(x, y))
			return false;
		if (this.goban[y][x] == Player.BLACK || this.goban[y][x] == Player.WHITE)
			return false;
		if (this.ko(x, y))
			return false;
		if (this.suicide(new Stone(this.turn, x, y)))
			return false;
		if (this.time3(x, y)) {
			return false;
		}
		return true;
	}

	private Player isTerritoryOf(ArrayList<Stone> group) {
		int nbBlack = 0;
		int nbWhite = 0;
		for (Stone stone : group) {
			int x = stone.getX();
			int y = stone.getY();
			if (inGoban(x-1, y)) {
				if (this.goban[y][x-1] == Player.BLACK)
					nbBlack += 1;
				else if (this.goban[y][x-1] == Player.WHITE)
					nbWhite += 1;
			}
			if (inGoban(x+1, y)) {
				if (this.goban[y][x+1] == Player.BLACK)
					nbBlack += 1;
				else if (this.goban[y][x+1] == Player.WHITE)
					nbWhite += 1;
			}
			if (inGoban(x, y-1)) {
				if (this.goban[y-1][x] == Player.BLACK)
					nbBlack += 1;
				else if (this.goban[y-1][x] == Player.WHITE)
					nbWhite += 1;
			}
			if (inGoban(x, y+1)) {
				if (this.goban[y+1][x] == Player.BLACK)
					nbBlack += 1;
				else if (this.goban[y+1][x] == Player.WHITE)
					nbWhite += 1;
			}
		}
		if (nbBlack == 0)
			return Player.WHITE;
		if (nbWhite == 0)
			return Player.BLACK;
		return null;
	}

	private boolean ko(int x, int y) {
		if (this.index > 3) {
			boolean bool = false;
			Player[][] tmpGoban = this.cloneGoban();
			int tmpBlackPrisoner = this.blackPrisoner;
			int tmpWhitePrisoner = this.whitePrisoner;
			boolean tmpGameOver = this.gameOver;
			boolean tmpBlackSkip = this.blackSkip;
			boolean tmpWhiteSkip = this.whiteSkip;
			this.setStone(x, y);
			this.makePrisoners();
			Historic historic = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner, this.gameOver, this.blackSkip, this.whiteSkip);
			if (this.historic.get(this.index-1).equals(historic)) 
				bool = true;
			this.goban = tmpGoban;
			this.blackPrisoner = tmpBlackPrisoner;
			this.whitePrisoner = tmpWhitePrisoner;
			this.gameOver = tmpGameOver;
			this.blackSkip = tmpBlackSkip;
			this.whiteSkip = tmpWhiteSkip;
			return bool;
		}
		return false;
	}

	private boolean time3(int x, int y) {
		if (this.index > 3) {
			boolean bool = false;
			Player[][] tmpGoban = this.cloneGoban();
			int tmpBlackPrisoner = this.blackPrisoner;
			int tmpWhitePrisoner = this.whitePrisoner;
			boolean tmpGameOver = this.gameOver;
			boolean tmpBlackSkip = this.blackSkip;
			boolean tmpWhiteSkip = this.whiteSkip;
			this.setStone(x, y);
			this.makePrisoners();
			Historic current = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner, this.gameOver, this.blackSkip, this.whiteSkip);
			int time = 0;
			for (int i = 0; i < this.index; i += 1) {
				if (historic.get(i).equals(current))
					time += 1;
			}
			if (time == 2)
				bool = true;
			this.goban = tmpGoban;
			this.blackPrisoner = tmpBlackPrisoner;
			this.whitePrisoner = tmpWhitePrisoner;
			this.gameOver = tmpGameOver;
			this.blackSkip = tmpBlackSkip;
			this.whiteSkip = tmpWhiteSkip;
			return bool;
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
		boolean tmpGameOver = this.gameOver;
		boolean tmpBlackSkip = this.blackSkip;
		boolean tmpWhiteSkip = this.whiteSkip;
		this.setStone(stone.getX(), stone.getY());
		if (this.makePrisoners()) {
			this.goban = tmpGoban;
			this.blackPrisoner = tmpBlackPrisoner;
			this.whitePrisoner = tmpWhitePrisoner;
			this.gameOver = tmpGameOver;
			this.blackSkip = tmpBlackSkip;
			this.whiteSkip = tmpWhiteSkip;
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
		if (this.goban[y][x] == Player.WHITE_TMP)
			return Player.WHITE_TMP;
		if (this.goban[y][x] == Player.BLACK)
			return Player.BLACK;
		return Player.BLACK_TMP;
	}

	private void setStone(int x, int y) {
		this.goban[y][x] = this.turn;
	}

	private void removeStone(int x, int y) {
		this.goban[y][x] = null;
	}

	private int removeGroup(ArrayList<Stone> group) {
		int count = 0;
		for (Stone stone : group) {
			this.removeStone(stone.getX(), stone.getY());
			count += 1;
		}
		return count;
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
		ArrayList<Stone> chekedStone = new ArrayList<Stone>();
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] == this.turn.other() && !chekedStone.contains(new Stone(this.turn.other(), j, i))) {
					ArrayList<Stone> group = this.getGroup(new Stone(this.goban[i][j], j, i));
					chekedStone.addAll(group);
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
		Historic historic = new Historic(this.goban, this.blackPrisoner, this.whitePrisoner, this.gameOver, this.blackSkip, this.whiteSkip);
		this.historic.add(historic);
		this.index += 1;
	}

	private void getHistoric(int index) {
		this.goban = new Player[this.parameter.getSize()][this.parameter.getSize()];
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.historic.get(index).getGoban()[i][j] == Player.BLACK) 
					this.goban[i][j] = Player.BLACK;
				else if (this.historic.get(index).getGoban()[i][j] == Player.WHITE) 
					this.goban[i][j] = Player.WHITE;
				else 
					this.goban[i][j] = null;
			}
		}
		this.blackPrisoner = this.historic.get(index).getBlackPrisoner();
		this.whitePrisoner = this.historic.get(index).getWhitePrisoner();
		this.gameOver = this.historic.get(index).getGameOver();
		this.blackSkip = this.historic.get(index).getBlackSkip();
		this.whiteSkip = this.historic.get(index).getWhiteSkip();
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
	public boolean getBlackSkip() {
		return this.blackSkip;
	}
	public boolean getWhiteSkip() {
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