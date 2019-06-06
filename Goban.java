import java.awt.Color;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

class Goban extends JPanel {
	private Board board;
	private Information information;

	public Goban(Control control, Go go) {
		this.setBackground(Color.BLACK);

		this.board = new Board(control, go);
		this.information = new Information(control, this.board.getGo().getTurn(), this.board.getGo().getParameter().getDelay());

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
}
