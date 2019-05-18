public class Parameter {
	private int size;
	private int caseSize = 30;
	private int marge = 60;
	private Watch watch;

	public Parameter(int size, Watch watch) throws SizeException {
		if (size != 9 && size != 13 && size != 19)
			throw new SizeException();
		else {
			this.size = size;
			this.watch = watch;
		}
	}

	@Override
	public String toString() {
		return "size : \n\t" + this.size + 
				"\ncaseSize : \n\t" + this.caseSize +
				"\nmarge : \n\t" + this.marge +
				"\nwatch : \n\t" + this.watch.toString();
	}

	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCaseSize() {
		return this.caseSize;
	}
	public int getMarge() {
		return this.marge;
	}
	public Watch getWatch() {
		return this.watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
}