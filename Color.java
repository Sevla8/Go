public enum Color {
	WHITE,
	BLACK;

	public Color other() {
		return this == Color.WHITE ? Color.BLACK : Color.WHITE;
	}

	public String toString() {
		return this == Color.WHITE ? "WHITE" : "BLACK";
	}
}