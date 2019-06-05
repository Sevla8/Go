import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

public class Control implements MouseListener, ActionListener {
	private MyFrame myFrame;
	private Menu menu;
	private Option option;
	private Goban goban;
	private Click click;
	private GameOver gameOver;

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

	private void addMenu() {
		this.myFrame.setContentPane(this.menu);
		this.menu.setOpaque(true);
		this.myFrame.validate();
	}
	private void addOption() {
		this.myFrame.setContentPane(this.option);
		this.option.setOpaque(true);
		this.myFrame.validate();
	}
	private void addGoban() {
		this.myFrame.setContentPane(this.goban);
		this.option.setOpaque(true);
		this.myFrame.validate();
	}
	private void addGameOver(Player player, double blackScore, double whiteScore) {
		this.gameOver = new GameOver(this, player, blackScore, whiteScore);
		this.myFrame.setContentPane(this.gameOver);
		this.gameOver.setOpaque(true);
		this.myFrame.validate();
	}

	private void actualiseInformation() {
		if (this.goban.getBoard().getGo().getGameOver()) {
			this.goban.getInformation().getGameOver().setText("Game : Over");
			this.goban.getInformation().getSkip().setEnabled(false);
			this.goban.getInformation().getGetWinner().setEnabled(true);
		}
		else {
			this.goban.getInformation().getGameOver().setText("Game : In Progress");
			this.goban.getInformation().getSkip().setEnabled(true);
			this.goban.getInformation().getGetWinner().setEnabled(false);
		}
		if (this.goban.getBoard().getGo().getBlackSkip())
			this.goban.getInformation().getBlackSkip().setText("Black Skip : Skipped");
		else 
			this.goban.getInformation().getBlackSkip().setText("Black Skip : None");
		if (this.goban.getBoard().getGo().getWhiteSkip())
			this.goban.getInformation().getWhiteSkip().setText("White Skip : Skipped");
		else 
			this.goban.getInformation().getWhiteSkip().setText("White Skip : None");
		this.goban.getInformation().getBlackPrisoner().setText("Black Prisoners : "+this.goban.getBoard().getGo().getBlackPrisoner());
		this.goban.getInformation().getWhitePrisoner().setText("White Prisoners : "+this.goban.getBoard().getGo().getWhitePrisoner());
		this.goban.getInformation().getTurn().setText("Turn : "+this.goban.getBoard().getGo().getTurn());
		if (this.goban.getBoard().getGo().getIndex() != 0)
			this.goban.getInformation().getUndo().setEnabled(true);
		else 
			this.goban.getInformation().getUndo().setEnabled(false);
		if (this.goban.getBoard().getGo().getHistoric().size()-1 != this.goban.getBoard().getGo().getIndex())
			this.goban.getInformation().getRedo().setEnabled(true);
		else 
			this.goban.getInformation().getRedo().setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		// menu
		if (e.getSource() == this.menu.getQuit()) {	// menu/quit
			this.myFrame.dispose();
		}
		else if (e.getSource() == this.menu.getOption()) {	// menu/option
			this.addOption();
			if (this.goban.getBoard().getGo().getParameter().getSize() == 19)
				this.option.getSize19().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getSize() == 13) {
				this.option.getSize13().setSelected(true);
				this.option.getKomi6().setEnabled(false);
				this.option.getKomi7().setEnabled(false);
				this.option.getKomi8().setEnabled(false);
				this.option.getKomi9().setEnabled(false);
			}
			else {
				this.option.getSize9().setSelected(true);
				this.option.getKomi6().setEnabled(false);
				this.option.getKomi7().setEnabled(false);
				this.option.getKomi8().setEnabled(false);
				this.option.getKomi9().setEnabled(false);
			}
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
		else if (e.getSource() == this.menu.getStart()) {	// menu/start
			this.goban = new Goban(this, this.goban.getBoard().getGo());
			this.goban.getBoard().setGo(new Go(this.goban.getBoard().getGo().getParameter()));
			this.addGoban();
		}
		// options
		else if (e.getSource() == this.option.getSave()) {	// option/save
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
		else if (e.getSource() == this.option.getBack()) {	// option/back
			this.addMenu();
		}
		// game
		else if (e.getSource() == this.goban.getInformation().getSkip()) {	// game/skip
			this.goban.getBoard().getGo().skip();
			this.actualiseInformation();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getGiveUp()) {	// game/giveUp
			this.goban.getBoard().getGo().giveUp();
			this.addGameOver(this.goban.getBoard().getGo().getWinner(), 0, 0);
		}
		else if (e.getSource() == this.goban.getInformation().getUndo()) {	// game/undo
			this.goban.getBoard().getGo().undo();
			this.actualiseInformation();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getRedo()) {	// game/redo
			this.goban.getBoard().getGo().redo();
			this.actualiseInformation();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getGetWinner()) {	// makeWinner
			this.goban.getBoard().getGo().makeWinner();
			this.addGameOver(this.goban.getBoard().getGo().getWinner(), this.goban.getBoard().getGo().getBlackScore(), this.goban.getBoard().getGo().getWhiteScore());
		}
		// gameOver
		else if (e.getSource() == this.gameOver.getMenu()) {
			this.addMenu();
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
			// options
			if (e.getSource() == this.option.getSize19()) {	// option/size19
				this.option.getKomi6().setEnabled(true);
				this.option.getKomi7().setEnabled(true);
				this.option.getKomi8().setEnabled(true);
				this.option.getKomi9().setEnabled(true);
			}
			else if (e.getSource() == this.option.getSize13()) {	// option/size13
				this.option.getKomi6().setEnabled(false);
				this.option.getKomi7().setEnabled(false);
				this.option.getKomi8().setEnabled(false);
				this.option.getKomi9().setEnabled(false);
			}
			else if (e.getSource() == this.option.getSize9()) {	// option/size9
				this.option.getKomi6().setEnabled(false);
				this.option.getKomi7().setEnabled(false);
				this.option.getKomi8().setEnabled(false);
				this.option.getKomi9().setEnabled(false);
			}
			// game
			else if (e.getSource() == this.goban.getBoard()) {	// game/board
				int size = this.goban.getBoard().getGo().getParameter().getSize();
				int min = this.goban.getBoard().getWidth() < this.goban.getBoard().getHeight() ? this.goban.getBoard().getWidth() : this.goban.getBoard().getHeight();
				int caseSize = min/(size+1);
				int marge = caseSize;
				int margeWidth = (this.goban.getBoard().getWidth()-min)/2+marge;
				int margeHeight = (this.goban.getBoard().getHeight()-min)/2+marge;

				int x = (e.getX()-margeWidth+caseSize/2)/caseSize;
				int y = (e.getY()-margeHeight+caseSize/2)/caseSize;

				this.goban.getBoard().getGo().control(x, y);
				this.actualiseInformation();
				this.goban.getBoard().repaint();
			}
		}
	}

	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public MyFrame getMyFrame() {
		return this.myFrame;
	}
}
