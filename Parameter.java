public class Parameter {
	private int size;
	private int caseSize = 30;
	private int marge = 60;
	private String watch;

	public Parameter(int size, String watch) throws WatchException, SizeException {
		if (size != 9 && size != 13 && size != 19)
			throw new SizeException();
		if (!watch.equals("none") && !watch.equals("absolute") && !watch.equals("byo-yomi"))
			throw new WatchException();
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
				"\nwatch : \n\t" + this.watch;
	}

	public int getSize() {
		return this.size;
	}
	public int getCaseSize() {
		return this.caseSize;
	}
	public int getMarge() {
		return this.marge;
	}
	public String getWatch() {
		return this.watch;
	}
}