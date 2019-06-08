import java.awt.Color;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class Information extends JPanel {
	private JLabel turn;
	private JLabel watch;
	private JButton skip;
	private JButton undo;
	private JButton redo;
	private JButton giveUp;
	private JLabel gameOver;
	private JLabel blackSkip;
	private JLabel whiteSkip;
	private JButton getWinner;
	private JLabel blackPrisoner;
	private JLabel whitePrisoner;

	public Information(Control control, Player turn) {
		this.setBackground(Color.LIGHT_GRAY);
		this.setMinimumSize(Define.informationMinimumSize);
		this.setPreferredSize(Define.infomationPreferredSize);

		this.turn = new JLabel("Turn : "+turn);
		this.watch = new JLabel("Time : 00:00");
		this.blackPrisoner = new JLabel("Black Prisoners : 0");
		this.whitePrisoner = new JLabel("White Prisoners : 0");
		this.gameOver = new JLabel("Game : In Progress");
		this.blackSkip = new JLabel("Black Skip : None");
		this.whiteSkip = new JLabel("White Skip : None");
		this.undo = new JButton("Undo");
		this.undo.setEnabled(false);
		this.redo = new JButton("Redo");
		this.redo.setEnabled(false);
		this.skip = new JButton("Skip");
		this.giveUp = new JButton("Give up");
		this.getWinner = new JButton("Get Winner");
		this.getWinner.setEnabled(false);
		this.undo.addActionListener(control);
		this.redo.addActionListener(control);
		this.skip.addActionListener(control);
		this.giveUp.addActionListener(control);
		this.getWinner.addActionListener(control);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(this.gameOver);
		this.add(Box.createVerticalGlue());
		this.add(this.watch);
		this.add(Box.createVerticalGlue());
		this.add(this.turn);
		this.add(Box.createVerticalGlue());
		this.add(this.blackSkip);
		this.add(Box.createVerticalGlue());
		this.add(this.whiteSkip);
		this.add(Box.createVerticalGlue());
		this.add(this.blackPrisoner);
		this.add(Box.createVerticalGlue());
		this.add(this.whitePrisoner);
		this.add(Box.createVerticalGlue());
		this.add(this.undo);
		this.add(Box.createVerticalGlue());
		this.add(this.redo);
		this.add(Box.createVerticalGlue());
		this.add(this.skip);
		this.add(Box.createVerticalGlue());
		this.add(this.getWinner);
		this.add(Box.createVerticalGlue());
		this.add(this.giveUp);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
	}

	public Information(Control control, Player turn, int delay) {
		this(control, turn);
		int minute = delay/60;
		int second = delay%60;
		this.watch.setText("Time : "+minute+":"+second);
	}

	public Information(Control control, Player turn, int total, boolean useless) {
		this(control, turn);
		this.watch.setText("Time : "+total+":00");
	}

	public void setWatch(JLabel watch) {
		this.watch = watch;
	}
	public JLabel getWatch() {
		return this.watch;
	}
	public JButton getSkip() {
		return this.skip;
	}
	public JButton getGiveUp() {
		return this.giveUp;
	}
	public JButton getUndo() {
		return this.undo;
	}
	public JButton getRedo() {
		return this.redo;
	}
	public JLabel getBlackPrisoner() {
		return this.blackPrisoner;
	}
	public JLabel getWhitePrisoner() {
		return this.whitePrisoner;
	}
	public JLabel getGameOver() {
		return this.gameOver;
	}
	public JLabel getBlackSkip() {
		return this.blackSkip;
	}
	public JLabel getWhiteSkip() {
		return this.whiteSkip;
	}
	public JLabel getTurn() {
		return this.turn;
	}
	public JButton getGetWinner() {
		return this.getWinner;
	}
}
