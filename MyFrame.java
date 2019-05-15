import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame(Goban goban) {
		this.setSize(700, 700);
		this.setLocation(5, 30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Go");
		// this.setLayout(null);

		goban.setOpaque(true);
		
		this.add(goban);
	}

	public void run() {
		this.setVisible(true);
	}
}
