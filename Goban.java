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

		Box box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalGlue());
		box1.add(Box.createVerticalGlue());
		box1.add(this.watch);
		box1.add(Box.createVerticalGlue());
		box1.add(this.blackPrisoner);
		box1.add(Box.createVerticalGlue());
		box1.add(this.whitePrisoner);
		box1.add(Box.createVerticalGlue());
		box1.add(this.undo);
		box1.add(Box.createVerticalGlue());
		box1.add(this.redo);
		box1.add(Box.createVerticalGlue());
		box1.add(this.skip);
		box1.add(Box.createVerticalGlue());
		box1.add(this.giveUp);
		box1.add(Box.createVerticalGlue());
		box1.add(Box.createVerticalGlue());

		Box box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalGlue());
		box2.add(this.board);
		box2.add(Box.createVerticalGlue());

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalGlue());
		this.add(box2);
		this.add(Box.createHorizontalGlue());
		this.add(box1);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalGlue());
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
	public JLabel getBlackPrisoner() {
		return this.blackPrisoner;
	}
	public JLabel getWhitePrisoner() {
		return this.whitePrisoner;
	}
}
