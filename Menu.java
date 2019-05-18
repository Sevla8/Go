import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Menu extends JPanel implements ActionListener {
	private Parameter parameter;
	private MyFrame myFrame;
	private JRadioButton noneWatch;
	private JRadioButton absoluteWatch;
	private JRadioButton byoYomiWatch;
	private JRadioButton size9;
	private JRadioButton size13;
	private JRadioButton size19;
	private JButton save;
	private JButton back;

	public Menu(MyFrame myFrame, Parameter parameter) {
		ButtonGroup watchGroup = new ButtonGroup();
		this.noneWatch = new JRadioButton("None");
		this.absoluteWatch = new JRadioButton("Absolute");
		this.byoYomiWatch = new JRadioButton("Byo-Yomi");
		watchGroup.add(this.noneWatch);
		watchGroup.add(this.absoluteWatch);
		watchGroup.add(this.byoYomiWatch);
		this.add(this.noneWatch);
		this.add(this.absoluteWatch);
		this.add(this.byoYomiWatch);
		ButtonGroup sizeGroup = new ButtonGroup();
		this.size9 = new JRadioButton("9x9");
		this.size13 = new JRadioButton("13x13");
		this.size19 = new JRadioButton("19x19");
		sizeGroup.add(this.size9);
		sizeGroup.add(this.size13);
		sizeGroup.add(this.size19);
		this.add(this.size9);
		this.add(this.size13);
		this.add(this.size19);
		this.save = new JButton("Save");
		this.back = new JButton("Back");
		this.save.addActionListener(this);
		this.back.addActionListener(this);
		this.setBackground(Color.BLACK);

		this.parameter = parameter;
		this.myFrame = myFrame;
		this.myFrame.add(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.save &&
			(this.noneWatch.isSelected() || this.absoluteWatch.isSelected() || this.byoYomiWatch.isSelected()) &&
			(this.size9.isSelected() || this.size13.isSelected() || this.size19.isSelected())) {
			if (this.size9.isSelected())
				this.parameter.setSize(9);
			else if (this.size13.isSelected())
				this.parameter.setSize(13);
			else 
				this.parameter.setSize(19);
			if (this.noneWatch.isSelected())
				this.parameter.setWatch(Watch.NONE);
			else if (this.absoluteWatch.isSelected())
				this.parameter.setWatch(Watch.ABSOLUTE);
			else 
				this.parameter.setWatch(Watch.BYO_YOMI);
		}
		if (e.getSource() == this.back) {
			
		}
	}

	public Parameter getParameter() {
		return this.parameter;
	}
}
