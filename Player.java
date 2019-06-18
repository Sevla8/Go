public enum Player {
	WHITE,
	BLACK,
	WHITE_TMP,
	BLACK_TMP;

	public Player other() {
		return this == Player.WHITE ? Player.BLACK : Player.WHITE;
	}

	public String toString() {
		return this == Player.WHITE ? "WHITE" : "BLACK";
	}
}
