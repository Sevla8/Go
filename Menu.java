import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
	private JButton start;
	private JButton option;
	private JButton quit;

	public Menu(Control control) {
		this.start = new JButton("Start");
		this.option = new JButton("Options");
		this.quit = new JButton("Quit");
		this.add(this.start);
		this.add(this.option);
		this.add(this.quit);
		this.start.addActionListener(control);
		this.option.addActionListener(control);
		this.quit.addActionListener(control);
		this.setBackground(Color.BLACK);
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
