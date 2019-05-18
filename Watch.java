public enum Watch {
	NONE,
	ABSOLUTE,
	BYO_YOMI;

	public String toString() {
		return this == Watch.NONE ? "NONE" : (this == Watch.ABSOLUTE ? "ABSOLUTE" : "BYO_YOMI");
	}
}
