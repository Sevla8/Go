public class Main {
	public static void main(String args[]){

		Parameter parameter = new Parameter(19);
		Go go = new Go(parameter);
		go.setStone(new Stone(Color.WHITE, 5, 9));
		go.setStone(new Stone(Color.BLACK, 18, 9));
		go.setStone(new Stone(Color.WHITE, 0, 0));
		go.setStone(new Stone(Color.WHITE, 7, 13));

		System.out.println(go.toString());
		System.out.println(go.getLiberty(new Stone(Color.BLACK, 18, 9)));
		
	}
}
