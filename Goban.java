import javax.swing.JPanel;
import java.awt.Graphics;
// import java.awt.Color;

class Goban extends JPanel {
	private Go go;

	public Goban(Go go) {
		// this.setBackground(Color.ORANGE);
		this.go = go;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.go.getParameter().getSize(); i += 1) {
			g.drawLine(i*go.getParameter().getCaseSize(), 0, i*go.getParameter().getCaseSize(), (this.go.getParameter().getSize()-1)*go.getParameter().getCaseSize());
			g.drawLine(0, i*go.getParameter().getCaseSize(), (this.go.getParameter().getSize()-1)*go.getParameter().getCaseSize(), i*go.getParameter().getCaseSize());
		}

		for (int i = 0; i < this.go.getParameter().getSize(); i += 1) {
			for (int j = 0; j < this.go.getParameter().getSize(); j += 1) {
				if (this.go.getGoban()[i][j] != null) {
					if (this.go.getGoban()[i][j] == Color.BLACK) {
						int y = i*go.getParameter().getCaseSize() - go.getParameter().getCaseSize()/2;
						int x = j*go.getParameter().getCaseSize() - go.getParameter().getCaseSize()/2;
						g.fillOval(x, y, go.getParameter().getCaseSize(), go.getParameter().getCaseSize());
					}
					if (this.go.getGoban()[i][j] == Color.WHITE) {
						int y = i*go.getParameter().getCaseSize() - go.getParameter().getCaseSize()/2;
						int x = j*go.getParameter().getCaseSize() - go.getParameter().getCaseSize()/2;
						g.fillOval(x, y, go.getParameter().getCaseSize(), go.getParameter().getCaseSize());
					}
				}
			}
		}
	}
}
