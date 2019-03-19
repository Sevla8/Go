
public class Go {
	public Stone[][] goban;
	public Stone turn;
	public int size;

	public Go(int size) {
		this.goban = new Stone[size][size];
		for (Stone son[] : this.goban) {
			for (Stone cell : son)
				cell = null;
		}
		this.turn = Stone.BLACK;
		this.size = size;
	}

	public void turnOver() {
		this.turn = (this.turn == Stone.WHITE) ? Stone.BLACK : Stone.WHITE;
	}

	public void setStone(Coord coord) {
		if (this.goban[coord.y][coord.x] == null)
			this.goban[coord.y][coord.x] = this.turn;
		this.turnOver();
	}

	public int getLiberty(Coord coord) {
		int liberty = 0;
		int x = coord.x;
		int y = coord.y;					// a corriger [y][x]
		if (x == 0) {
			if (y == 0) {
				liberty += this.goban[x+1][y] == null ? 1 : 0;
				liberty += this.goban[x][y+1] == null ? 1 : 0;
			}
			else if (y == this.size - 1) {
				liberty += this.goban[x+1][y] == null ? 1 : 0;
				liberty += this.goban[x][y-1] == null ? 1 : 0;
			}
			else {
				liberty += this.goban[x][y-1] == null ? 1 : 0;
				liberty += this.goban[x+1][y] == null ? 1 : 0;
				liberty += this.goban[x][y+1] == null ? 1 : 0;
			}
		}
		else if (x == this.size - 1) {
			if (coord.y == 0) {
				liberty += this.goban[x-1][y] == null ? 1 : 0;
				liberty += this.goban[x][y+1] == null ? 1 : 0;
			}
			else if (y == this.size - 1) {
				liberty += this.goban[x-1][y] == null ? 1 : 0;
				liberty += this.goban[x][y-1] == null ? 1 : 0;
			}
			else {
				liberty += this.goban[x][y-1] == null ? 1 : 0;
				liberty += this.goban[x-1][y] == null ? 1 : 0;
				liberty += this.goban[x][y+1] == null ? 1 : 0;
			}
		}
		else {
			liberty += this.goban[x-1][y] == null ? 1 : 0;
			liberty += this.goban[x+1][y] == null ? 1 : 0;
			liberty += this.goban[x][y-1] == null ? 1 : 0;
			liberty += this.goban[x][y+1] == null ? 1 : 0;
		}
		return liberty;
	}

	public boolean groupExists(Coord coord, Stone stone) {
		int bool;							// a finir
		if (this.goban[coord.y][coord.x] == stone) 

		return bool;
	}

}