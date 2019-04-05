import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class Goban extends JPanel {
	private int size;
	private int caseSize;

	public Goban() {
		this.size = 19;
		this.caseSize = 20;
		this.setBackground(Color.ORANGE);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.size; i += 1) {
			g.drawLine(i*this.caseSize, 0, i*this.caseSize, (this.size-1)*this.caseSize);
			g.drawLine(0, i*this.caseSize, (this.size-1)*this.caseSize, i*this.caseSize);
			g.fillOval(50, 50, 50, 50);
		}
	}
}