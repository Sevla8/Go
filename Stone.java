public class Stone {
	private Player player;
	private int x;
	private int y;

	public Stone(Player player, int x, int y) {
		this.player = player;
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
		if (this.player != stone.player)
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
				this.player.toString() +
				", " + 
				this.x + 
				", " + 
				this.y + 
				"}";
	}

	public Player getPlayer() {
		return this.player;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}