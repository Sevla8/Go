import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;

class Goban extends JPanel {
	private Board board;
	private JLabel watch;

	public Goban(Control control, Go go) {
		this.setBackground(Color.ORANGE);

		this.board = new Board(control, go);
		this.watch = new JLabel("time");

		Box box1 = Box.createHorizontalBox();
		box1.add(new JButton("Previous"));
		box1.add(new JButton("Following"));

		Box box2 = Box.createVerticalBox();
		box2.add(box1, this.watch);

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(this.board);
		this.add(box2);
	}

	public Board getBoard() {
		return this.board;
	}
	public JLabel getWatch() {
		return this.watch;
	}
}
