import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;

class Board extends JPanel {
	private Go go;

	public Board(Control control, Go go) {
		this.setBackground(Color.ORANGE);
		this.go = go;

		this.addMouseListener(control);
		this.addMouseMotionListener(control);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = this.go.getParameter().getSize();
		int caseSize = this.go.getParameter().getCaseSize();
		int marge = this.go.getParameter().getMarge();

		g.setColor(Color.GRAY);
		if (this.go.getParameter().getSize() == 19) {
			g.fillOval(3*caseSize-caseSize/10+marge, 3*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(3*caseSize-caseSize/10+marge, 9*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(3*caseSize-caseSize/10+marge, 15*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(9*caseSize-caseSize/10+marge, 3*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(9*caseSize-caseSize/10+marge, 9*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(9*caseSize-caseSize/10+marge, 15*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(15*caseSize-caseSize/10+marge, 3*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(15*caseSize-caseSize/10+marge, 9*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(15*caseSize-caseSize/10+marge, 15*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
		}
		else if (this.go.getParameter().getSize() == 13) {
			g.fillOval(3*caseSize-caseSize/10+marge, 3*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(3*caseSize-caseSize/10+marge, 9*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(9*caseSize-caseSize/10+marge, 3*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(9*caseSize-caseSize/10+marge, 9*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(6*caseSize-caseSize/10+marge, 6*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
		}
		else {
			g.fillOval(2*caseSize-caseSize/10+marge, 2*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(2*caseSize-caseSize/10+marge, 6*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(6*caseSize-caseSize/10+marge, 2*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(6*caseSize-caseSize/10+marge, 6*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
			g.fillOval(4*caseSize-caseSize/10+marge, 4*caseSize-caseSize/10+marge, caseSize/5, caseSize/5);
		}

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

	public Go getGo() {
		return this.go;
	}
}
