import java.awt.Color;
import javax.swing.Box;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

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
		this.setBackground(Color.GRAY);
		this.save = new JButton("Save");
		this.back = new JButton("Back");
		this.noneWatch = new JRadioButton("None");
		this.absoluteWatch = new JRadioButton("Absolute");
		this.byoYomiWatch = new JRadioButton("Byo-Yomi");
		this.size9 = new JRadioButton("9x9");
		this.size13 = new JRadioButton("13x13");
		this.size19 = new JRadioButton("19x19");
		this.size9.setBackground(this.getBackground());
		this.size13.setBackground(this.getBackground());
		this.size19.setBackground(this.getBackground());
		this.noneWatch.setBackground(this.getBackground());
		this.absoluteWatch.setBackground(this.getBackground());
		this.byoYomiWatch.setBackground(this.getBackground());
		ButtonGroup watchGroup = new ButtonGroup();
		watchGroup.add(this.noneWatch);
		watchGroup.add(this.absoluteWatch);
		watchGroup.add(this.byoYomiWatch);
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(this.size9);
		sizeGroup.add(this.size13);
		sizeGroup.add(this.size19);

		Box box1 = Box.createVerticalBox();
		box1.add(new JLabel("Size"));
		Box box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalGlue());
		box2.add(Box.createVerticalGlue());
		box2.add(this.size19);
		box2.add(Box.createVerticalGlue());
		box2.add(this.size13);
		box2.add(Box.createVerticalGlue());
		box2.add(this.size9);
		box2.add(Box.createVerticalGlue());
		box2.add(Box.createVerticalGlue());
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalGlue());
		box3.add(Box.createHorizontalGlue());
		box3.add(box1);
		box3.add(Box.createHorizontalGlue());
		box3.add(box2);
		box3.add(Box.createHorizontalGlue());
		box3.add(Box.createHorizontalGlue());

		Box box4 = Box.createVerticalBox();
		box4.add(new JLabel("Watch"));
		Box box5 = Box.createVerticalBox();
		box5.add(Box.createVerticalGlue());
		box5.add(Box.createVerticalGlue());
		box5.add(this.noneWatch);
		box5.add(Box.createVerticalGlue());
		box5.add(this.absoluteWatch);
		box5.add(Box.createVerticalGlue());
		box5.add(this.byoYomiWatch);
		box5.add(Box.createVerticalGlue());
		box5.add(Box.createVerticalGlue());
		Box box6 = Box.createHorizontalBox();
		box6.add(Box.createHorizontalGlue());
		box6.add(Box.createHorizontalGlue());
		box6.add(box4);
		box6.add(Box.createHorizontalGlue());
		box6.add(box5);
		box6.add(Box.createHorizontalGlue());
		box6.add(Box.createHorizontalGlue());

		Box box7 = Box.createHorizontalBox();
		box7.add(Box.createHorizontalGlue());
		box7.add(Box.createHorizontalGlue());
		box7.add(this.back);
		box7.add(Box.createHorizontalGlue());
		box7.add(this.save);
		box7.add(Box.createHorizontalGlue());
		box7.add(Box.createHorizontalGlue());

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(box3);
		this.add(Box.createVerticalGlue());
		this.add(box6);
		this.add(Box.createVerticalGlue());
		this.add(box7);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());

		this.save.addActionListener(control);
		this.back.addActionListener(control);
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
