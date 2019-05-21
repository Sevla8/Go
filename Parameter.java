public class Parameter {
	private int size;
	private int komi;
	private Watch watch;
	private int marge = 60;
	private int caseSize = 30;

	public Parameter() {
		this.size = 19;
		this.komi = 0;
		this.watch = Watch.NONE;
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
	public int getKomi() {
		return this.komi;
	}
	public void setKomi(int komi) {
		this.komi = komi; System.out.println(this.komi);
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