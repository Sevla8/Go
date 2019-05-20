import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;

class Goban extends JPanel {
	private Board board;
	private JLabel watch;
	private JButton skip;
	private JButton giveUp;
	private JButton previous;
	private JButton following;
	private JLabel blackPrisoner;
	private JLabel whitePrisoner;

	public Goban(Control control, Go go) {
		this.setBackground(Color.ORANGE);
		this.board = new Board(control, go);
		this.watch = new JLabel("time : 00:00");
		this.blackPrisoner = new JLabel("Black Prisoners : 0");
		this.whitePrisoner = new JLabel("White Prisoners : 0");
		this.previous = new JButton("Previous");
		this.following = new JButton("Following");
		this.skip = new JButton("Skip");
		this.giveUp = new JButton("Give up");
		this.previous.addActionListener(control);
		this.following.addActionListener(control);
		this.skip.addActionListener(control);
		this.giveUp.addActionListener(control);

		Box box1 = Box.createHorizontalBox();
		box1.add(Box.createHorizontalGlue());
		box1.add(Box.createHorizontalGlue());
		box1.add(previous);
		box1.add(Box.createHorizontalGlue());
		box1.add(following);
		box1.add(Box.createHorizontalGlue());
		box1.add(Box.createHorizontalGlue());

		Box box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalGlue());	
		box2.add(Box.createVerticalGlue());	
		box2.add(box1);
		box2.add(Box.createVerticalGlue());
		box2.add(this.watch);
		box2.add(Box.createVerticalGlue());
		box2.add(Box.createVerticalGlue());

		//box2.setSize(new Dimension(this.getWidth()/3, this.getHeight()));
		// this.board.setSize(new Dimension(2*this.getWidth()/3, this.getHeight()));

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		// this.add(Box.createHorizontalGlue());
		// this.add(Box.createHorizontalGlue());
		this.add(this.board);
		// this.add(Box.createHorizontalGlue());
		// this.add(box2);
		// this.add(Box.createHorizontalGlue());
		// this.add(Box.createHorizontalGlue());
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
	public JButton getPrevious() {
		return this.previous;
	}
	public JButton getFollowing() {
		return this.following;
	}
	public void setBlackPrisoner(JLabel blackPrisoner) {
		this.blackPrisoner = blackPrisoner;
	}
	public void setWhitePrisoner(JLabel whitePrisoner) {
		this.whitePrisoner = whitePrisoner;
	}
}
