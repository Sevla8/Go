public class Parameter {
	private int size;
	private int komi;
	private int delay;
	private Watch watch;

	public Parameter() {
		this.size = 19;
		this.komi = 0;
		this.watch = Watch.NONE;
		this.delay = 30;
	}

	@Override
	public String toString() {
		return "size : \n\t"+this.size+"\n"+
				"komi : \n\t"+this.komi+"\n"+
				"delay : \n\t"+this.delay+"\n"+
				"watch : \n\t"+this.watch.toString();
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
		this.komi = komi;
	}
	public Watch getWatch() {
		return this.watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public int getDelay() {
		return this.delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
}
