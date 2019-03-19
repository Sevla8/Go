public class Main {
	public static void main(String args[]){
		
		Go go = new Go(9);
		Coord coord1 = new Coord(4, 0);
		// Coord coord2 = new Coord(6, 7);
		// Coord coord3 = new Coord(7, 7);

		// go.setStone(coord1);
		// go.setStone(coord3);
		int z = go.getLiberty(coord1);

		System.out.println(z);
	}
}
