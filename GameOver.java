import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class GameOver extends JPanel {
	private JButton menu;

	public GameOver(Control control, Player player, double blackScore, double whiteScore) {
		JLabel label = new JLabel("GAME OVER");
		Box box1 = Box.createHorizontalBox();
		box1.add(label);

		JLabel winner = new JLabel("Winner is Player "+player);
		Box box2 = Box.createHorizontalBox();
		box2.add(winner);

		JLabel blackScoreLabel = new JLabel("Black Player Score : "+blackScore);
		Box box3 = Box.createHorizontalBox();
		box3.add(blackScoreLabel);

		JLabel whiteScoreLabel = new JLabel("White Player Score : "+whiteScore);
		Box box4 = Box.createHorizontalBox();
		box4.add(whiteScoreLabel);

		this.menu = new JButton("Menu");
		this.menu.addActionListener(control);
		Box box5 = Box.createHorizontalBox();
		box5.add(this.menu);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(box1);
		this.add(Box.createVerticalGlue());
		this.add(box2);
		this.add(Box.createVerticalGlue());
		this.add(box3);
		this.add(Box.createVerticalGlue());
		this.add(box4);
		this.add(Box.createVerticalGlue());
		this.add(box5);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
	}

	public JButton getMenu() {
		return this.menu;
	}
}
