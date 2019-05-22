import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class GameOver extends JPanel {
	private JButton menu;

	public GameOver(Control control, Player player) {
		JLabel label = new JLabel("GAME OVER");
		Box box1 = Box.createHorizontalBox();
		box1.add(label);

		JLabel winner = new JLabel("Winner is Player "+player);
		Box box2 = Box.createHorizontalBox();
		box2.add(winner);

		this.menu = new JButton("Menu");
		this.menu.addActionListener(control);
		Box box3 = Box.createHorizontalBox();
		box3.add(this.menu);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(box1);
		this.add(Box.createVerticalGlue());
		this.add(box2);
		this.add(Box.createVerticalGlue());
		this.add(box3);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
	}

	public JButton getMenu() {
		return this.menu;
	}
}
