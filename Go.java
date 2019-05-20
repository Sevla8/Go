import java.util.ArrayList;
import java.util.LinkedList;

public class Go {
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
	private LinkedList<Player[][]> historic;

	public Go(Parameter parameter) {
		this.goban = new Player[parameter.getSize()][parameter.getSize()];
		for (int i = 0; i < parameter.getSize(); i += 1) {
			for (int j = 0; j < parameter.getSize(); j += 1)
				this.goban[i][j] = null;
		}
		this.turn = Player.BLACK;
		this.parameter = parameter;
		this.blackPrisoner = 0;
		this.whitePrisoner = 0;
		this.whiteSkip = 0;
		this.blackSkip = 0;
		this.winner = null;
		this.blackScore = 0.;
		this.whiteScore = 7.5;
		this.historic = new LinkedList<Player[][]>();
		this.historic.add(this.goban);
		this.gameOver = false;
	}

	public void play(int x, int y) {
		if (this.correctMove(x, y) && !this.gameOver) {
			this.setStone(x, y);
			this.turnOver();
			this.makePrisoners();
			if (this.turn == Player.BLACK)
				this.blackSkip = 0;
			else 
				this.whiteSkip = 0;
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

	public boolean correctMove(int x, int y) {
		if (!inGoban(x, y))
			return false;
		if (this.goban[y][x] != null)
			return false;
		if (this.suicide(new Stone(this.turn, x, y)))
			return false;
		return true;
	}

	public boolean inGoban(int x, int y) {
		if (x >= 0 && x < this.parameter.getSize() && y >= 0 && y < this.parameter.getSize())
			return true;
		return false;
	}

	public void turnOver() {
		if (this.gameOver)
			System.out.println("this is the end");
		this.turn = this.turn.other();
	}

	public boolean suicide(Stone stone) {
		ArrayList<Stone> group = this.getGroup(stone);
		int liberty = this.getGroupLiberty(group);
		return liberty == 0 ? true : false;
	}

	public Player getStatus(int x, int y) {
		if (this.goban[y][x] == null)
			return null;
		if (this.goban[y][x] == Player.WHITE)
			return Player.WHITE;
		return Player.BLACK;
	}

	public void setStone(int x, int y) {
		this.goban[y][x] = this.turn;
	}

	public int getLiberty(Stone stone) {
		int x = stone.getX();
		int y = stone.getY();
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

	public int getGroupLiberty(ArrayList<Stone> group) {
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

	public ArrayList<Stone> getGroup(Stone stone) {
		ArrayList<Stone> group = new ArrayList<Stone>();
		group.add(stone);
		group = this.getGroupRec(group, stone.getPlayer());
		return group;
	}

	public ArrayList<Stone> getGroupRec(ArrayList<Stone> group, Player Player) {
		int x = group.get(group.size()-1).getX();
		int y = group.get(group.size()-1).getY();
		if (inGoban(x-1, y)) {
			if (this.goban[y][x-1] == Player && !group.contains(new Stone(this.goban[y][x-1], x-1, y))) {
				group.add(new Stone(this.goban[y][x-1], x-1, y));
				getGroupRec(group, Player);
			}
		}
		if (inGoban(x+1, y)) {
			if (this.goban[y][x+1] == Player && !group.contains(new Stone(this.goban[y][x+1], x+1, y))) {
				group.add(new Stone(this.goban[y][x+1], x+1, y));
				getGroupRec(group, Player);
			}
		}
		if (inGoban(x, y+1)) {
			if (this.goban[y+1][x] == Player && !group.contains(new Stone(this.goban[y+1][x], x, y+1))) {
				group.add(new Stone(this.goban[y+1][x], x, y+1));
				getGroupRec(group, Player);
			}
		}
		if (inGoban(x, y-1)) {
			if (this.goban[y-1][x] == Player && !group.contains(new Stone(this.goban[y-1][x], x, y-1))) {
				group.add(new Stone(this.goban[y-1][x], x, y-1));
				getGroupRec(group, Player);
			}
		}
		return group;
	}

	public boolean groupExists(Stone stone) {
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

	public void makePrisoners() {
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] != null) {
					ArrayList<Stone> group = this.getGroup(new Stone(this.goban[i][j], j, i));
					if (this.getGroupLiberty(group) == 0)
						this.updatePrisoners(group);
				}	
			}
		}
	}

	public void updatePrisoners(ArrayList<Stone> group) {
		for (Stone stone : group) {
			if (stone.getPlayer() == Player.BLACK)
				this.blackPrisoner += 1;
			else 
				this.whitePrisoner += 1;
			this.goban[stone.getY()][stone.getX()] = null;
		}
	}

	public void giveUp() {
		this.winner = this.turn.other();
		this.gameOver = true;
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
		string += "white : "+this.whitePrisoner+"\n\t";
		return string;
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
	public LinkedList<Player[][]> getHistoric() {
		return this.historic;
	}
}