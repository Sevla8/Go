import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
	private Parameter parameter;
	private MyFrame myFrame;
	private Menu menu;
	private Option option;
	private Goban goban;

	public Control() {
		try {
			this.parameter = new Parameter(19, Watch.NONE);
		}
		catch (SizeException sizeException) {
			sizeException.printStackTrace();
		}
		this.myFrame = new MyFrame();
		this.myFrame.setVisible(true);

		this.addMenu();
	}

	public void addMenu() {
		this.menu = new Menu(this);
		this.myFrame.setContentPane(this.menu);
		this.menu.setOpaque(true);
	}
	public void addOption() {
		this.option = new Option(this);
		this.myFrame.setContentPane(this.option);
		this.option.setOpaque(true);
	}
	private void remove() {
		this.myFrame.getContentPane().removeAll();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.menu.getQuit()) {
			this.myFrame.dispose();
		}

		else if (e.getSource() == this.menu.getOption()) {
			//this.remove();
			this.addOption();
			// this.menu.repaint();
			// this.option.repaint();
			this.myFrame.getContentPane().repaint();
		}

		else if (e.getSource() == this.option.getSave() &&
			(this.option.getNoneWatch().isSelected() || this.option.getAbsoluteWatch().isSelected() || this.option.getByoYomiWatch().isSelected()) &&
			(this.option.getSize9().isSelected() || this.option.getSize13().isSelected() || this.option.getSize19().isSelected())) {
			
			if (this.option.getSize9().isSelected())
				this.parameter.setSize(9);
			else if (this.option.getSize13().isSelected())
				this.parameter.setSize(13);
			else 
				this.parameter.setSize(19);
			if (this.option.getNoneWatch().isSelected())
				this.parameter.setWatch(Watch.NONE);
			else if (this.option.getAbsoluteWatch().isSelected())
				this.parameter.setWatch(Watch.ABSOLUTE);
			else 
				this.parameter.setWatch(Watch.BYO_YOMI);
		}
		
		else if (e.getSource() == this.option.getBack()) {
			
		}
	}
}
