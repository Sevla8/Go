public class Score {
	private double white;
	private double black;

	public Score(double white, double black) {
		this.white = white;
		this.black = black;
	}

	@Override
	public String toString() {
		return "white : \n\t" + this.white + "\nblack : \n\t" + this.black;

	}

	public double getWhite() {
		return this.white;
	}
	public double getBlack() {
		return this.black;
	}
}