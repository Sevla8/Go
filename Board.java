import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;

class Board extends JPanel {
	private Go go;

	public Board(Control control, Go go) {
		this.setBackground(new Color(222, 184, 135));
		this.go = go;

		this.addMouseListener(control);

		this.setMinimumSize(Define.boardMinimumSize);
		this.setPreferredSize(Define.boardPreferredSize);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = this.go.getParameter().getSize();
		int min = this.getWidth() < this.getHeight() ? this.getWidth() : this.getHeight();
		int caseSize = min/(size+1);
		int marge = caseSize;
		int margeWidth = (this.getWidth()-min)/2+marge;
		int margeHeight = (this.getHeight()-min)/2+marge;
		int hoshi = Define.hoshiPrct;

		g.setColor(Color.GRAY);
		if (size == 19) {
			for (int i = 1; i <= 5; i += 2) {
				for (int j = 1; j <= 5; j += 2)
					g.fillOval(3*i*caseSize-caseSize/hoshi/2+margeWidth, 3*j*caseSize-caseSize/hoshi/2+margeHeight, caseSize/hoshi, caseSize/hoshi);
			}
		}
		else if (size == 13) {
			for (int i = 3; i <= 9; i *= 3) {
				for (int j = 3; j <= 9; j *= 3)
					g.fillOval(i*caseSize-caseSize/hoshi/2+margeWidth, j*caseSize-caseSize/hoshi/2+margeHeight, caseSize/hoshi, caseSize/hoshi);
			}
			g.fillOval(6*caseSize-caseSize/hoshi/2+margeWidth, 6*caseSize-caseSize/hoshi/2+margeHeight, caseSize/hoshi, caseSize/hoshi);
		}
		else {
			for (int i = 2; i <= 6; i *= 3) {
				for (int j = 2; j <= 6; j *= 3)
					g.fillOval(i*caseSize-caseSize/hoshi/2+margeWidth, j*caseSize-caseSize/hoshi/2+margeHeight, caseSize/hoshi, caseSize/hoshi);
			}
			g.fillOval(4*caseSize-caseSize/hoshi/2+margeWidth, 4*caseSize-caseSize/hoshi/2+margeHeight, caseSize/hoshi, caseSize/hoshi);
		}

		g.setColor(Color.GRAY);
		for (int i = 0; i < size; i += 1) {
			g.drawLine(i*caseSize+margeWidth, 0+margeHeight, i*caseSize+margeWidth, (size-1)*caseSize+margeHeight);
			g.drawLine(0+margeWidth, i*caseSize+margeHeight, (size-1)*caseSize+margeWidth, i*caseSize+margeHeight);
		}

		for (int i = 0; i < size; i += 1) {
			for (int j = 0; j < size; j += 1) {
				if (this.go.getGoban()[i][j] != null) {
					if (this.go.getGoban()[i][j] == Player.BLACK) {
						g.setColor(Color.BLACK);
						g.fillOval(j*caseSize-caseSize/2+margeWidth, i*caseSize-caseSize/2+margeHeight, caseSize, caseSize);
					}
					if (this.go.getGoban()[i][j] == Player.WHITE) {
						g.setColor(Color.WHITE);
						g.fillOval(j*caseSize-caseSize/2+margeWidth, i*caseSize-caseSize/2+margeHeight, caseSize, caseSize);
					}
				}
			}
		}
	}

	public Go getGo() {
		return this.go;
	}
	public void setGo(Go go) {
		this.go = go;
	}
}
