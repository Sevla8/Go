public class Main {
	public static void main(String args[]){

		Parameter parameter = new Parameter(19);
		Go go = new Go(parameter);

		Stone stone = new Stone(Color.WHITE, 15, 6);
		System.out.println(stone.toString());
		
	}
}
