import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {
	public static void main(String args[]){

		Parameter parameter = null;
		try {
			parameter = new Parameter(19, "none");
		}
		catch (SizeException sizeException) {
			sizeException.printStackTrace();
		}
		catch (WatchTypeException watchTypeException) {
			watchTypeException.printStackTrace();
		}
		
		Go go = new Go(parameter);
		go.setStone(new Stone(Color.WHITE, 5, 9));
		go.setStone(new Stone(Color.BLACK, 18, 9));
		go.setStone(new Stone(Color.WHITE, 0, 0));
		go.setStone(new Stone(Color.WHITE, 7, 13));
		go.setStone(new Stone(Color.WHITE, 7, 14));
		go.setStone(new Stone(Color.WHITE, 8, 13));
		go.setStone(new Stone(Color.WHITE, 9, 14));
		go.setStone(new Stone(Color.BLACK, 8, 14));
		go.setStone(new Stone(Color.WHITE, 8, 15));
		go.setStone(new Stone(Color.BLACK, 9, 15));

		go.makePrisoners();

		System.out.println(go.toString());

		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setLocation(20, 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Goban");
		Goban goban = new Goban(go);
		goban.setOpaque(true);
		frame.add(goban);
		frame.setVisible(true);
	}
}
