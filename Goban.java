import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

class Goban extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
	private Go go;
	private Click click;

	public Goban(Go go) {
		this.setBackground(Color.ORANGE);
		this.go = go;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = this.go.getParameter().getSize();
		int caseSize = this.go.getParameter().getCaseSize();
		int marge = this.go.getParameter().getMarge();

		g.setColor(Color.GRAY);
		for (int i = 0; i < size; i += 1) {
			g.drawLine(i*caseSize+marge, 0+marge, i*caseSize+marge, (size-1)*caseSize+marge);
			g.drawLine(0+marge, i*caseSize+marge, (size-1)*caseSize+marge, i*caseSize+marge);
		}

		for (int i = 0; i < size; i += 1) {
			for (int j = 0; j < size; j += 1) {
				if (this.go.getGoban()[i][j] != null) {
					if (this.go.getGoban()[i][j] == Player.BLACK) {
						g.setColor(Color.BLACK);
						g.fillOval(j*caseSize-caseSize/2+marge, i*caseSize-caseSize/2+marge, caseSize, caseSize);
					}
					if (this.go.getGoban()[i][j] == Player.WHITE) {
						g.setColor(Color.WHITE);
						g.fillOval(j*caseSize-caseSize/2+marge, i*caseSize-caseSize/2+marge, caseSize, caseSize);
					}
				}
			}
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
			int caseSize = this.go.getParameter().getCaseSize();
			int marge = this.go.getParameter().getMarge();

			int x = (e.getX()-marge+caseSize/2)/caseSize;
			int y = (e.getY()-marge+caseSize/2)/caseSize;

			if (this.go.inGoban(x, y)) {
				this.go.getGoban()[y][x] = this.go.getTurn() == Player.WHITE ? Player.WHITE : Player.BLACK;
				this.repaint();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public Go getGo() {
		return this.go;
	}
	public Click getClick() {
		return this.click;
	}
}
