public enum Player {
	WHITE,
	BLACK;

	public Player other() {
		return this == Player.WHITE ? Player.BLACK : Player.WHITE;
	}

	public String toString() {
		return this == Player.WHITE ? "WHITE" : "BLACK";
	}
}