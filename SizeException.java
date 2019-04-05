import java.lang.Exception;

public class SizeException extends Exception {

	public SizeException() {
		System.out.println("The size must be in (9, 12, 19)");
	}
}