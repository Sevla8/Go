import java.lang.Exception;

public class WatchException extends Exception {

	public WatchException() {
		System.out.println("The watch type must be in ('none', 'absolute', 'byo-yomi')");
	}
}