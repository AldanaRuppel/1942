package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class autoRemove  extends Thread{
	protected JLabel label;
	protected JPanel panel;
	
	public autoRemove( JLabel label, JPanel panel ) {
		this.label = label;
		this.panel = panel;
	}
	
	public void run() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.panel.remove(this.label);
		panel.repaint();

	}
}


