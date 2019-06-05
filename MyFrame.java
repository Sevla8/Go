import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		this.setSize(Define.myFramePreferredSize);
		this.setMinimumSize(Define.myFrameMinimumSize);
		this.setLocation(Define.myFrameLocation);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Go");
		// this.setLayout(null);		
	}
}
