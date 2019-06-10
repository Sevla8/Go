public enum Player {
	WHITE,
	BLACK,
	WHITE_TMP,
	BLACK_TMP,
	GRAY;

	public Player other() {
		return this == Player.WHITE ? Player.BLACK : Player.WHITE;
	}

	public String toString() {
		return this == Player.WHITE ? "WHITE" : (this == Player.BLACK ? "BLACK" : "GRAY");
	}
}
