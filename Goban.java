import java.awt.Color;
import javax.swing.Box;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

class Goban extends JPanel {
	private Timer timer;
	private Board board;
	private Information information;

	public Goban(Control control, Go go) {
		this.setBackground(Color.BLACK);

		// this.timer = new Timer(go.getParameter().getDelay(), control);
		this.board = new Board(control, go);
		this.information = new Information(control, this.board.getGo().getTurn());

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalGlue());
		this.add(this.board);
		this.add(Box.createHorizontalGlue());
		this.add(this.information);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalGlue());
	}

	public Board getBoard() {
		return this.board;
	}
	public Information getInformation() {
		return this.information;
	}
	public Timer getTimer() {
		return this.timer;
	}
}
