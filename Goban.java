import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;

class Goban extends JPanel {
	private Go go;

	public Goban(Control control, Go go) {
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
