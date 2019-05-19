import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

class Option extends JPanel {
	private JRadioButton noneWatch;
	private JRadioButton absoluteWatch;
	private JRadioButton byoYomiWatch;
	private JRadioButton size9;
	private JRadioButton size13;
	private JRadioButton size19;
	private JButton save;
	private JButton back;

	public Option(Control control) {
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
		this.add(this.save);
		this.add(this.back);
		this.save.addActionListener(control);
		this.back.addActionListener(control);
		this.setBackground(Color.BLACK);
	}

	public JRadioButton getNoneWatch() {
		return this.noneWatch;
	}
	public JRadioButton getAbsoluteWatch() {
		return this.absoluteWatch;
	}
	public JRadioButton getByoYomiWatch() {
		return this.byoYomiWatch;
	}
	public JRadioButton getSize9() {
		return this.size9;
	}
	public JRadioButton getSize13() {
		return this.size13;
	}
	public JRadioButton getSize19() {
		return this.size19;
	}
	public JButton getSave() {
		return this.save;
	}
	public JButton getBack() {
		return this.back;
	}
}
