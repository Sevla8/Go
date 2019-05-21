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
	private JRadioButton komi0;
	private JRadioButton komi1;
	private JRadioButton komi2;
	private JRadioButton komi3;
	private JRadioButton komi4;
	private JRadioButton komi5;
	private JRadioButton komi6;
	private JRadioButton komi7;
	private JRadioButton komi8;
	private JRadioButton komi9;
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
		this.komi0 = new JRadioButton("0");
		this.komi1 = new JRadioButton("1");
		this.komi2 = new JRadioButton("2");
		this.komi3 = new JRadioButton("3");
		this.komi4 = new JRadioButton("4");
		this.komi5 = new JRadioButton("5");
		this.komi6 = new JRadioButton("6");
		this.komi7 = new JRadioButton("7");
		this.komi8 = new JRadioButton("8");
		this.komi9 = new JRadioButton("9");
		this.komi0.setBackground(this.getBackground());
		this.komi1.setBackground(this.getBackground());
		this.komi2.setBackground(this.getBackground());
		this.komi3.setBackground(this.getBackground());
		this.komi4.setBackground(this.getBackground());
		this.komi5.setBackground(this.getBackground());
		this.komi6.setBackground(this.getBackground());
		this.komi7.setBackground(this.getBackground());
		this.komi8.setBackground(this.getBackground());
		this.komi9.setBackground(this.getBackground());
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
		ButtonGroup komiGroup = new ButtonGroup();
		komiGroup.add(komi0);
		komiGroup.add(komi1);
		komiGroup.add(komi2);
		komiGroup.add(komi3);
		komiGroup.add(komi4);
		komiGroup.add(komi5);
		komiGroup.add(komi6);
		komiGroup.add(komi7);
		komiGroup.add(komi8);
		komiGroup.add(komi9);
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

		Box box7 = Box.createVerticalBox();
		box7.add(new JLabel("Komi"));
		Box box8 = Box.createVerticalBox();
		box8.add(this.komi0);
		box8.add(this.komi1);
		box8.add(this.komi2);
		box8.add(this.komi3);
		box8.add(this.komi4);
		box8.add(this.komi5);
		box8.add(this.komi6);
		box8.add(this.komi7);
		box8.add(this.komi8);
		box8.add(this.komi9);
		Box box9 = Box.createHorizontalBox();
		box9.add(Box.createHorizontalGlue());
		box9.add(Box.createHorizontalGlue());
		box9.add(box7);
		box9.add(Box.createHorizontalGlue());
		box9.add(box8);
		box9.add(Box.createHorizontalGlue());
		box9.add(Box.createHorizontalGlue());

		Box box10 = Box.createHorizontalBox();
		box10.add(Box.createHorizontalGlue());
		box10.add(Box.createHorizontalGlue());
		box10.add(this.back);
		box10.add(Box.createHorizontalGlue());
		box10.add(this.save);
		box10.add(Box.createHorizontalGlue());
		box10.add(Box.createHorizontalGlue());

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(box3);
		this.add(Box.createVerticalGlue());
		this.add(box6);
		this.add(Box.createVerticalGlue());
		this.add(box9);
		this.add(Box.createVerticalGlue());
		this.add(box10);
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
	public JRadioButton getKomi0() {
		return this.komi0;
	}
	public JRadioButton getKomi1() {
		return this.komi1;
	}
	public JRadioButton getKomi2() {
		return this.komi2;
	}
	public JRadioButton getKomi3() {
		return this.komi3;
	}
	public JRadioButton getKomi4() {
		return this.komi4;
	}
	public JRadioButton getKomi5() {
		return this.komi5;
	}
	public JRadioButton getKomi6() {
		return this.komi6;
	}
	public JRadioButton getKomi7() {
		return this.komi7;
	}
	public JRadioButton getKomi8() {
		return this.komi8;
	}
	public JRadioButton getKomi9() {
		return this.komi9;
	}
	public JButton getSave() {
		return this.save;
	}
	public JButton getBack() {
		return this.back;
	}
}
