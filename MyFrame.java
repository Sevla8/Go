import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		this.setSize(700, 700);
		this.setLocation(5, 30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Go");
		// this.setLayout(null);		
	}

	public MyFrame(Goban goban) {
		this();
		this.add(goban);
		goban.setOpaque(true);
	}

	public MyFrame(Menu menu) {
		this();
		this.add(menu);
		menu.setOpaque(true);
	}

	public MyFrame(FirstScreen firstScreen) {
		this();
		this.add(firstScreen);
		firstScreen.setOpaque(true);
	}

	public void run() {
		this.setVisible(true);
	}
}
