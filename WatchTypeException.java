import java.lang.Exception;

public class WatchTypeException extends Exception {

	public WatchTypeException() {
		System.out.println("The watch type must be in ('none', 'absolute', 'byo-yomi')");
	}
}