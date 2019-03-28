public class Parameter {
	private int size;

	public Parameter(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "size : \n\t" + this.size;
	}

	public int getSize() {
		return this.size;
	}
}