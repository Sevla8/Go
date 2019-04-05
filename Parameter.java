public class Parameter {
	private int size;
	private String watchType;

	public Parameter(int size, String watchType) throws WatchTypeException, SizeException  {
		if (size != 9 && size != 13 && size != 19)
			throw new SizeException();
		if (!watchType.equals("none") && !watchType.equals("absolute") && !watchType.equals("byo-yomi"))
			throw new WatchTypeException();
		else {
			this.size = size;
			this.watchType = watchType;
		}
	}

	@Override
	public String toString() {
		return "size : \n\t" + this.size + "\nwatch : \n\t" + this.watchType;
	}

	public int getSize() {
		return this.size;
	}
}