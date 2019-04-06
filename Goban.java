import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class Goban extends JPanel {
	private Go go;

	public Goban(Go go) {
		this.setBackground(Color.ORANGE);
		this.go = go;
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
					g.setColor(Color.BLACK);
					if (this.go.getGoban()[i][j] == Player.BLACK) 
						g.fillOval(j*caseSize-caseSize/2+marge, i*caseSize-caseSize/2+marge, caseSize, caseSize);
					g.setColor(Color.WHITE);
					if (this.go.getGoban()[i][j] == Player.WHITE)
						g.fillOval(j*caseSize-caseSize/2+marge, i*caseSize-caseSize/2+marge, caseSize, caseSize);
				}
			}
		}
	}
}
