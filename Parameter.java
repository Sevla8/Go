public class Parameter {
	private int size;
	private int komi;
	private int delay;
	private int byoYomiTotal;
	private int byoYomiPeriod;
	private int byoYomiAmount;
	private Watch watch;

	public Parameter() {
		this.size = 19;
		this.komi = 0;
		this.watch = Watch.NONE;
		this.delay = 60;
		this.byoYomiTotal = 15;
		this.byoYomiPeriod = 20;
		this.byoYomiAmount = 3;
	}

	@Override
	public String toString() {
		return "size : \n\t"+this.size+"\n"+
				"komi : \n\t"+this.komi+"\n"+
				"delay : \n\t"+this.delay+"\n"+
				"byoYomiTotal : \n\t"+this.byoYomiTotal+"\n"+
				"byoYomiPeriod : \n\t"+this.byoYomiPeriod+"\n"+
				"byoYomiAmount : \n\t"+this.byoYomiAmount+"\n"+
				"watch : \n\t"+this.watch.toString();
	}

	public int getByoYomiTotal() {
		return this.byoYomiTotal;
	}
	public int getByoYomiPeriod() {
		return this.byoYomiPeriod;
	}
	public int getByoYomiAmount() {
		return this.byoYomiAmount;
	}
	public void setByoYomiAmount(int byoYomiAmount) {
		this.byoYomiAmount = byoYomiAmount;
	}
	public void setByoYomiTotal(int byoYomiTotal) {
		this.byoYomiTotal = byoYomiTotal;
	}
	public void setByoYomiPeriod(int byoYomiPeriod) {
		this.byoYomiPeriod = byoYomiPeriod;
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
