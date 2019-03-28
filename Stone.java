public class Stone {
	private Color color;
	private int x;
	private int y;

	public Stone(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Stone stone = (Stone) object;
		if (this.color != stone.color)
			return false;
		if (this.x != stone.x)
			return false;
		if (this.y != stone.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{" +
				this.color.toString() +
				", " + 
				this.x + 
				", " + 
				this.y + 
				"}";
	}

	public Color getColor() {
		return this.color;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}