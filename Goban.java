import java.awt.Color;
import java.awt.Point;
import javax.swing.Box;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.BoxLayout;

class Goban extends JPanel {
	private Board board;
	private JLabel watch;
	private JButton skip;
	private JButton undo;
	private JButton redo;
	private JButton giveUp;
	private JLabel blackPrisoner;
	private JLabel whitePrisoner;

	public Goban(Control control, Go go) {
		this.setBackground(Color.ORANGE);
		this.board = new Board(control, go);
		this.watch = new JLabel("time : 00:00");
		this.blackPrisoner = new JLabel("Black Prisoners : 0");
		this.whitePrisoner = new JLabel("White Prisoners : 0");
		this.undo = new JButton("Undo");
		this.redo = new JButton("Redo");
		this.skip = new JButton("Skip");
		this.giveUp = new JButton("Give up");
		this.undo.addActionListener(control);
		this.redo.addActionListener(control);
		this.skip.addActionListener(control);
		this.giveUp.addActionListener(control);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.board);
		this.add(this.watch);
		this.add(this.blackPrisoner);
		this.add(this.whitePrisoner);
		this.add(this.undo);
		this.add(this.redo);
		this.add(this.skip);
		this.add(this.giveUp);
	}

	public Board getBoard() {
		return this.board;
	}
	public void setWatch(JLabel watch) {
		this.watch = watch;
	}
	public JButton getSkip() {
		return this.skip;
	}
	public JButton getGiveUp() {
		return this.giveUp;
	}
	public JButton getUndo() {
		return this.undo;
	}
	public JButton getRedo() {
		return this.redo;
	}
	public void setBlackPrisoner(JLabel blackPrisoner) {
		this.blackPrisoner = blackPrisoner;
	}
	public void setWhitePrisoner(JLabel whitePrisoner) {
		this.whitePrisoner = whitePrisoner;
	}
}
