
public class Go {
	private Color[][] goban;
	private Color turn;
	private Parameter parameter; // Exception if size != 19 | 13 | 9 !!

	public Go(Parameter parameter) {
		this.goban = new Color[parameter.getSize()][parameter.getSize()];
		for (Color son[] : this.goban) {
			for (Color cell : son)
				cell = null;
		}
		this.turn = Color.BLACK;
	}

	public void turnOver() {
		this.turn = this.turn.other();
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
		int liberty = 0;
		int x = stone.getX();
		int y = stone.getY();
		if (x == 0) {
			if (y == 0) {
				liberty += this.goban[y+1][x] == null ? 1 : 0;
				liberty += this.goban[y][x+1] == null ? 1 : 0;
			}
			else if (y == this.parameter.getSize() - 1) {
				liberty += this.goban[y-1][x] == null ? 1 : 0;
				liberty += this.goban[y][x+1] == null ? 1 : 0;
			}
			else {
				liberty += this.goban[y][x+1] == null ? 1 : 0;
				liberty += this.goban[y-1][x] == null ? 1 : 0;
				liberty += this.goban[y+1][x] == null ? 1 : 0;
			}
		}
		else if (x == this.parameter.getSize() - 1) {
			if (y == 0) {
				liberty += this.goban[y][x-1] == null ? 1 : 0;
				liberty += this.goban[y+1][x] == null ? 1 : 0;
			}
			else if (y == this.parameter.getSize() - 1) {
				liberty += this.goban[y][x-1] == null ? 1 : 0;
				liberty += this.goban[y-1][x] == null ? 1 : 0;
			}
			else {
				liberty += this.goban[y-1][x] == null ? 1 : 0;
				liberty += this.goban[y+1][x] == null ? 1 : 0;
				liberty += this.goban[y][x-1] == null ? 1 : 0;
			}
		}
		else {
			liberty += this.goban[y][x-1] == null ? 1 : 0;
			liberty += this.goban[x][x+1] == null ? 1 : 0;
			liberty += this.goban[y-1][x] == null ? 1 : 0;
			liberty += this.goban[y+1][x] == null ? 1 : 0;
		}
		return liberty;
	}

	// public boolean groupExists(Coord coord, Stone stone) {
	// 	int bool;							// a finir
	// 	if (this.goban[coord.y][coord.x] == stone) 

	// 	return bool;
	// }

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
		string += "\nturn : \n\t" + this.getTurn().toString() + "\n\nparameter : \n\t" /*+ this.parameter.toString()*/;
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
}