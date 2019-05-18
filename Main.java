import javax.swing.JFrame;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]){

		Parameter parameter = null;
		try {
			parameter = new Parameter(19, Watch.NONE);
		}
		catch (SizeException sizeException) {
			sizeException.printStackTrace();
		}
		
		MyFrame myFrame = new MyFrame();
		FirstScreen firstScreen = new FirstScreen(myFrame, parameter);
		myFrame.setVisible(true);

/*		Go go = new Go(parameter);
		go.setStone(new Stone(Player.WHITE, 5, 9));
		go.setStone(new Stone(Player.BLACK, 18, 9));
		go.setStone(new Stone(Player.WHITE, 0, 0));
		go.setStone(new Stone(Player.WHITE, 7, 13));
		go.setStone(new Stone(Player.WHITE, 7, 14));
		go.setStone(new Stone(Player.WHITE, 8, 13));
		go.setStone(new Stone(Player.WHITE, 9, 14));
		go.setStone(new Stone(Player.BLACK, 8, 14));
		go.setStone(new Stone(Player.WHITE, 8, 15));
		go.setStone(new Stone(Player.BLACK, 9, 15));

		Goban goban = new Goban(go);
*/
		// System.out.println(go.toString());
	}
}
