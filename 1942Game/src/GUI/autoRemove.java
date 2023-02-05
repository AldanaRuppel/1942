package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Nivel;

public class autoRemove  extends Thread{
	protected JLabel label;
	protected JPanel panel;
	Nivel nivel = Nivel.getNivel();
	
	public autoRemove( JLabel label) {
		this.label = label;
		this.panel = nivel.juego.jPanelNivel;
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


