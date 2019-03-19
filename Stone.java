public enum Stone {
	WHITE,
	BLACK;

	@Override
	public String toString() {
		return this == WHITE ? "white" : "black";
	}

	public Stone other() {
		return this == WHITE ? BLACK : WHITE;
	}
}