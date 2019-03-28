import java.util.ArrayList;

public class Main {
	public static void main(String args[]){

		Parameter parameter = new Parameter(19);
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
	}
}
