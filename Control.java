import javax.swing.Timer;
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
	private Timer timerDelay;
	private Timer timerSecond;
	private int periodAmountBlack;
	private int periodAmountWhite;
	private boolean lackOfTimeBlack;
	private boolean lackOfTimeWhite;
	private int minuteTotalBlack;
	private int secondTotalBlack;
	private int minuteTotalWhite;
	private int secondTotalWhite;
	private int minute;
	private int second;

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
		if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE) {
			this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getDelay()*1000, this);
			this.timerDelay.setRepeats(false);
			this.timerSecond = new Timer(1000, this);
			this.timerSecond.setRepeats(true);
			this.minute = this.goban.getBoard().getGo().getParameter().getDelay()/60;
			this.second = this.goban.getBoard().getGo().getParameter().getDelay()%60;
			this.timerDelay.start();
			this.timerSecond.start();
		}
		else if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.BYO_YOMI) {
			this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getByoYomiTotal()*1000*60, this);
			this.timerDelay.setRepeats(false);
			this.periodAmountBlack = this.goban.getBoard().getGo().getParameter().getByoYomiAmount();
			this.lackOfTimeBlack = false;
			this.periodAmountWhite = this.goban.getBoard().getGo().getParameter().getByoYomiAmount();
			this.lackOfTimeWhite = false;
			this.minuteTotalBlack = this.goban.getBoard().getGo().getParameter().getByoYomiTotal();
			this.secondTotalBlack = 0;
			this.minuteTotalWhite = this.goban.getBoard().getGo().getParameter().getByoYomiTotal();
			this.secondTotalWhite = 0;
			this.timerSecond = new Timer(1000, this);
			this.timerSecond.setRepeats(true);
			this.minute = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()/60;
			this.second = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()%60;
			this.timerDelay.start();
			this.timerSecond.start();
		}
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
	private void actualiseTimer() {
		if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE && !this.goban.getBoard().getGo().getGameOver()) {
			this.minute = this.goban.getBoard().getGo().getParameter().getDelay()/60;
			this.second = this.goban.getBoard().getGo().getParameter().getDelay()%60;
			this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second);
			this.timerDelay.restart();
			this.timerSecond.restart();
		}
		else if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.BYO_YOMI && !this.goban.getBoard().getGo().getGameOver()) {
			this.minute = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()/60;
			this.second = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()%60;
			this.timerDelay.stop();
			if (this.goban.getBoard().getGo().getTurn() == Player.BLACK) {
				if (this.lackOfTimeBlack) {
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountBlack);
					this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()*1000, this);
				}
				else {
					this.goban.getInformation().getWatch().setText("Time : "+this.minuteTotalBlack+":"+this.secondTotalBlack);
					this.timerDelay = new Timer((this.minuteTotalBlack*60+this.secondTotalBlack)*1000, this);
				}
			}
			else {
				if (this.lackOfTimeWhite) {
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountWhite);
					this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()*1000, this);
				}
				else  {
					this.goban.getInformation().getWatch().setText("Time : "+this.minuteTotalWhite+":"+this.secondTotalWhite);
					this.timerDelay = new Timer((this.minuteTotalWhite*60+this.secondTotalWhite)*1000, this);
				}
			}
			this.timerDelay.setRepeats(false);
			this.timerDelay.start();
			this.timerSecond.restart();
		}
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
			if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.NONE) {
				this.option.getNoneWatch().setSelected(true);
				this.option.getDelay10().setEnabled(false);
				this.option.getDelay20().setEnabled(false);
				this.option.getDelay30().setEnabled(false);
				this.option.getDelay60().setEnabled(false);
				this.option.getDelay120().setEnabled(false);
				this.option.getDelay180().setEnabled(false);
				this.option.getByoYomiTotal5().setEnabled(false);
				this.option.getByoYomiTotal10().setEnabled(false);
				this.option.getByoYomiTotal15().setEnabled(false);
				this.option.getByoYomiTotal20().setEnabled(false);
				this.option.getByoYomiTotal30().setEnabled(false);
				this.option.getByoYomiPeriod10().setEnabled(false);
				this.option.getByoYomiPeriod20().setEnabled(false);
				this.option.getByoYomiPeriod30().setEnabled(false);
				this.option.getByoYomiAmount1().setEnabled(false);
				this.option.getByoYomiAmount2().setEnabled(false);
				this.option.getByoYomiAmount3().setEnabled(false);
				this.option.getByoYomiAmount4().setEnabled(false);
				this.option.getByoYomiAmount5().setEnabled(false);
			}
			else if (this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE) {
				this.option.getAbsoluteWatch().setSelected(true);
				this.option.getDelay10().setEnabled(true);
				this.option.getDelay20().setEnabled(true);
				this.option.getDelay30().setEnabled(true);
				this.option.getDelay60().setEnabled(true);
				this.option.getDelay120().setEnabled(true);
				this.option.getDelay180().setEnabled(true);
				this.option.getByoYomiTotal5().setEnabled(false);
				this.option.getByoYomiTotal10().setEnabled(false);
				this.option.getByoYomiTotal15().setEnabled(false);
				this.option.getByoYomiTotal20().setEnabled(false);
				this.option.getByoYomiTotal30().setEnabled(false);
				this.option.getByoYomiPeriod10().setEnabled(false);
				this.option.getByoYomiPeriod20().setEnabled(false);
				this.option.getByoYomiPeriod30().setEnabled(false);
				this.option.getByoYomiAmount1().setEnabled(false);
				this.option.getByoYomiAmount2().setEnabled(false);
				this.option.getByoYomiAmount3().setEnabled(false);
				this.option.getByoYomiAmount4().setEnabled(false);
				this.option.getByoYomiAmount5().setEnabled(false);
			}
			else {
				this.option.getByoYomiWatch().setSelected(true);
				this.option.getDelay10().setEnabled(false);
				this.option.getDelay20().setEnabled(false);
				this.option.getDelay30().setEnabled(false);
				this.option.getDelay60().setEnabled(false);
				this.option.getDelay120().setEnabled(false);
				this.option.getDelay180().setEnabled(false);
				this.option.getByoYomiTotal5().setEnabled(true);
				this.option.getByoYomiTotal10().setEnabled(true);
				this.option.getByoYomiTotal15().setEnabled(true);
				this.option.getByoYomiTotal20().setEnabled(true);
				this.option.getByoYomiTotal30().setEnabled(true);
				this.option.getByoYomiPeriod10().setEnabled(true);
				this.option.getByoYomiPeriod20().setEnabled(true);
				this.option.getByoYomiPeriod30().setEnabled(true);
				this.option.getByoYomiAmount1().setEnabled(true);
				this.option.getByoYomiAmount2().setEnabled(true);
				this.option.getByoYomiAmount3().setEnabled(true);
				this.option.getByoYomiAmount4().setEnabled(true);
				this.option.getByoYomiAmount5().setEnabled(true);
			}
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
			if (this.goban.getBoard().getGo().getParameter().getDelay() == 10)
				this.option.getDelay10().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getDelay() == 20)
				this.option.getDelay20().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getDelay() == 30)
				this.option.getDelay30().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getDelay() == 60)
				this.option.getDelay60().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getDelay() == 120)
				this.option.getDelay120().setSelected(true);
			else
				this.option.getDelay180().setSelected(true);
			if (this.goban.getBoard().getGo().getParameter().getByoYomiTotal() == 5)
				this.option.getByoYomiTotal5().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiTotal() == 10)
				this.option.getByoYomiTotal10().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiTotal() == 15)
				this.option.getByoYomiTotal15().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiTotal() == 20)
				this.option.getByoYomiTotal20().setSelected(true);
			else
				this.option.getByoYomiTotal30().setSelected(true);
			if (this.goban.getBoard().getGo().getParameter().getByoYomiPeriod() == 10)
				this.option.getByoYomiPeriod10().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiPeriod() == 20)
				this.option.getByoYomiPeriod20().setSelected(true);
			else 
				this.option.getByoYomiPeriod30().setSelected(true);
			if (this.goban.getBoard().getGo().getParameter().getByoYomiAmount() == 1)
				this.option.getByoYomiAmount1().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiAmount() == 2)
				this.option.getByoYomiAmount2().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiAmount() == 3)
				this.option.getByoYomiAmount3().setSelected(true);
			else if (this.goban.getBoard().getGo().getParameter().getByoYomiAmount() == 4)
				this.option.getByoYomiAmount4().setSelected(true);
			else
				this.option.getByoYomiAmount5().setSelected(true);
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
			if (this.option.getDelay10().isSelected())
				this.goban.getBoard().getGo().getParameter().setDelay(10);
			else if (this.option.getDelay20().isSelected())
				this.goban.getBoard().getGo().getParameter().setDelay(20);
			else if (this.option.getDelay30().isSelected())
				this.goban.getBoard().getGo().getParameter().setDelay(30);
			else if (this.option.getDelay60().isSelected())
				this.goban.getBoard().getGo().getParameter().setDelay(60);
			else if (this.option.getDelay120().isSelected())
				this.goban.getBoard().getGo().getParameter().setDelay(120);
			else 
				this.goban.getBoard().getGo().getParameter().setDelay(180);
			if (this.option.getByoYomiTotal5().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiTotal(5);
			else if (this.option.getByoYomiTotal10().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiTotal(10);
			else if (this.option.getByoYomiTotal15().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiTotal(15);
			else if (this.option.getByoYomiTotal20().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiTotal(20);
			else 
				this.goban.getBoard().getGo().getParameter().setByoYomiTotal(30);
			if (this.option.getByoYomiPeriod10().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiPeriod(10);
			else if (this.option.getByoYomiPeriod20().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiPeriod(20);
			else
				this.goban.getBoard().getGo().getParameter().setByoYomiPeriod(30);
			if (this.option.getByoYomiAmount1().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiAmount(1);
			else if (this.option.getByoYomiAmount2().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiAmount(2);
			else if (this.option.getByoYomiAmount3().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiAmount(3);
			else if (this.option.getByoYomiAmount4().isSelected())
				this.goban.getBoard().getGo().getParameter().setByoYomiAmount(4);
			else
				this.goban.getBoard().getGo().getParameter().setByoYomiAmount(5);	
			this.addMenu();
		}
		else if (e.getSource() == this.option.getBack()) {	// option/back
			this.addMenu();
		}
		// game
		else if (e.getSource() == this.goban.getInformation().getSkip()) {	// game/skip
			this.goban.getBoard().getGo().skip();
			this.actualiseInformation();
			this.actualiseTimer();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getGiveUp()) {	// game/giveUp
			this.goban.getBoard().getGo().giveUp();
			this.addGameOver(this.goban.getBoard().getGo().getWinner(), 0, 0);
		}
		else if (e.getSource() == this.goban.getInformation().getUndo()) {	// game/undo
			this.goban.getBoard().getGo().undo();
			this.actualiseInformation();
			this.actualiseTimer();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getRedo()) {	// game/redo
			this.goban.getBoard().getGo().redo();
			this.actualiseInformation();
			this.actualiseTimer();
			this.goban.getBoard().repaint();
		}
		else if (e.getSource() == this.goban.getInformation().getGetWinner()) {	// makeWinner
			this.goban.getBoard().getGo().makeWinner();
			this.addGameOver(this.goban.getBoard().getGo().getWinner(), this.goban.getBoard().getGo().getBlackScore(), this.goban.getBoard().getGo().getWhiteScore());
		}
		else if (this.timerDelay != null && e.getSource() == this.timerDelay && this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE && !this.goban.getBoard().getGo().getGameOver()) {
			this.goban.getBoard().getGo().giveUp();
			this.timerSecond.stop();
			this.timerDelay.stop();
			this.addGameOver(this.goban.getBoard().getGo().getWinner(), 0, 0);
		}
		else if (this.timerSecond != null && e.getSource() == this.timerSecond && this.goban.getBoard().getGo().getParameter().getWatch() == Watch.ABSOLUTE && !this.goban.getBoard().getGo().getGameOver()) {
			this.second -= 1;
			if (this.second == -1) {
				this.second = 59;
				this.minute -= 1;
			}
			this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second);
		}
		else if (this.timerDelay != null && e.getSource() == this.timerDelay && this.goban.getBoard().getGo().getParameter().getWatch() == Watch.BYO_YOMI && !this.goban.getBoard().getGo().getGameOver()) {
			if (this.goban.getBoard().getGo().getTurn() == Player.BLACK) {
				if (this.lackOfTimeBlack) {
					this.periodAmountBlack -= 1;
					if (this.periodAmountBlack == 0) {
						this.goban.getBoard().getGo().giveUp();
						this.timerDelay.stop();
						this.timerSecond.stop();
						this.addGameOver(this.goban.getBoard().getGo().getWinner(), 0, 0);
					}
					else {
						this.minute = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()/60;
						this.second = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()%60;
						this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountBlack);
						this.timerDelay.restart();
					}
				}
				else {
					this.lackOfTimeBlack = true;
					this.timerDelay.stop();
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountBlack);
					this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()*1000, this);
					this.timerDelay.setRepeats(false);
					this.timerDelay.start();
				}
				this.timerSecond.restart();
			}
			else {
				if (this.lackOfTimeWhite) {
					this.periodAmountWhite -= 1;
					if (this.periodAmountWhite == 0) {
						this.goban.getBoard().getGo().giveUp();
						this.timerDelay.stop();
						this.timerSecond.stop();
						this.addGameOver(this.goban.getBoard().getGo().getWinner(), 0, 0);
					}
					else {
						this.minute = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()/60;
						this.second = this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()%60;
						this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountWhite);
						this.timerDelay.restart();
					}
				}
				else {
					this.lackOfTimeWhite = true;
					this.timerDelay.stop();
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountWhite);
					this.timerDelay = new Timer(this.goban.getBoard().getGo().getParameter().getByoYomiPeriod()*1000, this);
					this.timerDelay.setRepeats(false);
					this.timerDelay.start();
				}
				this.timerSecond.restart();
			}
		}
		else if (this.timerSecond != null && e.getSource() == this.timerSecond && this.goban.getBoard().getGo().getParameter().getWatch() == Watch.BYO_YOMI && !this.goban.getBoard().getGo().getGameOver()) {
			if (this.goban.getBoard().getGo().getTurn() == Player.BLACK) {
				if (!this.lackOfTimeBlack) {
					this.secondTotalBlack -= 1;
					if (this.secondTotalBlack == -1) {
						this.secondTotalBlack = 59;
						this.minuteTotalBlack -= 1;
					}
					this.goban.getInformation().getWatch().setText("Time : "+this.minuteTotalBlack+":"+this.secondTotalBlack);
				}
				else {
					this.second -= 1;
					if (this.second == -1) {
						this.second = 59;
						this.minute -= 1;
					}
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountBlack);
				}
			}
			else {
				if (!this.lackOfTimeWhite) {
					this.secondTotalWhite -= 1;
					if (this.secondTotalWhite == -1) {
						this.secondTotalWhite = 59;
						this.minuteTotalWhite -= 1;
					}
					this.goban.getInformation().getWatch().setText("Time : "+this.minuteTotalWhite+":"+this.secondTotalWhite);
				}
				else {
					this.second -= 1;
					if (this.second == -1) {
						this.second = 59;
						this.minute -= 1;
					}
					this.goban.getInformation().getWatch().setText("Time : "+this.minute+":"+this.second+" Byo-Yomi : "+this.periodAmountWhite);
				}
			}
		}
		// gameOver
		else if (this.gameOver != null && e.getSource() == this.gameOver.getMenu()) {
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
			else if (e.getSource() == this.option.getNoneWatch()) {	// option/noneWatch
				this.option.getDelay10().setEnabled(false);
				this.option.getDelay20().setEnabled(false);
				this.option.getDelay30().setEnabled(false);
				this.option.getDelay60().setEnabled(false);
				this.option.getDelay120().setEnabled(false);
				this.option.getDelay180().setEnabled(false);
				this.option.getByoYomiTotal5().setEnabled(false);
				this.option.getByoYomiTotal10().setEnabled(false);
				this.option.getByoYomiTotal15().setEnabled(false);
				this.option.getByoYomiTotal20().setEnabled(false);
				this.option.getByoYomiTotal30().setEnabled(false);
				this.option.getByoYomiPeriod10().setEnabled(false);
				this.option.getByoYomiPeriod20().setEnabled(false);
				this.option.getByoYomiPeriod30().setEnabled(false);
				this.option.getByoYomiAmount1().setEnabled(false);
				this.option.getByoYomiAmount2().setEnabled(false);
				this.option.getByoYomiAmount3().setEnabled(false);
				this.option.getByoYomiAmount4().setEnabled(false);
				this.option.getByoYomiAmount5().setEnabled(false);
			}
			else if (e.getSource() == this.option.getAbsoluteWatch()) {	// option/absoluteWatch
				this.option.getDelay10().setEnabled(true);
				this.option.getDelay20().setEnabled(true);
				this.option.getDelay30().setEnabled(true);
				this.option.getDelay60().setEnabled(true);
				this.option.getDelay120().setEnabled(true);
				this.option.getDelay180().setEnabled(true);
				this.option.getByoYomiTotal5().setEnabled(false);
				this.option.getByoYomiTotal10().setEnabled(false);
				this.option.getByoYomiTotal15().setEnabled(false);
				this.option.getByoYomiTotal20().setEnabled(false);
				this.option.getByoYomiTotal30().setEnabled(false);
				this.option.getByoYomiPeriod10().setEnabled(false);
				this.option.getByoYomiPeriod20().setEnabled(false);
				this.option.getByoYomiPeriod30().setEnabled(false);
				this.option.getByoYomiAmount1().setEnabled(false);
				this.option.getByoYomiAmount2().setEnabled(false);
				this.option.getByoYomiAmount3().setEnabled(false);
				this.option.getByoYomiAmount4().setEnabled(false);
				this.option.getByoYomiAmount5().setEnabled(false);
			}
			else if (e.getSource() == this.option.getByoYomiWatch()) {	// option/byoYomiWatch
				this.option.getDelay10().setEnabled(false);
				this.option.getDelay20().setEnabled(false);
				this.option.getDelay30().setEnabled(false);
				this.option.getDelay60().setEnabled(false);
				this.option.getDelay120().setEnabled(false);
				this.option.getDelay180().setEnabled(false);
				this.option.getByoYomiTotal5().setEnabled(true);
				this.option.getByoYomiTotal10().setEnabled(true);
				this.option.getByoYomiTotal15().setEnabled(true);
				this.option.getByoYomiTotal20().setEnabled(true);
				this.option.getByoYomiTotal30().setEnabled(true);
				this.option.getByoYomiPeriod10().setEnabled(true);
				this.option.getByoYomiPeriod20().setEnabled(true);
				this.option.getByoYomiPeriod30().setEnabled(true);
				this.option.getByoYomiAmount1().setEnabled(true);
				this.option.getByoYomiAmount2().setEnabled(true);
				this.option.getByoYomiAmount3().setEnabled(true);
				this.option.getByoYomiAmount4().setEnabled(true);
				this.option.getByoYomiAmount5().setEnabled(true);
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

				if (this.goban.getBoard().getGo().control(x, y)) {
					this.actualiseTimer();
					this.actualiseInformation();
					this.goban.getBoard().repaint();
				}

			}
		}
	}

	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
