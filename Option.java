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

public class Option extends JPanel {
	private JRadioButton noneWatch;
	private JRadioButton absoluteWatch;
	private JRadioButton byoYomiWatch;
	private JRadioButton delay10;
	private JRadioButton delay20;
	private JRadioButton delay30;
	private JRadioButton delay60;
	private JRadioButton delay120;
	private JRadioButton delay180;
	private JRadioButton byoYomiTotal3;
	private JRadioButton byoYomiTotal5;
	private JRadioButton byoYomiTotal10;
	private JRadioButton byoYomiTotal15;
	private JRadioButton byoYomiTotal20;
	private JRadioButton byoYomiPeriod10;
	private JRadioButton byoYomiPeriod20;
	private JRadioButton byoYomiPeriod30;
	private JRadioButton byoYomiAmount1;
	private JRadioButton byoYomiAmount2;
	private JRadioButton byoYomiAmount3;
	private JRadioButton byoYomiAmount4;
	private JRadioButton byoYomiAmount5;
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
		this.delay10 = new JRadioButton("10");
		this.delay20 = new JRadioButton("20");
		this.delay30 = new JRadioButton("30");
		this.delay60 = new JRadioButton("60");
		this.delay120 = new JRadioButton("120");
		this.delay180 = new JRadioButton("180");
		this.byoYomiTotal3 = new JRadioButton("3");
		this.byoYomiTotal5 = new JRadioButton("5");
		this.byoYomiTotal10 = new JRadioButton("10");
		this.byoYomiTotal15 = new JRadioButton("15");
		this.byoYomiTotal20 = new JRadioButton("20");
		this.byoYomiPeriod10 = new JRadioButton("10");
		this.byoYomiPeriod20 = new JRadioButton("20");
		this.byoYomiPeriod30 = new JRadioButton("30");
		this.byoYomiAmount1 = new JRadioButton("1");
		this.byoYomiAmount2 = new JRadioButton("2");
		this.byoYomiAmount3 = new JRadioButton("3");
		this.byoYomiAmount4 = new JRadioButton("4");
		this.byoYomiAmount5 = new JRadioButton("5");
		this.delay10.setBackground(this.getBackground());
		this.delay20.setBackground(this.getBackground());
		this.delay30.setBackground(this.getBackground());
		this.delay60.setBackground(this.getBackground());
		this.delay120.setBackground(this.getBackground());
		this.delay180.setBackground(this.getBackground());
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
		this.byoYomiTotal3.setBackground(this.getBackground());
		this.byoYomiTotal5.setBackground(this.getBackground());
		this.byoYomiTotal10.setBackground(this.getBackground());
		this.byoYomiTotal15.setBackground(this.getBackground());
		this.byoYomiTotal20.setBackground(this.getBackground());
		this.byoYomiPeriod10.setBackground(this.getBackground());
		this.byoYomiPeriod20.setBackground(this.getBackground());
		this.byoYomiPeriod30.setBackground(this.getBackground());
		this.byoYomiAmount1.setBackground(this.getBackground());
		this.byoYomiAmount2.setBackground(this.getBackground());
		this.byoYomiAmount3.setBackground(this.getBackground());
		this.byoYomiAmount4.setBackground(this.getBackground());
		this.byoYomiAmount5.setBackground(this.getBackground());
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
		ButtonGroup delayGroup = new ButtonGroup();
		delayGroup.add(this.delay10);
		delayGroup.add(this.delay20);
		delayGroup.add(this.delay30);
		delayGroup.add(this.delay60);
		delayGroup.add(this.delay120);
		delayGroup.add(this.delay180);
		ButtonGroup byoYomiTotalGroup = new ButtonGroup();
		byoYomiTotalGroup.add(this.byoYomiTotal3);
		byoYomiTotalGroup.add(this.byoYomiTotal5);
		byoYomiTotalGroup.add(this.byoYomiTotal10);
		byoYomiTotalGroup.add(this.byoYomiTotal15);
		byoYomiTotalGroup.add(this.byoYomiTotal20);
		ButtonGroup byoYomiPeriodGroup = new ButtonGroup();
		byoYomiPeriodGroup.add(this.byoYomiPeriod10);
		byoYomiPeriodGroup.add(this.byoYomiPeriod20);
		byoYomiPeriodGroup.add(this.byoYomiPeriod30);
		ButtonGroup byoYomiAmountGroup = new ButtonGroup();
		byoYomiAmountGroup.add(this.byoYomiAmount1);
		byoYomiAmountGroup.add(this.byoYomiAmount2);
		byoYomiAmountGroup.add(this.byoYomiAmount3);
		byoYomiAmountGroup.add(this.byoYomiAmount4);
		byoYomiAmountGroup.add(this.byoYomiAmount5);

		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("Size"));
		Box box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalGlue());
		box2.add(Box.createHorizontalGlue());
		box2.add(this.size19);
		box2.add(Box.createHorizontalGlue());
		box2.add(this.size13);
		box2.add(Box.createHorizontalGlue());
		box2.add(this.size9);
		box2.add(Box.createHorizontalGlue());
		box2.add(Box.createHorizontalGlue());
		Box box3 = Box.createVerticalBox();
		box3.add(Box.createVerticalGlue());
		box3.add(Box.createVerticalGlue());
		box3.add(box1);
		box3.add(Box.createVerticalGlue());
		box3.add(box2);
		box3.add(Box.createVerticalGlue());
		box3.add(Box.createVerticalGlue());

		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("Watch"));
		Box box5 = Box.createHorizontalBox();
		box5.add(Box.createHorizontalGlue());
		box5.add(Box.createHorizontalGlue());
		box5.add(this.noneWatch);
		box5.add(Box.createHorizontalGlue());
		box5.add(this.absoluteWatch);
		box5.add(Box.createHorizontalGlue());
		box5.add(this.byoYomiWatch);
		box5.add(Box.createHorizontalGlue());
		box5.add(Box.createHorizontalGlue());
		Box box6 = Box.createVerticalBox();
		box6.add(Box.createVerticalGlue());
		box6.add(Box.createVerticalGlue());
		box6.add(box4);
		box6.add(Box.createVerticalGlue());
		box6.add(box5);
		box6.add(Box.createVerticalGlue());
		box6.add(Box.createVerticalGlue());

		Box box7 = Box.createHorizontalBox();
		box7.add(new JLabel("Komi"));
		Box box8 = Box.createHorizontalBox();
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
		Box box9 = Box.createVerticalBox();
		box9.add(Box.createVerticalGlue());
		box9.add(Box.createVerticalGlue());
		box9.add(box7);
		box9.add(Box.createVerticalGlue());
		box9.add(box8);
		box9.add(Box.createVerticalGlue());
		box9.add(Box.createVerticalGlue());

		Box box10 = Box.createHorizontalBox();
		box10.add(new JLabel("Absolute Watch Delay (sec)"));
		Box box11 = Box.createHorizontalBox();
		box11.add(this.delay10);
		box11.add(this.delay20);
		box11.add(this.delay30);
		box11.add(this.delay60);
		box11.add(this.delay120);
		box11.add(this.delay180);
		Box box12 = Box.createVerticalBox();
		box12.add(Box.createVerticalGlue());
		box12.add(Box.createVerticalGlue());
		box12.add(box10);
		box12.add(Box.createVerticalGlue());
		box12.add(box11);
		box12.add(Box.createVerticalGlue());
		box12.add(Box.createVerticalGlue());

		Box box13 = Box.createHorizontalBox();
		box13.add(new JLabel("Byo-Yomi Total Time (min)"));
		Box box14 = Box.createHorizontalBox();
		box14.add(this.byoYomiTotal3);
		box14.add(this.byoYomiTotal5);
		box14.add(this.byoYomiTotal10);
		box14.add(this.byoYomiTotal15);
		box14.add(this.byoYomiTotal20);
		Box box15 = Box.createVerticalBox();
		box15.add(Box.createVerticalGlue());
		box15.add(Box.createVerticalGlue());
		box15.add(box13);
		box15.add(Box.createVerticalGlue());
		box15.add(box14);
		box15.add(Box.createVerticalGlue());
		box15.add(Box.createVerticalGlue());

		Box box16 = Box.createHorizontalBox();
		box16.add(new JLabel("Byo-Yomi Period Time (sec)"));
		Box box17 = Box.createHorizontalBox();
		box17.add(this.byoYomiPeriod10);
		box17.add(this.byoYomiPeriod20);
		box17.add(this.byoYomiPeriod30);
		Box box18 = Box.createVerticalBox();
		box18.add(Box.createVerticalGlue());
		box18.add(Box.createVerticalGlue());
		box18.add(box16);
		box18.add(Box.createVerticalGlue());
		box18.add(box17);
		box18.add(Box.createVerticalGlue());
		box18.add(Box.createVerticalGlue());

		Box box19 = Box.createHorizontalBox();
		box19.add(new JLabel("Byo-Yomi Period Amount"));
		Box box20 = Box.createHorizontalBox();
		box20.add(this.byoYomiAmount1);
		box20.add(this.byoYomiAmount2);
		box20.add(this.byoYomiAmount3);
		box20.add(this.byoYomiAmount4);
		box20.add(this.byoYomiAmount5);
		Box box21 = Box.createVerticalBox();
		box21.add(Box.createVerticalGlue());
		box21.add(Box.createVerticalGlue());
		box21.add(box19);
		box21.add(Box.createVerticalGlue());
		box21.add(box20);
		box21.add(Box.createVerticalGlue());
		box21.add(Box.createVerticalGlue());

		Box box22 = Box.createHorizontalBox();
		box22.add(Box.createHorizontalGlue());
		box22.add(Box.createHorizontalGlue());
		box22.add(box15);
		box22.add(Box.createHorizontalGlue());
		box22.add(box21);
		box22.add(Box.createHorizontalGlue());
		box22.add(box18);
		box22.add(Box.createHorizontalGlue());
		box22.add(Box.createHorizontalGlue());

		Box box23 = Box.createHorizontalBox();
		box23.add(Box.createHorizontalGlue());
		box23.add(Box.createHorizontalGlue());
		box23.add(this.back);
		box23.add(Box.createHorizontalGlue());
		box23.add(this.save);
		box23.add(Box.createHorizontalGlue());
		box23.add(Box.createHorizontalGlue());

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(box3);
		this.add(Box.createVerticalGlue());
		this.add(box9);
		this.add(Box.createVerticalGlue());
		this.add(box6);
		this.add(Box.createVerticalGlue());
		this.add(box12);
		this.add(Box.createVerticalGlue());
		this.add(box22);
		this.add(Box.createVerticalGlue());
		this.add(box23);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());

		this.save.addActionListener(control);
		this.back.addActionListener(control);
		this.size19.addMouseListener(control);
		this.size13.addMouseListener(control);
		this.size9.addMouseListener(control);
		this.noneWatch.addMouseListener(control);
		this.absoluteWatch.addMouseListener(control);
		this.byoYomiWatch.addMouseListener(control);
	}

	public JRadioButton getByoYomiAmount1() {
		return this.byoYomiAmount1;
	}
	public JRadioButton getByoYomiAmount2() {
		return this.byoYomiAmount2;
	}
	public JRadioButton getByoYomiAmount3() {
		return this.byoYomiAmount3;
	}
	public JRadioButton getByoYomiAmount4() {
		return this.byoYomiAmount4;
	}
	public JRadioButton getByoYomiAmount5() {
		return this.byoYomiAmount5;
	}
	public JRadioButton getByoYomiPeriod10() {
		return this.byoYomiPeriod10;
	}
	public JRadioButton getByoYomiPeriod20() {
		return this.byoYomiPeriod20;
	}
	public JRadioButton getByoYomiPeriod30() {
		return this.byoYomiPeriod30;
	}
	public JRadioButton getByoYomiTotal3() {
		return this.byoYomiTotal3;
	}
	public JRadioButton getByoYomiTotal5() {
		return this.byoYomiTotal5;
	}
	public JRadioButton getByoYomiTotal10() {
		return this.byoYomiTotal10;
	}
	public JRadioButton getByoYomiTotal15() {
		return this.byoYomiTotal15;
	}
	public JRadioButton getByoYomiTotal20() {
		return this.byoYomiTotal20;
	}
	public JRadioButton getDelay10() {
		return this.delay10;
	}
	public JRadioButton getDelay20() {
		return this.delay20;
	}
	public JRadioButton getDelay30() {
		return this.delay30;
	}
	public JRadioButton getDelay60() {
		return this.delay60;
	}
	public JRadioButton getDelay120() {
		return this.delay120;
	}
	public JRadioButton getDelay180() {
		return this.delay180;
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
