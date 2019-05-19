import java.awt.Color;
import javax.swing.Box;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton; 
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
	private JButton start;
	private JButton option;
	private JButton quit;

	public Menu(Control control) {
		this.setBackground(Color.BLACK);
		this.start = new JButton("Start");
		this.option = new JButton("Options");
		this.quit = new JButton("Quit");

		Box box1 = Box.createHorizontalBox();
		box1.add(this.start);

		Box box2 = Box.createHorizontalBox();
		box2.add(this.option);

		Box box3 = Box.createHorizontalBox();
		box3.add(this.quit);

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

		this.start.addActionListener(control);
		this.option.addActionListener(control);
		this.quit.addActionListener(control);
	}

	public JButton getStart() {
		return this.start;
	}
	public JButton getOption() {
		return this.option;
	}
	public JButton getQuit() {
		return this.quit;
	}
}
