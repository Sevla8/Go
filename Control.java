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
		Parameter parameter = new Parameter();
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
		else if (e.getSource() == this.menu.getOption()) {
			this.addOption();
			if (this.goban.getBoard().getGo().getParameter().getSize() == 19)
				this.option.getSize19().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getSize() == 13)
				this.option.getSize13().setSelected(true);
			else
				this.option.getSize9().setSelected(true);
			if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.NONE)
				this.option.getNoneWatch().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE)
				this.option.getAbsoluteWatch().setSelected(true);
			else
				this.option.getByoYomiWatch().setSelected(true);
			if (this.goban.getBoard().getGo().getParameter().getKomi() == 0)
				this.option.getKomi0().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 1)
				this.option.getKomi1().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 2)
				this.option.getKomi2().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 3)
				this.option.getKomi3().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 4)
				this.option.getKomi4().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 5)
				this.option.getKomi5().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 6)
				this.option.getKomi6().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 7)
				this.option.getKomi7().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getKomi() == 8)
				this.option.getKomi8().setSelected(true);
			else 
				this.option.getKomi9().setSelected(true);
		}
		else if (e.getSource() == this.menu.getStart())
			this.addGoban();

		else if (e.getSource() == this.option.getSave()) {
			if (this.option.getSize9().isSelected())
				this.goban.getBoard().getGo().getParameter().setSize(9);
			else if (this.option.getSize13().isSelected())
				this.goban.getBoard().getGo().getParameter().setSize(13);
			else 
				this.goban.getBoard().getGo().getParameter().setSize(19);
			if (this.option.getNoneWatch().isSelected())
				this.goban.getBoard().getGo().getParameter().setWatch(Watch.NONE);
			else if (this.option.getAbsoluteWatch().isSelected())
				this.goban.getBoard().getGo().getParameter().setWatch(Watch.ABSOLUTE);
			else 
				this.goban.getBoard().getGo().getParameter().setWatch(Watch.BYO_YOMI);
			if (this.option.getKomi0().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(0);
			else if (this.option.getKomi1().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(1);
			else if (this.option.getKomi2().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(2);
			else if (this.option.getKomi3().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(3);
			else if (this.option.getKomi4().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(4);
			else if (this.option.getKomi5().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(5);
			else if (this.option.getKomi6().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(6);
			else if (this.option.getKomi7().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(7);
			else if (this.option.getKomi8().isSelected())
				this.goban.getBoard().getGo().getParameter().setKomi(8);
			else 
				this.goban.getBoard().getGo().getParameter().setKomi(9);
			this.addMenu();
		}
		else if (e.getSource() == this.option.getBack())
			this.addMenu();

		else if (e.getSource() == this.goban.getSkip())
			this.goban.getBoard().getGo().skip();
		else if (e.getSource() == this.goban.getGiveUp())
			this.goban.getBoard().getGo().giveUp();
		else if (e.getSource() == this.goban.getUndo()) {
			System.out.println("hererererre");
			this.goban.getBoard().getGo().undo();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getRedo()) {
			this.goban.getBoard().getGo().redo();
			this.goban.getBoard().repaint();
		}
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
			int caseSize = this.goban.getBoard().getGo().getParameter().getCaseSize();
			int marge = this.goban.getBoard().getGo().getParameter().getMarge();

			int x = (e.getX()-marge+caseSize/2)/caseSize;
			int y = (e.getY()-marge+caseSize/2)/caseSize;

			this.goban.getBoard().getGo().play(x, y);
			this.goban.getBlackPrisoner().setText("Black Prisoners : "+this.goban.getBoard().getGo().getBlackPrisoner());
			this.goban.getWhitePrisoner().setText("White Prisoners : "+this.goban.getBoard().getGo().getWhitePrisoner());
			this.goban.getBoard().repaint();
		}
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
