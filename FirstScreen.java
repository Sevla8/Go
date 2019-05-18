import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen extends JPanel implements ActionListener {
	private JButton start;
	private JButton menu;
	private JButton quit;
	private MyFrame myFrame;
	private Parameter parameter;

	public FirstScreen(MyFrame myFrame, Parameter parameter) {
		this.start = new JButton("Start");
		this.menu = new JButton("Menu");
		this.quit = new JButton("Quit");
		this.add(this.start);
		this.add(this.menu);
		this.add(this.quit);
		this.start.addActionListener(this);
		this.menu.addActionListener(this);
		this.quit.addActionListener(this);
		this.setBackground(Color.BLACK);

		this.myFrame = myFrame;
		this.myFrame.add(this);
		this.parameter = parameter;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.quit)
			this.myFrame.dispose();
		if (e.getSource() == this.menu) {
			Menu menu = new Menu(this.myFrame, this.parameter);
			this.myFrame.remove(this);
		}
	}
}
