package Arma;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Laser extends Arma {
	
	public Laser (int x, int y) {
		
		
		danio=5;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/Laser.gif")));
		this.setBounds(x, y-(int)this.getIcon().getIconHeight(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	


}
