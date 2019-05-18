public enum Click {
	LEFT,
	SCROLL,
	RIGHT;

	public String toString() {
		return this == Click.LEFT ? "LEFT" : (this == Click.RIGHT ? "RIGHT" : "SCROLL");
	}
}
