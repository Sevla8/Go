
public class Go {
	public Stone[][] goban;
	public Color turn;
	public Parameter parameter;

	public Go(Parameter parameter) {
		this.goban = new Stone[parameter.getSize()][parameter.getSize()];
		for (Stone son[] : this.goban) {
			for (Stone cell : son)
				cell = null;
		}
		this.turn = Color.BLACK;
	}

	// public void turnOver() {
	// 	this.turn = (this.turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
	// }

	// public void setStone(int x, int y) {
	// 	this.goban.grid[y][x] = new Stone(this.turn, x, y);
	// }

	// public int getLiberty(Stone stone) {
	// 	int liberty = 0;
	// 	int x = stone.x;
	// 	int y = stone.y;
	// 	if (x == 0) {
	// 		if (y == 0) {
	// 			liberty += this.goban.grid[y+1][x] == null ? 1 : 0;
	// 			liberty += this.goban.grid[y][x+1] == null ? 1 : 0;
	// 		}
	// 		else if (y == this.goban.size - 1) {
	// 			liberty += this.goban.grid[y-1][x] == null ? 1 : 0;
	// 			liberty += this.goban.grid[y][x+1] == null ? 1 : 0;
	// 		}
	// 		else {
	// 			liberty += this.goban.grid[y][x+1] == null ? 1 : 0;
	// 			liberty += this.goban.grid[y-1][x] == null ? 1 : 0;
	// 			liberty += this.goban.grid[y+1][x] == null ? 1 : 0;
	// 		}
	// 	}
	// 	else if (x == this.size - 1) {
	// 		if (y == 0) {
	// 			liberty += this.goban[y][x-1] == null ? 1 : 0;
	// 			liberty += this.goban[y+1][x] == null ? 1 : 0;
	// 		}
	// 		else if (y == this.size - 1) {
	// 			liberty += this.goban[y][x-1] == null ? 1 : 0;
	// 			liberty += this.goban[y-1][x] == null ? 1 : 0;
	// 		}
	// 		else {
	// 			liberty += this.goban[y-1][x] == null ? 1 : 0;
	// 			liberty += this.goban[y+1][x] == null ? 1 : 0;
	// 			liberty += this.goban[y][x-1] == null ? 1 : 0;
	// 		}
	// 	}
	// 	else {
	// 		liberty += this.goban[y][x-1] == null ? 1 : 0;
	// 		liberty += this.goban[x][x+1] == null ? 1 : 0;
	// 		liberty += this.goban[y-1][x] == null ? 1 : 0;
	// 		liberty += this.goban[y+1][x] == null ? 1 : 0;
	// 	}
	// 	return liberty;
	// }

	// public boolean groupExists(Coord coord, Stone stone) {
	// 	int bool;							// a finir
	// 	if (this.goban[coord.y][coord.x] == stone) 

	// 	return bool;
	// }

}