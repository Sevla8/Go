import java.util.ArrayList;

public class Go {
	private Color[][] goban;
	private Color turn;
	private Parameter parameter; // Exception if size != 19 | 13 | 9 !!!
	private ArrayList<Color> prisoner;

	public Go(Parameter parameter) {
		this.goban = new Color[parameter.getSize()][parameter.getSize()];
		for (Color son[] : this.goban) {
			for (Color cell : son)
				cell = null;
		}
		this.turn = Color.BLACK;
		this.parameter = parameter;
		this.prisoner = new ArrayList<Color>();
	}

	public boolean inGoban(int x, int y) {
		if (x >= 0 && x < this.parameter.getSize() && y >= 0 && y < this.parameter.getSize())
			return true;
		return false;
	}

	public void turnOver() {
		this.turn = this.turn.other();
	}

	public boolean suicide(Stone stone) {
		ArrayList<Stone> group = this.getGroup(stone);
		int liberty = this.getGroupLiberty(group);
		return liberty == 0 ? true : false;
	}

	public Color getStatus(int x, int y) {
		if (this.goban[y][x] == null)
			return null;
		if (this.goban[y][x] == Color.WHITE)
			return Color.WHITE;
		return Color.BLACK;
	}

	public void setStone(Stone stone) {
		this.goban[stone.getY()][stone.getX()] = stone.getColor();
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
		group = this.getGroupRec(group, stone.getColor());
		return group;
	}

	public ArrayList<Stone> getGroupRec(ArrayList<Stone> group, Color color) {
		int x = group.get(group.size()-1).getX();
		int y = group.get(group.size()-1).getY();
		if (inGoban(x-1, y)) {
			if (this.goban[y][x-1] == color && !group.contains(new Stone(this.goban[y][x-1], x-1, y))) {
				group.add(new Stone(this.goban[y][x-1], x-1, y));
				getGroupRec(group, color);
			}
		}
		if (inGoban(x+1, y)) {
			if (this.goban[y][x+1] == color && !group.contains(new Stone(this.goban[y][x+1], x+1, y))) {
				group.add(new Stone(this.goban[y][x+1], x+1, y));
				getGroupRec(group, color);
			}
		}
		if (inGoban(x, y+1)) {
			if (this.goban[y+1][x] == color && !group.contains(new Stone(this.goban[y+1][x], x, y+1))) {
				group.add(new Stone(this.goban[y+1][x], x, y+1));
				getGroupRec(group, color);
			}
		}
		if (inGoban(x, y-1)) {
			if (this.goban[y-1][x] == color && !group.contains(new Stone(this.goban[y-1][x], x, y-1))) {
				group.add(new Stone(this.goban[y-1][x], x, y-1));
				getGroupRec(group, color);
			}
		}
		return group;
	}

	public boolean groupExists(Stone stone) {
		int x = stone.getX();
		int y = stone.getY();
		boolean bool = false;
		if (inGoban(x, y+1))
			bool |= this.goban[y+1][x] == stone.getColor() ? true : false;
		if (inGoban(x, y-1))
			bool |= this.goban[y-1][x] == stone.getColor() ? true : false;
		if (inGoban(x+1, y))
			bool |= this.goban[y][x+1] == stone.getColor() ? true : false;
		if (inGoban(x-1, y))
			bool |= this.goban[y][x-1] == stone.getColor() ? true : false;
		return bool;
	}

	public void makePrisoners() {
		for (int i = 0; i < this.parameter.getSize(); i += 1) {
			for (int j = 0; j < this.parameter.getSize(); j += 1) {
				if (this.goban[i][j] != null) {
					ArrayList<Stone> group = this.getGroup(new Stone(this.goban[i][j], j, i));
					if (this.getGroupLiberty(group) == 0)
						this.setPrisoners(group);
				}	
			}
		}
	}

	public void setPrisoners(ArrayList<Stone> group) {
		for (Stone stone : group) {
			this.prisoner.add(stone.getColor());
			this.goban[stone.getY()][stone.getX()] = null;
		}
	}

	@Override
	public String toString() {
		String string = new String();
		string = "goban : \n\t";
		for (Color son[] : this.goban) {
			for (Color cell : son) {
				if (cell == null)
					string += ". ";
				else if (cell == Color.WHITE)
					string += "0 ";
				else if (cell == Color.BLACK)
					string += "1 ";
			}
			string += "\n\t";
		}
		string += "\nturn : \n\t" + this.getTurn().toString();
		string += "\n\nparameter : \n\t" + this.parameter.toString();
		string += "\nprisoner : \n\t";
		string += "{";
		for (int i = 0; i < this.prisoner.size(); i += 1) {
			if (i != this.prisoner.size()-1) 
				string += this.prisoner.get(i).toString() + ", ";
			else 
				string += this.prisoner.get(i).toString();
		}
		string += "}";
		return string;
	}

	public Color[][] getGoban() {
		return this.goban;
	}
	public Color getTurn() {
		return this.turn;
	}
	public Parameter getParameter() {
		return this.parameter;
	}
	public ArrayList<Color> getPrisoner() {
		return this.prisoner;
	}
}