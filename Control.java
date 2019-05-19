import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

public class Control implements MouseMotionListener, MouseListener, ActionListener {
	private MyFrame myFrame;
	private Menu menu;
	private Option option;
	private Goban goban;
	private Click click;

	public Control() {
		this.myFrame = new MyFrame();
		this.menu = new Menu(this);
		this.option = new Option(this);
		Parameter parameter = null;
		try {
			parameter = new Parameter(19, Watch.NONE);
		}
		catch (SizeException sizeException) {
			sizeException.printStackTrace();
		}
		Go go = new Go(parameter);
		this.goban = new Goban(this, go);
		this.addMenu();
		this.myFrame.setVisible(true);
	}

	public void addMenu() {
		this.myFrame.setContentPane(this.menu);
		this.menu.setOpaque(true);
		this.myFrame.validate();
	}
	public void addOption() {
		this.myFrame.setContentPane(this.option);
		this.option.setOpaque(true);
		this.myFrame.validate();
	}
	public void addGoban() {
		this.myFrame.setContentPane(this.goban);
		this.option.setOpaque(true);
		this.myFrame.validate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.menu.getQuit())
			this.myFrame.dispose();
		else if (e.getSource() == this.menu.getOption())
			this.addOption();
		else if (e.getSource() == this.menu.getStart())
			this.addGoban();

		else if (e.getSource() == this.option.getSave() &&
			(this.option.getNoneWatch().isSelected() || this.option.getAbsoluteWatch().isSelected() || this.option.getByoYomiWatch().isSelected()) &&
			(this.option.getSize9().isSelected() || this.option.getSize13().isSelected() || this.option.getSize19().isSelected())) {
			
			if (this.option.getSize9().isSelected())
				this.goban.getGo().getParameter().setSize(9);
			else if (this.option.getSize13().isSelected())
				this.goban.getGo().getParameter().setSize(13);
			else 
				this.goban.getGo().getParameter().setSize(19);
			if (this.option.getNoneWatch().isSelected())
				this.goban.getGo().getParameter().setWatch(Watch.NONE);
			else if (this.option.getAbsoluteWatch().isSelected())
				this.goban.getGo().getParameter().setWatch(Watch.ABSOLUTE);
			else 
				this.goban.getGo().getParameter().setWatch(Watch.BYO_YOMI);
		}
		
		else if (e.getSource() == this.option.getBack())
			this.addMenu();
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			this.click = Click.LEFT;
		else if (e.getButton() == MouseEvent.BUTTON2)
			this.click = Click.SCROLL;
		else if (e.getButton() == MouseEvent.BUTTON3)
			this.click = Click.RIGHT;
	}

	public void mouseClicked(MouseEvent e) {
		if (this.click == Click.LEFT) {
			int caseSize = this.goban.getGo().getParameter().getCaseSize();
			int marge = this.goban.getGo().getParameter().getMarge();

			int x = (e.getX()-marge+caseSize/2)/caseSize;
			int y = (e.getY()-marge+caseSize/2)/caseSize;

			if (this.goban.getGo().inGoban(x, y)) {
				this.goban.getGo().getGoban()[y][x] = this.goban.getGo().getTurn() == Player.WHITE ? Player.WHITE : Player.BLACK;
				this.goban.repaint();
			}
		}
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
